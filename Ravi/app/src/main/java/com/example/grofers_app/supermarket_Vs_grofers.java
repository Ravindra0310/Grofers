package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class supermarket_Vs_grofers extends AppCompatActivity {

    private TextView mtvSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket__vs_grofers);
        mtvSkip=findViewById(R.id.tvSkip);
        mtvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(supermarket_Vs_grofers.this,LocationPermission.class);
                startActivity(intent1);

            }
        });
    }
}