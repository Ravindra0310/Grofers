package com.example.grofers_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofers_app.adapter_holders.ProdectHomeViewHolder;
import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.example.grofers_app.listners.OnListnerClick;

import java.util.List;

public class GroceryAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private List<ResponseProdect> responseProdectList;
    private OnListnerClick onListnerClick;

    public GroceryAdapter(List<ResponseProdect> responseProdectList, OnListnerClick onListnerClick) {
        this.responseProdectList = responseProdectList;
        this.onListnerClick=onListnerClick;
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grocery_item_layout, parent, false);
        return new GroceryViewHolder(view,onListnerClick);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        holder.setDataForGroceryStaples(responseProdectList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseProdectList.size();
    }
}
