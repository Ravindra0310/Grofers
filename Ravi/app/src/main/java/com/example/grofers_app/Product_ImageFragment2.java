package com.example.grofers_app;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Product_ImageFragment2 extends Fragment {
    private String image2url;
    private ImageView imageView;
    public static Product_ImageFragment2 getInstance() {
        Product_ImageFragment2 product_imageFragment2 = new Product_ImageFragment2();
        return product_imageFragment2;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product__image2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView=view.findViewById(R.id.ivProductImage2);
        setData();
    }

    private void setData() {
        ProductDetailsActivity data = (ProductDetailsActivity) getActivity();
        image2url = data.DataImageUrl;
        if (image2url != null) {
           Glide.with(imageView).load(image2url).into(imageView);
        }
    }
    }
