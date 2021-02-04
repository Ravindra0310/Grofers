package com.example.grofers_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class PersonalCareFragment extends Fragment {


    public PersonalCareFragment(){

    }


    public static Fragment newInstance() {
        PersonalCareFragment personalCareFragment=new PersonalCareFragment();
        return personalCareFragment ;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_personal_care, container, false);

    }
}