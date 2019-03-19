package com.challenge.meli.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterProducts;
import com.challenge.meli.domain.interfaces.ListenerProduct;
import com.challenge.meli.domain.services.MainServices;
import com.challenge.meli.views.utils.Constants;
import com.challenge.meli.viewmodels.ProductViewModel;

public class MainActivity extends AppCompatActivity implements ListenerProduct {

    private AdapterProducts adapterProducts;

    private RecyclerView recyclerProducts;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainServices mainServices = new MainServices(this);
        adapterProducts = new AdapterProducts(this);

        progressBar = findViewById(R.id.progressBar);
        ConstraintLayout layoutNoConnection = findViewById(R.id.layout_no_connection);

        if (mainServices.hasConnection()) {
            String nameProduct = getIntent().getExtras().getString(Constants.NAME_PRODUCT);
            initializeViewModel(nameProduct);
            initializeComponents();
        } else {
            progressBar.setVisibility(View.GONE);
            layoutNoConnection.setVisibility(View.VISIBLE);
        }
    }

    private void initializeViewModel(String nameProduct) {
        ProductViewModel productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getAll(nameProduct).observe(this, products -> {
            progressBar.setVisibility(View.GONE);
            adapterProducts.setProducts(products);
            recyclerProducts.setVisibility(View.VISIBLE);
        });
    }

    private void initializeComponents() {
        recyclerProducts = findViewById(R.id.recycler_product);
        recyclerProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerProducts.setAdapter(adapterProducts);
    }

    @Override
    public void selectProduct(String idProduct) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.ID_PRODUCT, idProduct);
        startActivity(intent);
    }
}
