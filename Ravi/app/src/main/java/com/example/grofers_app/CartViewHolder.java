package com.example.grofers_app;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CartViewHolder extends RecyclerView.ViewHolder {
    private ImageView mproductImage;
    private TextView mProductName;
    private TextView mSellingPrice;
    private TextView mProductPrice;
    private TextView mProductUnit;
    private ListnerForRemove listnerForRemove;
    private Button mbtRemoveCartIteam;
    public CartViewHolder(@NonNull View itemView,ListnerForRemove listnerForRemove) {
        super(itemView);
        this.listnerForRemove=listnerForRemove;
        initView();
    }

    private void initView() {
        mproductImage=itemView.findViewById(R.id.ivCartImage);
        mProductName=itemView.findViewById(R.id.tvCartProductName);
        mSellingPrice=itemView.findViewById(R.id.tvCartSelling);
        mProductPrice=itemView.findViewById(R.id.tvCartMrp);
        mProductUnit=itemView.findViewById(R.id.tvCartUnit);
        mbtRemoveCartIteam=itemView.findViewById(R.id.btRemoveCart);
    }
    public void setCartData(CartResponse cartData){
        mProductName.setText(cartData.getProductName());
        Glide.with(mproductImage).load(cartData.getImageUrl()).into(mproductImage);
        mSellingPrice.setText(cartData.getProductSellingPrice());
        mProductPrice.setText(cartData.getProductMRP());
        mProductUnit.setText(cartData.getProductUnit());
        mbtRemoveCartIteam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listnerForRemove.removeItems(cartData,getAdapterPosition());
            }
        });
    }
}
