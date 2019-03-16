package com.challenge.meli.domain.repositories;

import android.arch.lifecycle.LiveData;
import com.challenge.meli.domain.models.Product;
import java.util.List;

public interface RepositoryMeLi {
    LiveData<List<Product>> getAll(String idProduct);
}
