package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    private EditText metPhoneNumber;
    private Button metNext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        metPhoneNumber=findViewById(R.id.etPhoneNumber);
        metNext=findViewById(R.id.btnNext);
        metNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDataValid())
                {
                    //will got to home page
                    Intent intent1=new Intent();
                    startActivity(intent1);

                }
            }
        });



    }
    private boolean isDataValid()
    {
        Boolean isDataValid=true;

        if(metPhoneNumber.getText().toString().length()<10)
        {
            metPhoneNumber.setError("Number is invalid");
            isDataValid=false;
        }
        if(metPhoneNumber.getText().toString().length()>10)
        {
            metPhoneNumber.setError("Number is invalid");
            isDataValid=false;
        }
        return isDataValid;
    }
}