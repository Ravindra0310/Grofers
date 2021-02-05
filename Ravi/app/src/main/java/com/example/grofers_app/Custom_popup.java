package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Custom_popup extends AppCompatActivity {
    private ImageView mImMeh;
    private ImageView mImLovedIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_popup);
        mImMeh = findViewById(R.id.imMeh);
        mImLovedIt = findViewById(R.id.imLovedIt);

        mImMeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Custom_popup.this, "Help us do better", Toast.LENGTH_SHORT).show();
            }
        });

        mImLovedIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Custom_popup.this, "Mind giving us a 5 star on google play?", Toast.LENGTH_SHORT).show();
            }
        });
    }
}