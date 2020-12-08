package com.example.floradanfauna.ui.fauna;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FaunaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FaunaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Fauna fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}