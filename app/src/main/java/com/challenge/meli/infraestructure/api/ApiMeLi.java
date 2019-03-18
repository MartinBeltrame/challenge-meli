package com.challenge.meli.infraestructure.api;

import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.models.ResultResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMeLi {

    private static final String API_URL = "https://api.mercadolibre.com/";
    private Endpoints endpoints;

    public ApiMeLi() {
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL);

        endpoints = retrofitBuilder.build().create(Endpoints.class);
    }

    public void getAll(String name, MeliCallback<ResultResponse> callback) {
        endpoints.getAll(name).enqueue(callback);
    }

    public void getProduct(String idProduct, MeliCallback<Product> callback) {
        endpoints.getProduct(idProduct).enqueue(callback);
    }

    public void getDescriptionProduct(String idProduct, MeliCallback<String> callback) {
        endpoints.getDescription(idProduct).enqueue(callback);
    }
}
