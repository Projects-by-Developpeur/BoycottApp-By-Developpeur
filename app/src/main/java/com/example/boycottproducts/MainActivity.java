package com.example.boycottproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
                                      @Override
                                      public void run() {

                                          Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                                          startActivity(intent);
                                          finish();
                                      }
                                  }

                , SPLASH_TIME_OUT);


    }
}