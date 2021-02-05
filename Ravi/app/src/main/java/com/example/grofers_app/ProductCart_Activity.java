package com.example.grofers_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.grofers_app.CartAdapters.CartResponse;
import com.example.grofers_app.CartAdapters.CartViewAdapter;
import com.example.grofers_app.adapter_holders.ProdectHomAdapter;
import com.example.grofers_app.adapter_holders.ResponseProdect;
import com.example.grofers_app.listners.FragmentCommunication;
import com.example.grofers_app.listners.OnListnerClick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ProductCart_Activity extends AppCompatActivity implements OnListnerClick,ListnerForRemove {
    private RecyclerView ProductRecyclerCart;
    private FragmentCommunication fragmentCommunication;
    private ProdectHomAdapter prodectHomAdapter;
    private List<ResponseProdect> responseProdectList = new ArrayList<>();
    private RecyclerView recyclerViewCart;
    private List<CartResponse> cartResponseList = new ArrayList<>();
    private CartViewAdapter cartViewAdapter;

    private int Mrp;
    private int Discount;
    private int Delivery = 49;
    private int Total;
    private int SellingPrice;
    private TextView myCartMRP;
    private TextView myCartProductDiscount;
    private TextView SubTotal;
    private TextView myCartCheckout;
    private Toolbar mbottomToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_cart_);

        initView();
        setData();

    }

    private void initView() {
        recyclerViewCart = findViewById(R.id.recyclerViewMyCart);
        ProductRecyclerCart = findViewById(R.id.recyclerViewMyCartProducts);
        myCartMRP = findViewById(R.id.MyCartMrp);
        myCartProductDiscount = findViewById(R.id.MyCartDisctount);
        SubTotal = findViewById(R.id.MyCartTotal);
        myCartCheckout = findViewById(R.id.MyCartCheckOut);
        mbottomToolbar=findViewById(R.id.Bottomtoolbar);
        mbottomToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProductCart_Activity.this,PaymentOptionActivity.class);
                intent.putExtra("total",SubTotal.getText().toString());
                startActivity(intent);
            }
        });

    }

    private void setData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        cartViewAdapter = new CartViewAdapter(cartResponseList,this);
        recyclerViewCart.setLayoutManager(linearLayoutManager);
        recyclerViewCart.setAdapter(cartViewAdapter);
        getDataFromMain();
        fetchResposeFromJsonAssets();

    }

    private void getDataFromMain() {
        if (getIntent() != null) {
            String name = getIntent().getStringExtra("name");
            String url = getIntent().getStringExtra("Url");
            String mrp = getIntent().getStringExtra("Mrp");
            String Selling = getIntent().getStringExtra("selling");
            String unit = getIntent().getStringExtra("unit");
            try {
                Mrp = NumberFormat.getInstance().parse(mrp).intValue();
                SellingPrice = NumberFormat.getInstance().parse(Selling).intValue();
            } catch (Exception e) {
                e.printStackTrace();
            }

            Discount = Mrp - SellingPrice;
            Total = SellingPrice + Delivery;
            cartResponseList.add(new CartResponse(url, name, Selling, mrp, unit));
            cartViewAdapter.notifyDataSetChanged();
            setAmount();
        }

    }

    private void setAmount() {
        myCartMRP.setText("\u20B9" + Mrp);
        myCartProductDiscount.setText("\u20B9" + Discount);
        SubTotal.setText("\u20B9" + Total);
        myCartCheckout.setText("\u20B9" + Total);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onPause();
    }

    private void fetchResposeFromJsonAssets() {
        try {
            InputStream inputStream = getAssets().open("Response.json");
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
        prodectHomAdapter = new ProdectHomAdapter(responseProdectList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        ProductRecyclerCart.setLayoutManager(layoutManager);
        ProductRecyclerCart.setAdapter(prodectHomAdapter);
    }

    private void buildPojoFromJson(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<ResponseProdect>>() {
        }.getType();
        responseProdectList = gson.fromJson(json, type);
        setRecyclerAdapter();
        prodectHomAdapter.notifyDataSetChanged();

    }

    @Override
    public void sendDataToDetails(ResponseProdect responseProdect, int position) {
    }

    @Override
    public void sendToCart(ResponseProdect responseProdect, int position) {
        cartResponseList.add(new CartResponse(responseProdect.getImage(),responseProdect.getTitle(), responseProdect.getSellingPrice(),responseProdect.getProductMRP(),responseProdect.getUnit()));
        try {
            Mrp = Mrp+NumberFormat.getInstance().parse(responseProdect.getProductMRP()).intValue();
            SellingPrice =SellingPrice + NumberFormat.getInstance().parse(responseProdect.getSellingPrice()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Discount = Mrp - SellingPrice;
        Total = Total+SellingPrice + Delivery;
        setAmount();
        cartViewAdapter.notifyItemChanged(position);
    }


    @Override
    public void removeItems(CartResponse cartResponse, int position) {
        cartResponseList.remove(position);
        try {
            Mrp = Mrp-NumberFormat.getInstance().parse(cartResponse.getProductMRP()).intValue();
            SellingPrice =SellingPrice-NumberFormat.getInstance().parse(cartResponse.getProductSellingPrice()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Discount =  Mrp - SellingPrice;
        Total = Total- (SellingPrice + Delivery);
        setAmount();
        cartViewAdapter.notifyDataSetChanged();
    }
}