package com.challenge.meli.views;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterPhotos;
import com.challenge.meli.domain.models.Product;
import com.challenge.meli.domain.services.DetailServices;
import com.challenge.meli.viewmodels.DetailViewModel;
import com.challenge.meli.views.utils.Constants;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView soldQuantity;
    private TextView price;
    private TextView description;
    private ProgressBar progressBar;
    private ConstraintLayout layoutHeader;
    private NestedScrollView layoutBody;

    private AdapterPhotos adapterPhotos;
    private DetailServices detailServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle(R.string.product);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ConstraintLayout layoutNoConnection = findViewById(R.id.layout_no_connection);
        progressBar = findViewById(R.id.progress_bar);

        String idProduct = getIntent().getExtras().getString(Constants.ID_PRODUCT);
        detailServices = new DetailServices(this);

        if (detailServices.hasConnection()) {
            intializeViewModels(idProduct);
            intializeComponents();
        } else {
            progressBar.setVisibility(View.GONE);
            layoutNoConnection.setVisibility(View.VISIBLE);
        }
    }

    private void intializeViewModels(String idProduct) {
        DetailViewModel detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        detailViewModel.getProduct(idProduct).observe(this, product -> {
            if (product != null) {
                setProduct(product);
            } else {
                detailServices.unexpectedError();
            }
        });
        detailViewModel.getDescriptionProduct(idProduct).observe(this, result -> {
            description.setText(result);
            setVisibleLayout();
        });
    }

    private void intializeComponents() {
        thumbnail = findViewById(R.id.thumbnail);
        title = findViewById(R.id.title);
        soldQuantity = findViewById(R.id.sold_quantity);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        layoutHeader = findViewById(R.id.layout_header);
        layoutBody = findViewById(R.id.layout_body);

        adapterPhotos = new AdapterPhotos();
        RecyclerView recyclerPhotos = findViewById(R.id.recycler_photos);
        recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerPhotos.setAdapter(adapterPhotos);
    }

    private void setProduct(Product product) {
        String quantity = product.getSoldQuantity() + " vendidos";
        String textPrice = "$ " + product.getPrice();

        title.setText(product.getTitle());
        soldQuantity.setText(quantity);
        price.setText(textPrice);
        Picasso.get().load(product.getThumbnail()).into(thumbnail);
        adapterPhotos.setPhotos(product.getPictures());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setVisibleLayout() {
        progressBar.setVisibility(View.GONE);
        layoutHeader.setVisibility(View.VISIBLE);
        layoutBody.setVisibility(View.VISIBLE);
    }
}
