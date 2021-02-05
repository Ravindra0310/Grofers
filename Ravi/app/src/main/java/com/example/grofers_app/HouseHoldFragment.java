package com.example.grofers_app;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.example.grofers_app.listners.OnListnerClick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class HouseHoldFragment extends Fragment implements OnListnerClick {
    private RecyclerView HouseRecyclerView;
    private GroceryAdapter groceryAdapter;
    private GroferDiscountModel groferDiscountModel;
    private List<ResponseProdect> responseProdectList = new ArrayList<>();


    public HouseHoldFragment(){

    }

   public static Fragment newInstance() {
       HouseHoldFragment houseHoldFragment=new HouseHoldFragment();
       return houseHoldFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        groferDiscountModel = new ViewModelProvider(this).get(GroferDiscountModel.class);

        View root = inflater.inflate(R.layout.fragment_house_hold, container, false);
        groferDiscountModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@NonNull String s) {

            }
        });
        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        fetchResposeFromJsonAssets();
    }

    private void initView(View view) {
        HouseRecyclerView = view.findViewById(R.id.HouseHoldRecycleView);

    }

    private void fetchResposeFromJsonAssets() {

        try {
            InputStream inputStream = getContext().getAssets().open("Response.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }
            buildPojoFromJson(stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setRecyclerAdapter() {
        groceryAdapter = new GroceryAdapter(responseProdectList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        HouseRecyclerView.setLayoutManager(layoutManager);
        HouseRecyclerView.setAdapter(groceryAdapter);
    }


    private void buildPojoFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ResponseProdect>>() {
        }.getType();
        responseProdectList = gson.fromJson(json, type);
        setRecyclerAdapter();
        groceryAdapter.notifyDataSetChanged();

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }





    @Override
    public void sendDataToDetails(ResponseProdect responseProdect, int position) {

    }

    @Override
    public void sendToCart(ResponseProdect responseProdect, int position) {

    }
}