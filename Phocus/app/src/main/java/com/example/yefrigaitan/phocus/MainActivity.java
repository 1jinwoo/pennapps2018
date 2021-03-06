package com.example.yefrigaitan.phocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static int minute, hour;

    private static SeekBar hourBar;
    private static SeekBar minuteBar;
    private static TextView showHour;
    private static TextView showMinute;
    public static int time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phocus_setup);
        setSeekBar();
    }

    public void setSeekBar() {
        hourBar = (SeekBar) findViewById(R.id.seekBarHour);
        minuteBar = (SeekBar) findViewById(R.id.seekBarMinute);
        showHour = (TextView) findViewById(R.id.showTextHours);
        showMinute = (TextView) findViewById(R.id.showTextMinutes);
        hourBar.setMax(8); // set max hours to 8
        minuteBar.setMax(59); // set max minutes to 59


        hourBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        showHour.setText(" " + progress);
                        time += progress * 60;
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }


                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );


        minuteBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        time += progress;
                        showMinute.setText(" " + progress);
                    }

                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }

                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                }
        );

    }



    public void goToHome (View view) {
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}