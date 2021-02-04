package com.example.grofers_app.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grofers_app.listners.FragmentCommunication;
import com.example.grofers_app.listners.OnListnerClick;
import com.example.grofers_app.adapter_holders.ProdectHomAdapter;
import com.example.grofers_app.FragmentCommunication;
import com.example.grofers_app.OnListnerClick;
import com.example.grofers_app.ProdectHomAdapter;
import com.example.grofers_app.R;
import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements OnListnerClick {

    private RecyclerView HomerecyclerView;
    private FragmentCommunication fragmentCommunication;
    private HomeViewModel homeViewModel;
    private ProdectHomAdapter prodectHomAdapter;
    private List<ResponseProdect>responseProdectList=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                
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
        HomerecyclerView=view.findViewById(R.id.recyclerViewHomePage);
    }

    private void fetchResposeFromJsonAssets() {
        try {
            InputStream inputStream=getContext().getAssets().open("Response.json");
            int data=inputStream.read();
            StringBuffer stringBuffer=new StringBuffer();
            while (data!=-1){
                char ch= (char) data;
                stringBuffer.append(ch);
                data=inputStream.read();
            }
            buildPojoFromJson(stringBuffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void setRecyclerAdapter() {
        prodectHomAdapter=new ProdectHomAdapter(responseProdectList,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        HomerecyclerView.setLayoutManager(layoutManager);
        HomerecyclerView.setAdapter(prodectHomAdapter);
    }

    private void buildPojoFromJson(String json) {
        Gson gson=new Gson();
        Type type=new TypeToken<List<ResponseProdect>>(){}.getType();
        responseProdectList=gson.fromJson(json,type);
        setRecyclerAdapter();
        prodectHomAdapter.notifyDataSetChanged();

    }


    @Override
    public void sendDataToDetails(ResponseProdect responseProdect, int position) {
        Bundle bundle=new Bundle();
        bundle.putString("name",responseProdect.getTitle());
        bundle.putString("Url",responseProdect.getImage());
        bundle.putString("selling",responseProdect.getSellingPrice());
        bundle.putString("Mrp",responseProdect.getProductMRP());
        bundle.putString("unit",responseProdect.getUnit());
        bundle.putString("des",responseProdect.getDescription());
        fragmentCommunication.commincation(bundle);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentCommunication= (FragmentCommunication) context;
    }
}