package com.challenge.meli.infraestructure.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.challenge.meli.domain.models.Product;
import com.challenge.meli.infraestructure.api.ApiMeLi;
import com.challenge.meli.infraestructure.api.MeliCallback;

import java.util.List;

public class ProductRepository {

    private ApiMeLi apiMeLi = new ApiMeLi();

    public LiveData<List<Product>> getAll(String idProduct) {

        MutableLiveData<List<Product>> products = new MutableLiveData<>();
        apiMeLi.getAll(idProduct, new MeliCallback<List<Product>>() {
            @Override
            public void success(List<Product> response) {
                products.setValue(response);
            }

            @Override
            public void error(Throwable throwable, int code) {
                products.setValue(null);
            }
        });
        return products;
    }
}
