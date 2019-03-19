package com.challenge.meli.domain.services;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

public class DetailServices {

    private Activity activity;

    public DetailServices(Activity activity) {
        this.activity = activity;
    }

    public void unexpectedError() {
        new AlertDialog.Builder(activity)
                .setTitle("Error")
                .setMessage("Algo ha salido mal. Por favor intentelo nuevamente")
                .setPositiveButton("Continuar", (dialog, which) -> activity.finish())
                .show();
    }
}
