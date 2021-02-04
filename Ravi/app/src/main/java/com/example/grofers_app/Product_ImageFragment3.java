package com.example.grofers_app;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Product_ImageFragment3 extends Fragment {
  private String image3url;
    private ImageView imageView;
    public static Product_ImageFragment3 getInstance() {
        Product_ImageFragment3 product_imageFragment3 = new Product_ImageFragment3();
        return product_imageFragment3;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product__image3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView=view.findViewById(R.id.ivProductImage3);
        setData();
    }

    private void setData() {
        ProductDetailsActivity data = (ProductDetailsActivity) getActivity();
        image3url = data.DataImageUrl;
        if (image3url != null) {
            Glide.with(imageView).load(image3url).into(imageView);
        }
    }
    }
