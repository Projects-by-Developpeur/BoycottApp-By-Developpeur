package com.example.boycottproducts;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.window.OnBackInvokedDispatcher;

public class ClothesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);


        findViewById(R.id.more).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + Uri.encode("contact.developpeur27@gmail.com")));
                intent.setPackage("com.google.android.gm"); // Specify Gmail package
                startActivity(intent);
   }
        });

        //back button
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(ClothesActivity.this, CategoryActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
 super.onBackPressed();
        Intent i =new Intent(ClothesActivity.this,CategoryActivity.class);
        startActivity(i);
        finish();
    }

}