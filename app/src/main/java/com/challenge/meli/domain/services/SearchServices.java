package com.challenge.meli.domain.services;

public class SearchServices {

    private static final String REGULAR_EXPRESSION = "^([A-Za-z0-9ñÑáéíóúÁÉÍÓÚ]+)(\\s[A-Za-z0-9]+)*\\s?$";

    public boolean isValid(String nameProduct) {
        if (nameProduct != null) {
            return !nameProduct.isEmpty() && nameProduct.matches(REGULAR_EXPRESSION);
        } else {
            return false;
        }
    }
}
