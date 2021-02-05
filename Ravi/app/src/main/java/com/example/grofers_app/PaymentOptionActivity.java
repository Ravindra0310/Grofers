package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentOptionActivity extends AppCompatActivity {
    private TextView mtvTotalPayment;
    private TextView mtvcompletePayment;
    private LinearLayout mtvpaytm;
    private TextView mtvpayzapp;
    private TextView mtvcash;
    private RelativeLayout mtvmobi;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        initView();
        getData();
        onclick();
    }

    private void onclick() {
        mtvpaytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appPackageName = "net.one97.paytm";
                PackageManager pm = getApplicationContext().getPackageManager();
                Intent appstart = pm.getLaunchIntentForPackage(appPackageName);
                if (null != appstart) {
                    getApplicationContext().startActivity(appstart);
                } else {
                    Toast.makeText(getApplicationContext(), "Install PayTm on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mtvmobi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appPackageName = "com.mobikwik_new";
                PackageManager pm = getApplicationContext().getPackageManager();
                Intent appstart = pm.getLaunchIntentForPackage(appPackageName);
                if (null != appstart) {
                    getApplicationContext().startActivity(appstart);
                } else {
                    Toast.makeText(getApplicationContext(), "Install Mobikwik on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mtvpayzapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String appPackageName = "com.enstage.wibmo.hdfc";
                PackageManager pm = getApplicationContext().getPackageManager();
                Intent appstart = pm.getLaunchIntentForPackage(appPackageName);
                if (null != appstart) {
                    getApplicationContext().startActivity(appstart);
                } else {
                    Toast.makeText(getApplicationContext(), "Install payzapp on your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
        mtvcompletePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlirtBox();
            }
    });
        mtvcash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlirtBox();
            }
        });
    }

    private void AlirtBox() {
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(PaymentOptionActivity.this);
        builder.setMessage("Complete the Transaction");
        builder.setTitle("Payment Alert");
        builder.setCancelable(false);
        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(PaymentOptionActivity.this, " Congratulations Payment successful Done", Toast.LENGTH_LONG).show();
                                finish();
                            }
                        });
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(PaymentOptionActivity.this, "Payment Failed", Toast.LENGTH_LONG).show();
                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    private void getData() {
        mtvTotalPayment.setText(getIntent().getStringExtra("total"));
    }

    private void initView() {
        mtvTotalPayment = findViewById(R.id.tvPaymentTotal);
        mtvpayzapp = findViewById(R.id.tvPayzapp);
        mtvpaytm = findViewById(R.id.paytmCard);
        mtvmobi = findViewById(R.id.mobikwik);
        mtvcash = findViewById(R.id.tvcash);
        mtvcompletePayment = findViewById(R.id.tvpaymentTOcomplate);
    }

}