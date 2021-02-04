package com.example.grofers_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BiscuitsFragment extends Fragment {




    public BiscuitsFragment() {

    }

    public static Fragment newInstance() {
        BiscuitsFragment biscuitsFragment=new BiscuitsFragment();
       return biscuitsFragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_biscuits, container, false);

    }
}