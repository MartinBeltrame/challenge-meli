package com.challenge.meli.infraestructure.api;

import com.challenge.meli.domain.models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Endpoints {

    @GET("")
    Call<List<Product>> getAll(String idProduct);
}
