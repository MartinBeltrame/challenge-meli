package com.challenge.meli.views;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterPhotos;
import com.challenge.meli.viewmodels.DetailViewModel;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView soldQuantity;
    private TextView price;

    private AdapterPhotos adapterPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String idProduct = "MLA698504698";

        DetailViewModel detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
        detailViewModel.getProduct(idProduct).observe(this, product -> {
            String quantity = product.getSoldQuantity() + " vendidos";
            String textPrice = "$ " + product.getPrice();

            title.setText(product.getTitle());
            soldQuantity.setText(quantity);
            price.setText(textPrice);
            Picasso.get().load(product.getThumbnail()).into(thumbnail);
            adapterPhotos.setPhotos(product.getPictures());
        });

        intializeComponents();
    }

    private void intializeComponents() {
        thumbnail = findViewById(R.id.thumbnail);
        title = findViewById(R.id.title);
        soldQuantity = findViewById(R.id.sold_quantity);
        price = findViewById(R.id.price);

        adapterPhotos = new AdapterPhotos();
        RecyclerView recyclerPhotos = findViewById(R.id.recycler_photos);
        recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerPhotos.setAdapter(adapterPhotos);
    }
}
