package com.example.grofers_app.DiscountFragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerofDiscountAdapter extends FragmentStatePagerAdapter{


    public ViewPagerofDiscountAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {



       switch (position) {
         case 0:
             return GroceryStaplesFragment.newInstance();
             case 1:
                 return HouseHoldFragment.newInstance();
                 case 2:
                     return PersonalCareFragment.newInstance();

                case 3:
                    return BiscuitsFragment.newInstance();


             case 4:
                 return VegetablesFruitsFragment.newInstance();

                 case 5:
                return BooksStationaryFragment.newInstance();


        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        String tabName = "";
        switch (position) {
            case 0:
                tabName = "Grocery &Staples";
                break;
            case 1:
                tabName = "Household Items";
                break;
            case 2:
                tabName = "Personal Care";
                break;
            case 3:
                tabName = "Biscuits,Snacks & Chocolates";
                break;
            case 4:
               tabName = "Vegetables & Fruits";
               break;
            case 5:
                tabName="Books Store";
                break;

        }
        return tabName;
    }



    @Override
    public int getCount() {
        return 6;
    }
}






