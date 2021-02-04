package com.example.grofers_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class VegetablesFruitsFragment extends Fragment {

    public  VegetablesFruitsFragment(){

    }





    public static Fragment newInstance() {
        VegetablesFruitsFragment vegetablesFruitsFragment = new VegetablesFruitsFragment();
        return vegetablesFruitsFragment;
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vegetables_fruits, container, false);

    }
}