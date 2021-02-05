package com.example.grofers_app;

import com.example.grofers_app.CartAdapters.CartResponse;

public interface ListnerForRemove {
    void removeItems(CartResponse cartResponse, int position);
}
