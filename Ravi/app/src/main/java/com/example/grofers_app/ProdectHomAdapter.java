package com.example.grofers_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProdectHomAdapter extends RecyclerView.Adapter<ProdectHomeViewHolder> {
    private List<ResponseProdect> responseProdectList;
    private OnListnerClick onListnerClick;

    public ProdectHomAdapter(List<ResponseProdect> responseProdectList,OnListnerClick onListnerClick) {
        this.responseProdectList = responseProdectList;
        this.onListnerClick=onListnerClick;
    }

    @NonNull
    @Override
    public ProdectHomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_iteam_layout, parent, false);
        return new ProdectHomeViewHolder(view,onListnerClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdectHomeViewHolder holder, int position) {
        holder.setDataForHome(responseProdectList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseProdectList.size();
    }
}
