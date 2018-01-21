package com.example.yefrigaitan.phocus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.content.Context;
import android.app.Dialog;

import java.util.Locale;


/**
 * Created by yefrigaitan on 1/20/18.
 */

public class PhocusMain extends AppCompatActivity {
    private long START_IN_MS = MainActivity.hour * 3600000 + MainActivity.minute * 60000;
    private TextView mTextViewCountdown;
    final Context context = this;
    private Button mButtonEStop;
    private CountDownTimer mCountDownTimer;
    private boolean running = true;
    private long timeLeftMS;
    private int updatedTimeLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phocus_main);

        mTextViewCountdown = findViewById(R.id.text_view_countdown);
        timeLeftMS = START_IN_MS;
        Log.d("debug", "time: " + timeLeftMS);
        startTimer();
        mButtonEStop = findViewById(R.id.button_stop);

        mButtonEStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {

                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.popup_one);
                Button dialogButtonNo = (Button) dialog.findViewById(R.id.dialogButtonNo);
                Button dialogButtonYes = (Button) dialog.findViewById(R.id.dialogButtonYes);


                // if button is clicked, close the custom dialog
                dialogButtonNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                // if button is clicked, go to shame
                dialogButtonYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(PhocusMain.this, ShameActivity.class);
                        startActivity(intent2);
                    }
                });


                dialog.show();
            }
        });
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(timeLeftMS, 1000) {
            @Override
            public void onTick(long msLeft) {
                timeLeftMS = msLeft;
                updateCountdownText();
            }

            @Override
            public void onFinish() {
                running = false;
            }
        }.start();

        running = true;

    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        running = false;

    }

<<<<<<< HEAD
    private void updateCountdownText() {
        int tempTimeLeft = (int) timeLeftMS;
        int hours = tempTimeLeft / 3600000;
        tempTimeLeft -= 3600000 * hours;
        int minutes = tempTimeLeft / 60000;
        tempTimeLeft -= 60000 * minutes;
        int seconds = tempTimeLeft / 1000;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", hours, minutes, seconds);
        mTextViewCountdown.setText(timeLeftFormatted);
    }

    public void onBackPressed() {
        // back button disabled
            Intent intent2 = new Intent(this, SuccessActivity.class);
            startActivity(intent2);
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_HOME) {
            Log.i("TEST", "Home Button");  // here you'll have to do something to prevent the button to go to the home screen
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

=======
    private void updateCountdownText () {
        updatedTimeLeft = (int) timeLeftMS;
        if (updatedTimeLeft==0) {
            testingToSuccess();
        }
        int hours = updatedTimeLeft / 3600000;
        updatedTimeLeft-= 3600000*hours;
        int minutes = updatedTimeLeft/ 60000;
        updatedTimeLeft -= 60000*minutes;
        int seconds = updatedTimeLeft/1000;
        String timeLeftFormatted = String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,seconds);
        mTextViewCountdown.setText(updatedTimeLeft);
    }


    public void testingToSuccess(){
        Intent intent2 = new Intent (this,SuccessActivity.class);
        startActivity(intent2);
>>>>>>> 446ed03b4e7844efd1cc0af0deac935635454198
    }
