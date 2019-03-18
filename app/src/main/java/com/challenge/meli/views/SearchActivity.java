package com.challenge.meli.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.challenge.meli.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnSearch;
    private AppCompatEditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initializeComponents();
    }

    private void initializeComponents() {
        editSearch = findViewById(R.id.edit_search);
        btnSearch = findViewById(R.id.btn_search);
        btnSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String nameProduct = editSearch.getText().toString();

        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
