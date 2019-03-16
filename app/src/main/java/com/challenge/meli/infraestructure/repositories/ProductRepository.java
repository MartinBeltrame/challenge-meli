package com.challenge.meli.infraestructure.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.models.ResultResponse;
import com.challenge.meli.infraestructure.api.ApiMeLi;
import com.challenge.meli.infraestructure.api.MeliCallback;

import java.util.List;

public class ProductRepository {

    private ApiMeLi apiMeLi = new ApiMeLi();

    public LiveData<List<Product>> getAll(String name) {

        MutableLiveData<List<Product>> products = new MutableLiveData<>();
        apiMeLi.getAll(name, new MeliCallback<ResultResponse>() {
            @Override
            public void success(ResultResponse response) {
                products.setValue(response.getResults());
            }

            @Override
            public void error(Throwable throwable, int code) {
                products.setValue(null);
            }
        });
        return products;
    }
}
