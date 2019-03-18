package com.challenge.meli.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.challenge.meli.domain.models.Product;

public class DetailViewModel extends AndroidViewModel {

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Product> getProduct(String idProduct) {
        return null;
    }
}
