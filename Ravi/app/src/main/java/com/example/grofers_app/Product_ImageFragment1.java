package com.example.grofers_app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Product_ImageFragment1 extends Fragment {
    String image1url;
    private ImageView imageView;
    private ProductDetailsActivity productDetailsActivity;

    public static Product_ImageFragment1 getInstance() {
        Product_ImageFragment1 product_imageFragment1 = new Product_ImageFragment1();

        return product_imageFragment1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product__image1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.ivProductImage1);
        setData();
    }


    private void setData() {
        ProductDetailsActivity data = (ProductDetailsActivity) getActivity();
        image1url = data.DataImageUrl;
        if (image1url != null) {
            Glide.with(imageView).load(image1url).into(imageView);
        }
    }
}