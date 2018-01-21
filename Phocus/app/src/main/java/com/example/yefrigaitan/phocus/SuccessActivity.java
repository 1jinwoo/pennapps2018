package com.example.yefrigaitan.phocus;



import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import java.util.prefs.PreferenceChangeEvent;
import org.w3c.dom.Text;

/**
 * Created by jackshi on 1/20/18.
 */

public class SuccessActivity extends AppCompatActivity {
    private static TextView streakText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        setStreak();
    }


    public void goToHome (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void setStreak(){
        streakText = (TextView) findViewById(R.id.streak);
        SharedPreferences myPreferences =
                PreferenceManager.getDefaultSharedPreferences(SuccessActivity.this);
        SharedPreferences.Editor myEditor = myPreferences.edit();
        //Log.d("get streak","get streak: " + streak);
        //add hour
        int streak = myPreferences.getInt("Streak", 0);
        //Log.d("hours",""+MainActivity.time);
        int put = streak + MainActivity.hour * 60 + MainActivity.minute;
        Log.d("streak",""+streak);
        Log.d("put",""+put);
        myEditor.putInt("Streak", put);
        myEditor.commit();
        streakText.setText("" + put);

    }

    public void onBackPressed(){
        // back button disabled
    }
}
