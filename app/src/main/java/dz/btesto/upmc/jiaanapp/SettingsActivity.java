package dz.btesto.upmc.jiaanapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.yahoo.mobile.client.android.util.rangeseekbar.RangeSeekBar;

public class SettingsActivity extends AppCompatActivity {

    int maxCal;
    int minCal;
    int maxFat;
    int minFat;
    int maxProt;
    int minProt;

    private static final String PREFS = "PREFS";

    private static final String PREFS_MAX_CAL = "PREFS_MAX_CAL";
    private static final String PREFS_MIN_CAL = "PREFS_MIN_CAL";

    private static final String PREFS_MAX_FAT = "PREFS_MAX_FAT";
    private static final String PREFS_MIN_FAT = "PREFS_MIN_FAT";

    private static final String PREFS_MAX_PROT = "PREFS_MAX_PROT";
    private static final String PREFS_MIN_PROT = "PREFS_MIN_PROT";

    SharedPreferences sharedPreferences;

    Button saveButton;

    RangeSeekBar<Integer> seekBarCal ;
    RangeSeekBar<Integer> seekBarFat ;
    RangeSeekBar<Integer> seekBarProt ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        intiViews();
        seekBarCal.setRangeValues(0, 3000);
        sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);
        if (sharedPreferences.contains(PREFS_MAX_CAL)) {
            maxCal = sharedPreferences.getInt(PREFS_MAX_CAL, 0);
            minCal = sharedPreferences.getInt(PREFS_MIN_CAL, 0);
            seekBarCal.setSelectedMinValue(minCal);
            seekBarCal.setSelectedMaxValue(maxCal);
        }

            seekBarCal.setNotifyWhileDragging(true);
            seekBarCal.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                @Override
                public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                    maxCal = maxValue;
                    minCal = minValue;

                }
            });

            //-------------------------------------------------------------------------

            seekBarFat.setRangeValues(0, 100);
            //sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);
            if (sharedPreferences.contains(PREFS_MAX_FAT)) {
                maxFat = sharedPreferences.getInt(PREFS_MAX_FAT, 0);
                minFat = sharedPreferences.getInt(PREFS_MIN_FAT, 0);
                seekBarFat.setSelectedMinValue(minFat);
                seekBarFat.setSelectedMaxValue(maxFat);
            }
                seekBarFat.setNotifyWhileDragging(true);
                seekBarFat.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                    @Override
                    public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                        maxFat = maxValue;
                        minFat = minValue;

                    }
                });

                //--------------------------------------------------------------------------------------------------
                seekBarProt.setRangeValues(0, 100);
             //  sharedPreferences = getBaseContext().getSharedPreferences(PREFS, MODE_PRIVATE);
                if (sharedPreferences.contains(PREFS_MAX_PROT)) {
                    maxProt = sharedPreferences.getInt(PREFS_MAX_PROT, 0);
                    minProt = sharedPreferences.getInt(PREFS_MIN_PROT, 0);
                    seekBarProt.setSelectedMinValue(minProt);
                    seekBarProt.setSelectedMaxValue(maxProt);
                }
                    seekBarProt.setNotifyWhileDragging(true);
                    seekBarProt.setOnRangeSeekBarChangeListener(new RangeSeekBar.OnRangeSeekBarChangeListener<Integer>() {
                        @Override
                        public void onRangeSeekBarValuesChanged(RangeSeekBar<?> bar, Integer minValue, Integer maxValue) {
                            maxProt = maxValue;
                            minProt = minValue;

                        }
                    });


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPreferences
                        .edit()
                        .putInt(PREFS_MAX_CAL, maxCal)
                        .putInt(PREFS_MIN_CAL, minCal)
                        .putInt(PREFS_MAX_FAT, maxFat)
                        .putInt(PREFS_MIN_FAT, minFat)
                        .putInt(PREFS_MAX_PROT, maxProt)
                        .putInt(PREFS_MIN_PROT, minProt)
                        .apply();

                Log.d("Params", PREFS_MAX_CAL+maxCal + PREFS_MIN_CAL+minCal+
                        PREFS_MAX_FAT+ maxFat+PREFS_MIN_FAT+ minFat+
                        PREFS_MAX_PROT+ maxProt+ PREFS_MIN_PROT+ minProt);

            }

        });




    }


        public void intiViews () {
            saveButton = (Button) findViewById(R.id.saveBtn);
            seekBarCal = (RangeSeekBar) findViewById(R.id.rangeSeekbarCalories);
            seekBarFat = (RangeSeekBar) findViewById(R.id.rangeSeekbarFat);
            seekBarProt = (RangeSeekBar) findViewById(R.id.rangeSeekbarProtein);
        }

    }
