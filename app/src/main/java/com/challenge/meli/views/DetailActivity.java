package com.challenge.meli.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.adapters.AdapterPhotos;

public class DetailActivity extends AppCompatActivity {

    private ImageView thumbnail;
    private TextView title;
    private TextView soldQuantity;
    private TextView price;
    private RecyclerView recyclerPhotos;
    private AdapterPhotos adapterPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        intializeComponents();
    }

    private void intializeComponents() {
        thumbnail = findViewById(R.id.thumbnail);
        title = findViewById(R.id.title);
        soldQuantity = findViewById(R.id.sold_quantity);
        price = findViewById(R.id.price);

        adapterPhotos = new AdapterPhotos();
        recyclerPhotos = findViewById(R.id.recycler_photos);
        recyclerPhotos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerPhotos.setAdapter(adapterPhotos);
    }
}