package com.example.grofers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.LoggingPermission;

public class LocationPermission extends AppCompatActivity {
    private static final int REQ_CODE = 1;
    Timer timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_permission);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ActivityCompat.requestPermissions(LocationPermission.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_CODE);

            }
        }, 3000);

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE:
                if (grantResults.length == 1) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        showToast("Location Permission Granted");
                        Intent intent1 = new Intent(LocationPermission.this, Login.class);
                        startActivity(intent1);

                    } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(LocationPermission.this, permissions[0])) {
                            showToast("Permission denied");
                            ActivityCompat.requestPermissions(LocationPermission.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQ_CODE);


                        } else {
                            showToast("Permission denied by clicking Dont show again,please go to setting and enable the permission");
                            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                            Uri uri = Uri.fromParts("package", getPackageName(), null);
                            intent.setData(uri);
                            startActivity(intent);
                        }

                    }
                }

        }


    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}