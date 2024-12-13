package com.example.boycottproducts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class CosmeticActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetic);
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
                Intent intent2 = new Intent(CosmeticActivity.this, CategoryActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(CosmeticActivity.this, CategoryActivity.class);
        startActivity(i);
        finish();


    }
}
