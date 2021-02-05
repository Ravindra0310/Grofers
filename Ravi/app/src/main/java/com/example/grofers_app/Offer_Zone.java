package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Offer_Zone extends AppCompatActivity {
    private ImageView imHygiene;
    private ImageView imEPaper;
    private ImageView imAxisBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer__zone);
        initViews();
    }

    private void initViews() {
        imHygiene = findViewById(R.id.imHygiene);
        imEPaper = findViewById(R.id.imEPaper);
        imAxisBank = findViewById(R.id.imAxisBank);
        imEPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Offer_Zone.this, websites.class);
                intent.putExtra("websites", "https://accounts.hindustantimes.com/ht/grofers");
                startActivity(intent);

            }
        });

    }
}