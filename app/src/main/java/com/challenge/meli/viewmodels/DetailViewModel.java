package com.challenge.meli.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.challenge.meli.domain.interfaces.ErrorCallback;
import com.challenge.meli.domain.models.Product;
import com.challenge.meli.infraestructure.repositories.ProductRepository;

public class DetailViewModel extends AndroidViewModel {

    private ProductRepository productRepository = new ProductRepository();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Product> getProduct(String idProduct, ErrorCallback errorCallback) {
        return productRepository.getProduct(idProduct, errorCallback);
    }

    public LiveData<String> getDescriptionProduct(String idProduct, ErrorCallback errorCallback) {
        return productRepository.getDescriptionProduct(idProduct, errorCallback);
    }
}
