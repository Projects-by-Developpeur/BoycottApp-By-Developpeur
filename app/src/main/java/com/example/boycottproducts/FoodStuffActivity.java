package com.example.boycottproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class FoodStuffActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stuff);


        //back button
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(FoodStuffActivity.this, CategoryActivity.class);
                startActivity(intent2);
                finish();
            }
        });


        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + Uri.encode("contact.developpeur27@gmail.com")));
                intent.setPackage("com.google.android.gm"); // Specify Gmail package
                startActivity(intent);
            }
    }); }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FoodStuffActivity.this, CategoryActivity.class);
        startActivity(intent);
        finish();
    }

}