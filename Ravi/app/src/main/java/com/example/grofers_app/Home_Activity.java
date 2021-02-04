package com.example.grofers_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.grofers_app.listners.FragmentCommunication;
import com.google.android.material.navigation.NavigationView;


import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Home_Activity extends AppCompatActivity implements FragmentCommunication {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void commincation(Bundle bundle) {
        if (bundle != null) {
            Intent intent = new Intent(Home_Activity.this, ProductDetailsActivity.class);
            intent.putExtra("name", bundle.getString("name"));
            intent.putExtra("Url", bundle.getString("Url"));
            intent.putExtra("Selling", bundle.getString("selling"));
            intent.putExtra("Mrp", bundle.getString("Mrp"));
            intent.putExtra("unit", bundle.getString("unit"));
            intent.putExtra("des", bundle.getString("des"));
            startActivity(intent);
        }
    }

    @Override
    public void sendTOCart(Bundle bundle) {
        if (bundle != null) {
            Intent intent = new Intent(Home_Activity.this, ProductCart_Activity.class);
            intent.putExtra("name", bundle.getString("name"));
            intent.putExtra("Url", bundle.getString("Url"));
            intent.putExtra("Selling", bundle.getString("selling"));
            intent.putExtra("Mrp", bundle.getString("Mrp"));
            intent.putExtra("unit", bundle.getString("unit"));
            startActivity(intent);
        }
    }
}