package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.example.grofers_app.listners.OnListnerClick;

import java.util.ArrayList;
import java.util.List;

public class ProductCart_Activity extends AppCompatActivity  {
private RecyclerView recyclerViewCart;
private List<CartResponse> cartResponseList=new ArrayList<>();
private CartViewAdapter cartViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_cart_);
        recyclerViewCart=findViewById(R.id.recyclerCart);
        setData();
    }

    private void setData() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        cartViewAdapter=new CartViewAdapter(cartResponseList);
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        recyclerViewCart.setAdapter(cartViewAdapter);
        getDataFromMain();
    }

    private void getDataFromMain() {
        if(getIntent()!=null) {
            String name = getIntent().getStringExtra("name");
            String url = getIntent().getStringExtra("Url");
            String mrp = getIntent().getStringExtra("Mrp");
            String selling = getIntent().getStringExtra("selling");
            String unit = getIntent().getStringExtra("unit");
            cartResponseList.add(new CartResponse(url,name,selling,mrp,unit));
            cartViewAdapter.notifyDataSetChanged();

        }
    }
}