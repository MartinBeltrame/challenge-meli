package com.challenge.meli;

import com.challenge.meli.domain.services.SearchServices;

import org.junit.Assert;
import org.junit.Test;

public class SearchServicesTest {

    private SearchServices searchServices = new SearchServices();

    @Test
    public void returnFalseNullValue() {
        Assert.assertFalse(searchServices.isValid(null));
    }

    @Test
    public void returnFalseEmptyField() {
        Assert.assertFalse(searchServices.isValid(""));
    }

    @Test
    public void returnTrueValidText() {
        Assert.assertTrue(searchServices.isValid("Smartwatch Motorola"));
    }

    @Test
    public void returnTrueValidTextWithNumbers() {
        Assert.assertTrue(searchServices.isValid("Moto 360"));
    }

    @Test
    public void returnFalseTextContainRegularExpresion() {
        Assert.assertFalse(searchServices.isValid("#JBL"));
    }

    @Test
    public void returnTrueTextContainWeirdCharacter() {
        Assert.assertTrue(searchServices.isValid("Avión para niño"));
    }
}
