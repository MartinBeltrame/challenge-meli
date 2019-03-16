package com.challenge.meli.infraestructure.api;

import com.challenge.meli.domain.models.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMeLi {

    private static final String API_URL = "https://api.mercadolibre.com/";
    private Endpoints endpoints;

    public ApiMeLi() {

        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder
                .setLenient()
                .create();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(API_URL);

        endpoints = retrofitBuilder.build().create(Endpoints.class);
    }

    public void getAll(String name, MeliCallback<List<Product>> callback) {
        endpoints.getAll(name).enqueue(callback);
    }
}