package com.challenge.meli.views.utils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class UtilServices {

    public static boolean hasConnection(Activity activity) {
        return ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    public static void unexpectedError(Activity activity) {
        new AlertDialog.Builder(activity)
                .setTitle("Error")
                .setMessage("Algo ha salido mal. Por favor intentelo nuevamente")
                .setPositiveButton("Continuar", (dialog, which) -> activity.finish())
                .show();
    }

    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
