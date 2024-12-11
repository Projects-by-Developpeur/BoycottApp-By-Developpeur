package com.example.boycottproducts;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {
    boolean doubleBackToExitPressedOnce = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ImageView noteMenu = findViewById(R.id.settings);
        noteMenu.setOnClickListener(v -> showPopupMenu(v));

        findViewById(R.id.food).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, FoodStuffActivity.class));
                finish();
            }
        });
        findViewById(R.id.detergent).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, DetergentActivity.class));
                finish();
            }
        });

        findViewById(R.id.cosmetic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, CosmeticActivity.class));
                finish();
            }
        });

        findViewById(R.id.clothes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CategoryActivity.this, ClothesActivity.class));
                finish();
            }
        });


    }

    public void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.note_menu, popupMenu.getMenu());

        // Set RTL layout direction if required
        popupMenu.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.nav_about_us) {
                startActivity(new Intent(CategoryActivity.this, AboutUsActivity.class));
                finish();
                return true;
            } else if (item.getItemId() == R.id.nav_contact_us) {
                startActivity(new Intent(CategoryActivity.this, ContactUsActivity.class));
                finish();
                return true;
            } else if (item.getItemId() == R.id.nav_share) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = "Check out this app!";
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Boycott Products");
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(shareIntent, "Share via"));
                return true;
            } else if (item.getItemId() == R.id.nav_exit) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(CategoryActivity.this);
                mBuilder.setTitle("هل تود الخروج من التطبيق؟")
                        .setIcon(R.drawable.logout)
                        .setPositiveButton("لا", (dialog, which) -> dialog.dismiss())
                        .setNegativeButton("نعم", (dialog, which) -> finishAffinity())
                        .show();
                return true;
            }
            return false;
        });

        popupMenu.show();
    }

    //to quit the app
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed(); // This will exit the app
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "اضغط مرة أخرى للخروج من التطبيق", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false; // Reset the flag after 2 seconds
            }
        }, 2000); // 2 seconds delay
    }


}

