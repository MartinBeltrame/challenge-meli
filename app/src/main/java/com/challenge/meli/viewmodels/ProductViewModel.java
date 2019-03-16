package com.challenge.meli.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.challenge.meli.domain.models.Product;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getAll(String idProduct) {
        return null;
    }
}
