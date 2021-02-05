package com.example.grofers_app;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
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
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                Toast.makeText(PaymentOptionActivity.this, " Congratulations Payment successful Done", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(PaymentOptionActivity.this, NotificationService.class);
                                startService(intent);
                                Intent intent1 = new Intent(PaymentOptionActivity.this, Home_Activity.class);
                                startActivity(intent1);
                                finish();
                            }
                        });
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addNotification() {
        String channelId = "Ravi";
        String channelName = "Grofers";
        NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId);
        Notification notification = builder
                .setContentTitle("Payment Successfully")
                .setContentText("Your Order has been Placed ,You will receive your product as 3 hours from now")
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT)
                .build();
        notificationManager.notify(1, notification);
    }
}