package com.example.grofers_app.listners;

import com.example.grofers_app.adapter_holders.ResponseProdect;

public interface OnListnerClick {
    void sendDataToDetails(ResponseProdect responseProdect, int position);
    void sendToCart(ResponseProdect responseProdect, int position);
}
