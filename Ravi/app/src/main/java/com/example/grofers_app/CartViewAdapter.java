package com.example.grofers_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartViewAdapter extends RecyclerView.Adapter<CartViewHolder> {

    private List<CartResponse> cartResponseList;
    private ListnerForRemove listnerForRemove;

    public CartViewAdapter(List<CartResponse> cartResponseList,ListnerForRemove listnerForRemove) {
        this.cartResponseList = cartResponseList;
        this.listnerForRemove=listnerForRemove;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_iteams, parent, false);
        return new CartViewHolder(view,listnerForRemove);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        holder.setCartData(cartResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return cartResponseList.size();
    }
}
