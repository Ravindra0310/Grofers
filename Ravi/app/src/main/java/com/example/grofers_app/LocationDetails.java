package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LocationDetails extends AppCompatActivity {
private EditText mAddAddress;
private TextView mRecent;
private String Address;
private Button mbtuselocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_details);
        init();
        setData();
    }

    private void setData() {
    mbtuselocation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Address=mAddAddress.getText().toString();
            mRecent.setText(Address);
            Intent intent1=new Intent(LocationDetails.this,Home_Activity.class);
            intent1.putExtra("address",Address);
            startActivity(intent1);
        }
    });
    }



    private void init() {
        mAddAddress=findViewById(R.id.etLocation);
        mRecent=findViewById(R.id.Setlocation);
        mbtuselocation=findViewById(R.id.UseLocation);
    }


}
