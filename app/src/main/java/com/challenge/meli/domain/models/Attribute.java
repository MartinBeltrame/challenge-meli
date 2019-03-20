package com.challenge.meli.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attribute {

    private String name;
    @SerializedName("value_name")
    @Expose
    private String valueName;

    public String getName() {
        return name;
    }

    public String getValueName() {
        return valueName;
    }
}
