package com.challenge.meli.domain.services;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;

public class MainServices {

    private Activity activity;

    public MainServices(Activity activity) {
        this.activity = activity;
    }

    public boolean hasConnection() {
        return ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    public void unexpectedError() {
        new AlertDialog.Builder(activity)
                .setTitle("Error")
                .setMessage("Algo ha salido mal. Por favor intentelo nuevamente")
                .setPositiveButton("Continuar", (dialog, which) -> activity.finish())
                .show();
    }
}
