package com.challenge.meli.infraestructure.repositories;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.challenge.meli.domain.interfaces.ErrorCallback;
import com.challenge.meli.domain.models.Description;
import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.models.ResultResponse;
import com.challenge.meli.infraestructure.api.ApiMeLi;
import com.challenge.meli.infraestructure.api.MeliCallback;
import com.challenge.meli.views.utils.Constants;

import java.util.List;

public class ProductRepository {

    private ApiMeLi apiMeLi = new ApiMeLi();

    public LiveData<List<Product>> getAll(String name, ErrorCallback errorCallback) {

        MutableLiveData<List<Product>> products = new MutableLiveData<>();
        apiMeLi.getAll(name, new MeliCallback<ResultResponse>() {
            @Override
            public void success(ResultResponse response) {
                products.setValue(response.getResults());
            }

            @Override
            public void error(Throwable throwable, int code) {
                errorCallback.error(Constants.PRODUCTS_ERROR);
                Log.e("Callback error", "No se pudo obtener el listado de productos");
            }
        });
        return products;
    }

    public LiveData<Product> getProduct(String idProduct, ErrorCallback errorCallback) {

        MutableLiveData<Product> product = new MutableLiveData<>();
        apiMeLi.getProduct(idProduct, new MeliCallback<Product>() {
            @Override
            public void success(Product response) {
                product.setValue(response);
            }

            @Override
            public void error(Throwable throwable, int code) {
                errorCallback.error(Constants.DETAIL_PRODUCT_ERROR);
                Log.e("Callback error", "No se pudo obtener el detalle del producto");
            }
        });
        return product;
    }

    public LiveData<String> getDescriptionProduct(String idProduct, ErrorCallback errorCallback) {

        MutableLiveData<String> description = new MutableLiveData<>();
        apiMeLi.getDescriptionProduct(idProduct, new MeliCallback<List<Description>>() {
            @Override
            public void success(List<Description> response) {
                description.setValue(response.get(0).getPlainText());
            }

            @Override
            public void error(Throwable throwable, int code) {
                errorCallback.error(Constants.DETAIL_PRODUCT_ERROR);
                Log.e("Callback error", "No se pudo obtener la descripción del producto");
            }
        });
        return description;
    }
}
