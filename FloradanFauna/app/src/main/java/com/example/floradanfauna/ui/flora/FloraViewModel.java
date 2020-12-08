package com.example.floradanfauna.ui.flora;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FloraViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FloraViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("isi data flora");
    }

    public LiveData<String> getText() {
        return mText;
    }
}