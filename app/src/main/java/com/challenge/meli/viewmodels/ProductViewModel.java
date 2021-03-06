package com.challenge.meli.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.challenge.meli.domain.interfaces.ErrorCallback;
import com.challenge.meli.domain.models.Product;
import com.challenge.meli.infraestructure.repositories.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private ProductRepository productRepository = new ProductRepository();

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getAll(String name, ErrorCallback errorCallback) {
        return productRepository.getAll(name, errorCallback);
    }
}
