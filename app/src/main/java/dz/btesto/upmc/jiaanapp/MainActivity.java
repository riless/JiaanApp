package dz.btesto.upmc.jiaanapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.io.Serializable;

import dz.btesto.upmc.jiaanapp.entity.Recipe;
import dz.btesto.upmc.jiaanapp.services.ServicesAPI;


public class MainActivity extends AppCompatActivity {


    private TextView jsonRes ;
    private Button fetchBtn ;
    private Button autoBtn;

    final ServicesAPI servicesAPI = new ServicesAPI();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonRes = (TextView) findViewById(R.id.jsonTest);
        fetchBtn = (Button) findViewById(R.id.fetchBtn);
        autoBtn= (Button) findViewById(R.id.autoBtn);

        final Intent intent = new Intent(MainActivity.this, IngredientAuto.class);

        final Intent intent2 = new Intent(MainActivity.this, RecipesDetails.class);

        fetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            //    servicesAPI.getRecipesByIngredientss("apples,flour,sugar");

             //   Log.d("Canal", recipe.getImageUrl());
                intent2.putExtra("recipeID",  582367);
                startActivity(intent2);
            }
        });

        autoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });




    }


}