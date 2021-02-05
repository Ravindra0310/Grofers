package com.example.grofers_app.DiscountFragments;

import android.graphics.ColorSpace;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroferDiscountModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroferDiscountModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Grocery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}



