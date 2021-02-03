package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class ProductDetailsActivity extends AppCompatActivity {

    String DataImageUrl;
    private TextView mtvProductName;
    private TextView mtvProductsellingPrice;
    private TextView mtvProductPrice;
    private TextView mtvProductUnit;
    private TextView mtvProductDescription;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        init();
        getDataOfProduct();
        setViewPagerAdapter();

    }

    private void getDataOfProduct() {
        if(getIntent()!=null){
            DataImageUrl= getIntent().getStringExtra("Url");
            String name=getIntent().getStringExtra("name");
            mtvProductName.setText(name);
            String mrp=getIntent().getStringExtra("Mrp");
            mtvProductPrice.setText(mrp);
            String selling=getIntent().getStringExtra("Selling");
            mtvProductsellingPrice.setText(selling);
            String unit=getIntent().getStringExtra("unit");
            mtvProductUnit.setText(unit);
            String des=getIntent().getStringExtra("des");
            mtvProductDescription.setText(des);
        }
    }

    private void setViewPagerAdapter() {
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void init() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tablayout);
        mtvProductName=findViewById(R.id.tvProductPageTitle);
        mtvProductPrice=findViewById(R.id.tvShowMRPofProduct);
        mtvProductsellingPrice=findViewById(R.id.tvShowSellingPrice);
        mtvProductUnit=findViewById(R.id.tvShowUint);
        mtvProductDescription=findViewById(R.id.tvShowDescription);
    }
}