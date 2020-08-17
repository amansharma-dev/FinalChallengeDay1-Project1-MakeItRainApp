package com.example.finalchallengeday1_project1_makeitrainapp;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity{

    public static final String TAG = "MAIN ACTIVITY";
    private TextView amountTv;
    private int amountCounter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTv = findViewById(R.id.textAmount_tV);
    }


    public void makeItRainBtn(View view){
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        amountCounter +=1000;
        amountTv.setText(numberFormat.format(amountCounter));
        Log.d(TAG, "makeItRainBtn: latest amount after on Click"+amountCounter);
        switch (amountCounter){
            case 5000:
                Log.d(TAG, "makeItRainBtn: color change at 5000");
                amountTv.setTextColor(getResources().getColor(R.color.stage1));
                break;

            case 10000:
                Log.d(TAG, "makeItRainBtn: color change at 10,000");
                amountTv.setTextColor(getResources().getColor(R.color.stage2));
                break;

            case 15000:
                Log.d(TAG, "makeItRainBtn: color change at 15,000");
                amountTv.setTextColor(getResources().getColor(R.color.stage3));
        }

    }


    public void toastMessageBtn(View view) {
        Toast.makeText(getApplicationContext(),getString(R.string.toastMessage)+amountCounter,Toast.LENGTH_LONG).show();
    }

    public void logMessageBtn(View view){
        Log.d(TAG, "logMessageBtn: current amount is: "+amountCounter);
    }
}