package com.challenge.meli.domain.services;

public class SearchServices {

    public boolean isValid(String nameProduct) {
        if (nameProduct != null) {
            return !nameProduct.isEmpty();
        } else {
            return false;
        }
    }
}
