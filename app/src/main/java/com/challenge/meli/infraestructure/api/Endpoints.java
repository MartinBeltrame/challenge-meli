package com.challenge.meli.infraestructure.api;

import com.challenge.meli.domain.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Endpoints {

    @GET("/items/{name}")
    Call<List<Product>> getAll(@Path("name") String name);
}
