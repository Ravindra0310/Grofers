package com.example.grofers_app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BooksStationaryFragment extends Fragment {

    public BooksStationaryFragment() {

    }


    public static Fragment newInstance() {

        BooksStationaryFragment booksStationaryFragment = new BooksStationaryFragment();
        return booksStationaryFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_books_stationary, container, false);

    }
}
