package com.example.grofers_app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationService extends Service {
    public NotificationService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            creteNotification();
        }else {
            startForeground(2,new Notification());
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void creteNotification() {
        String channelId = "Ravi";
        String channelName = "Grofers";
        NotificationChannel channel=new NotificationChannel(channelId,channelName, NotificationManager.IMPORTANCE_DEFAULT);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,channelId);
        Notification notification=builder
                .setTimeoutAfter(30)
                .setSmallIcon(R.drawable.groferslogo)
                .setContentTitle("Payment Successfully")
                .setAutoCancel(true)
                .setContentText("Your Order has been Placed ,You will receive your product as 3 hours from now")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Your Order has been Placed ,You will receive your product as 3 hours from now. Thank You For Shopping with Grofers"))
                .setPriority(NotificationManager.IMPORTANCE_DEFAULT)

                .build();
        startForeground(1,notification);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}