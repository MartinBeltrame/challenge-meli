package com.challenge.meli.infraestructure;

import android.arch.lifecycle.LiveData;

import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.repositories.RepositoryMeLi;

import java.util.List;

public class ProductRepository implements RepositoryMeLi {

    @Override
    public LiveData<List<Product>> getAll(String idProduct) {
        return null;
    }
}
