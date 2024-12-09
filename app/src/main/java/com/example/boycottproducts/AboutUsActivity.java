package com.example.boycottproducts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        findViewById(R.id.call_to_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AboutUsActivity.this, ContactUsActivity.class));
                finish();
            }
        });
        //back button
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(AboutUsActivity.this, CategoryActivity.class);
                startActivity(intent2);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent2 = new Intent(this, CategoryActivity.class);
        startActivity(intent2);
        finish();
        return true;
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent2 = new Intent(this, CategoryActivity.class);
        startActivity(intent2);
        finish();

    }
}