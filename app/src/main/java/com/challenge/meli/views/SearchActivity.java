package com.challenge.meli.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.challenge.meli.R;
import com.challenge.meli.domain.services.SearchServices;
import com.challenge.meli.views.utils.Constants;

public class SearchActivity extends AppCompatActivity implements EditText.OnEditorActionListener {

    private SearchServices searchServices;

    private TextInputLayout layoutSearch;
    private AppCompatEditText editSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initializeComponents();
    }

    private void initializeComponents() {
        searchServices = new SearchServices();
        layoutSearch = findViewById(R.id.layout_search);
        editSearch = findViewById(R.id.edit_search);
        editSearch.setOnEditorActionListener(this);
    }

    public void searchProduct() {
        String nameProduct = editSearch.getText().toString();
        boolean valid = searchServices.isValid(nameProduct);

        if (valid) {
            goToMainActivity(nameProduct);
        } else {
            hideSoftKeyboard(editSearch);
            layoutSearch.setError(getString(R.string.message_invalid_name));
        }
    }

    private void goToMainActivity(String nameProduct) {
        Intent intent = new Intent(SearchActivity.this, MainActivity.class);
        intent.putExtra(Constants.NAME_PRODUCT, nameProduct);
        startActivity(intent);
        finish();
    }

    protected void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            searchProduct();
            return true;
        }
        return false;
    }
}
