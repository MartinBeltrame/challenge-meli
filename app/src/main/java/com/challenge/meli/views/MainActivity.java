package com.challenge.meli.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterProducts;
import com.challenge.meli.domain.interfaces.ErrorCallback;
import com.challenge.meli.domain.interfaces.ListenerProduct;
import com.challenge.meli.domain.services.SearchServices;
import com.challenge.meli.viewmodels.ProductViewModel;
import com.challenge.meli.views.utils.Constants;
import com.challenge.meli.views.utils.UtilServices;

public class MainActivity extends AppCompatActivity implements ListenerProduct, ErrorCallback {

    private AdapterProducts adapterProducts;

    private RecyclerView recyclerProducts;
    private ProgressBar progressBar;
    private SearchServices searchServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapterProducts = new AdapterProducts(this);
        searchServices = new SearchServices();

        progressBar = findViewById(R.id.progressBar);
        ConstraintLayout layoutNoConnection = findViewById(R.id.layout_no_connection);

        if (UtilServices.hasConnection(this)) {
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
        productViewModel.getAll(nameProduct, this).observe(this, products -> {
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);

        SearchView searchView = (SearchView) searchViewItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String nameProduct) {
                searchProduct(searchView, nameProduct);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return true;
    }

    public void searchProduct(SearchView searchView, String nameProduct) {
        boolean valid = searchServices.isValid(nameProduct);
        if (valid) {
            initializeViewModel(nameProduct);
        } else {
            Toast.makeText(this, getString(R.string.message_invalid_name), Toast.LENGTH_SHORT).show();
        }
        UtilServices.hideSoftKeyboard(this, searchView);
    }

    @Override
    public void selectProduct(String idProduct) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra(Constants.ID_PRODUCT, idProduct);
        startActivity(intent);
    }

    @Override
    public void error(String idError) {
        UtilServices.unexpectedError(this);
    }
}
