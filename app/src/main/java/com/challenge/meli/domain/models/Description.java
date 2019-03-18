package com.challenge.meli.domain.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Description {

    @SerializedName("plain_text")
    @Expose
    private String plainText;

    public String getPlainText() {
        return plainText;
    }
}
