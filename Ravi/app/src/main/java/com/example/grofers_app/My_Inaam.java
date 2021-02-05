package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class My_Inaam extends AppCompatActivity {
    private Button btnStartShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__inaam);
        btnStartShopping=findViewById(R.id.btnStartShopping);
        btnStartShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(My_Inaam.this,Home_Activity.class);
                startActivity(intent1);
            }
        });
    }
}