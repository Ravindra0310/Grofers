package com.example.grofers_app;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter{

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Product_ImageFragment1.getInstance();
            case 1:
                return Product_ImageFragment2.getInstance();
            case 2:
                return Product_ImageFragment3.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
