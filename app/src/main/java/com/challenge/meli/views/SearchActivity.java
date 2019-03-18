package com.challenge.meli.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.challenge.meli.R;
import com.challenge.meli.domain.services.SearchServices;
import com.challenge.meli.utils.Constants;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout layoutSearch;
    private AppCompatEditText editSearch;
    private SearchServices searchServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchServices = new SearchServices();
        initializeComponents();
    }

    private void initializeComponents() {
        layoutSearch = findViewById(R.id.layout_search);
        editSearch = findViewById(R.id.edit_search);
        Button btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameProduct = editSearch.getText().toString();
        boolean valid = searchServices.isValid(nameProduct);

        if (valid) {
            goToMainActivity(nameProduct);
        } else {
            layoutSearch.setError("El nombre del producto no es válido");
        }
    }

    private void goToMainActivity(String nameProduct) {
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        intent.putExtra(Constants.NAME_PRODUCT, nameProduct);
        startActivity(intent);
        finish();
    }
}
