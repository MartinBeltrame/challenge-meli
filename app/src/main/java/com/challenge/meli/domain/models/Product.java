package com.challenge.meli.domain.models;

public class Product {

    private String id;
    private String title;
    private double price;
    private String thumbnail;

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getId() {
        return id;
    }
}
