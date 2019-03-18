package com.challenge.meli.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

    private String id;
    private String title;
    private double price;
    private String thumbnail;
    @SerializedName("sold_quantity")
    @Expose
    private int soldQuantity;

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

    public int getSoldQuantity() {
        return soldQuantity;
    }
}
