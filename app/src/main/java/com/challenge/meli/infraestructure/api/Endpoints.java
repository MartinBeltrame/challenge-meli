package com.challenge.meli.infraestructure.api;

import com.challenge.meli.domain.models.Description;
import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.models.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Endpoints {

    @GET("sites/MLA/search")
    Call<ResultResponse> getAll(@Query("q") String name_product);

    @GET("items/{idProduct}")
    Call<Product> getProduct(@Path("idProduct") String idProduct);

    @GET("items/{idProduct}/descriptions")
    Call<List<Description>> getDescription(@Path("idProduct") String idProduct);
}
