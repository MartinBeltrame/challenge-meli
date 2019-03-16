package com.challenge.meli.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.repositories.RepositoryMeLi;
import com.challenge.meli.infraestructure.ProductRepository;

import java.util.List;

public class ProductViewModel extends AndroidViewModel {

    private RepositoryMeLi repositoryProduct = new ProductRepository();

    public ProductViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Product>> getAll(String idProduct) {
        return repositoryProduct.getAll(idProduct);
    }
}
