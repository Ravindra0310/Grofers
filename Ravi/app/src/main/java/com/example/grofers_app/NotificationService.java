package com.example.grofers_app;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class NotificationService extends Service {
    Timer time;
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
        StopNotification();
    }

    private void StopNotification() {
        time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                stopSelf();
            }
        }, 40000);

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