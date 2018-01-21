package com.example.yefrigaitan.phocus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by jackshi on 1/20/18.
 */

public class ShameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shame);
    }

    public void toHome (View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
