package com.example.grofers_app.DiscountFragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.grofers_app.ProductCart_Activity;
import com.example.grofers_app.ProductDetailsActivity;
import com.example.grofers_app.R;
import com.example.grofers_app.listners.FragmentCommunication;
import com.google.android.material.tabs.TabLayout;

public class DicountMainActivity extends AppCompatActivity implements FragmentCommunication {

    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discount);

        viewPager = findViewById(R.id.FruitsviewPager);
        tabLayout = findViewById(R.id.FruitstabLayout);
        setViewPagerAdapter();


    }

    private void setViewPagerAdapter() {
        ViewPagerofDiscountAdapter viewPagerAdapter = new ViewPagerofDiscountAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public void commincation(Bundle bundle) {
        if (bundle != null) {
            Intent intent = new Intent(DicountMainActivity.this, ProductDetailsActivity.class);
            intent.putExtra("name", bundle.getString("name"));
            intent.putExtra("Url", bundle.getString("Url"));
            intent.putExtra("selling", bundle.getString("selling"));
            intent.putExtra("Mrp", bundle.getString("Mrp"));
            intent.putExtra("unit", bundle.getString("unit"));
            intent.putExtra("des", bundle.getString("des"));
            startActivity(intent);
        }
    }

    @Override
    public void sendTOCart(Bundle bundle) {
        if (bundle != null) {
            Intent intent = new Intent(DicountMainActivity.this, ProductCart_Activity.class);
            intent.putExtra("name", bundle.getString("name"));
            intent.putExtra("Url", bundle.getString("Url"));
            intent.putExtra("selling", bundle.getString("selling"));
            intent.putExtra("Mrp", bundle.getString("Mrp"));
            intent.putExtra("unit", bundle.getString("unit"));
            Toast.makeText(this,"Product is Added To Cart",Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
    }
}