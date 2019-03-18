package com.challenge.meli.domain.services;

public class SearchServices {

    private static final String REGULAR_EXPRESSION = "^([A-Za-z0-9]+)(\\s[A-Za-z]+)*\\s?$";

    public boolean isValid(String nameProduct) {
        if (nameProduct != null) {
            return !nameProduct.isEmpty() && nameProduct.matches(REGULAR_EXPRESSION);
        } else {
            return false;
        }
    }
}
