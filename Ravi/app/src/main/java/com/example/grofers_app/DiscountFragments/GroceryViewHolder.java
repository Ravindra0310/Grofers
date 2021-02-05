package com.example.grofers_app.DiscountFragments;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grofers_app.R;
import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.example.grofers_app.listners.OnListnerClick;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    private  OnListnerClick onListnerClick;
    private ImageView mproductDiscountImage;
    private TextView mProductDiscountName;
    private TextView mSellingDiscountPrice;
    private TextView mProductDiscountPrice;
    private TextView mProductDiscountUnit;
    private CardView carddView;
    private Button mBtnAdd;


    public GroceryViewHolder(@NonNull View itemView, OnListnerClick onListnerClick) {
        super(itemView);
        this.onListnerClick=onListnerClick;
        initViews();
    }


    private void initViews() {
        mproductDiscountImage=itemView.findViewById(R.id.GroceryImage);
        mProductDiscountName=itemView.findViewById(R.id.GroceryItemName);
        mSellingDiscountPrice=itemView.findViewById(R.id.GroceryMRPPrice);
        mProductDiscountPrice=itemView.findViewById(R.id.GroceryPrice);
        mProductDiscountUnit=itemView.findViewById(R.id.GroceryUnitName);
        mBtnAdd=itemView.findViewById(R.id.ItemButton);
        carddView=itemView.findViewById(R.id.CardViewesDiscount);



    }

    public void setDataForGroceryStaples(ResponseProdect responseProdect) {
        Glide.with(mproductDiscountImage).load(responseProdect.getImage()).into(mproductDiscountImage);
        mProductDiscountName.setText(responseProdect.getTitle());
        mSellingDiscountPrice.setText("\u20B9"+responseProdect.getSellingPrice());
        mProductDiscountPrice.setText("\u20B9"+responseProdect.getProductMRP());
        mProductDiscountUnit.setText(responseProdect.getUnit());
        carddView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListnerClick.sendDataToDetails(responseProdect,getAdapterPosition());
            }
        });
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onListnerClick.sendToCart(responseProdect,getAdapterPosition());
            }
        });
    }

}
