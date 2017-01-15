package dz.btesto.upmc.jiaanapp.fragments.homeFragment.byIngredientsRecipes;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import dz.btesto.upmc.jiaanapp.R;
import dz.btesto.upmc.jiaanapp.activities.recipesDetails.RecipesDetails;
import dz.btesto.upmc.jiaanapp.entity.DisplayingRecipe;

/**
 * -------------------------
 * ### JI3AN APPLICATION ###
 * -------------------------
 * <p>
 * Created by :
 * ------------
 * ++ Nour Elislam SAIDI
 * ++ Mohamed Tayeb BENTERKI
 * <p>
 * ------ 2016-2017 --------
 */
public class ByIngredientsRecipesAdapter extends RecyclerView.Adapter<ByIngredientsRecipesAdapter.RecipesViewHolder> {

    private List<DisplayingRecipe> recipes;
    private Context context;

    public ByIngredientsRecipesAdapter(List<DisplayingRecipe> recipes, Context context) {
        this.recipes = recipes;
        this.context = context;
    }

    public static class RecipesViewHolder extends RecyclerView.ViewHolder {
        CardView recipeCardView;
        TextView title;
        ImageView thumbnail;
        TextView idRecipe;

        RecipesViewHolder(View itemView) {
            super(itemView);
            recipeCardView = (CardView) itemView.findViewById(R.id.card_recipe);
            title = (TextView) itemView.findViewById(R.id.title_recipe);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail_recipe);
            idRecipe = (TextView) itemView.findViewById(R.id.idRecipe);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_recipe_home, parent, false);
        RecipesViewHolder recipesViewHolder = new RecipesViewHolder(view);
        return recipesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        final DisplayingRecipe recipe = recipes.get(position);
        holder.title.setText(recipe.getTitle());
        holder.idRecipe.setText(String.valueOf(recipe.getRecipeId()));
        Glide.with(context)
                .load(recipe.getImageUrl())
                //.override(400, 300)
                .centerCrop()
                .into(holder.thumbnail);

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RecipesDetails.class);
                intent.putExtra("recipeID", recipe.getRecipeId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }


}
