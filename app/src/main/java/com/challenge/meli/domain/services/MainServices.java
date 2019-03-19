package com.challenge.meli.domain.services;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;

public class MainServices {

    private Activity activity;

    public MainServices(Activity activity) {
        this.activity = activity;
    }

    public boolean hasConnection() {
        return ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}
