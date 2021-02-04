package com.example.grofers_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GroceryStaplesFragment extends Fragment {

    public GroceryStaplesFragment(){

    }

    public static Fragment newInstance() {
        GroceryStaplesFragment groceryStaplesFragment=new GroceryStaplesFragment();
      return groceryStaplesFragment;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_grocery_staples, container, false);

    }
}