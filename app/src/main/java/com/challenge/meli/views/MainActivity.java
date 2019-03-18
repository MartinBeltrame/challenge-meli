package com.challenge.meli.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterProducts;
import com.challenge.meli.utils.Constants;
import com.challenge.meli.viewmodels.ProductViewModel;

public class MainActivity extends AppCompatActivity {

    private AdapterProducts adapterProducts = new AdapterProducts();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nameProduct = getIntent().getExtras().getString(Constants.NAME_PRODUCT);

        ProductViewModel productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAll(nameProduct).observe(this, products -> adapterProducts.setProducts(products));

        initializeRecycler();
    }

    private void initializeRecycler() {
        RecyclerView recyclerProducts = findViewById(R.id.recycler_product);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapterProducts);
    }
}
