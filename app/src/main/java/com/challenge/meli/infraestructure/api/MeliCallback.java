package com.challenge.meli.infraestructure.api;

import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class MeliCallback<T> implements Callback<T> {

    private static final String LOG_TAG = MeliCallback.class.getSimpleName();

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {

        if (response.isSuccessful()) {
            Log.d(LOG_TAG, response.code() + ":" + response.raw().request().url());
            success(response.body());
        } else {
            try {
                assert response.errorBody() != null;
                Log.e(LOG_TAG, response.code() + ":" + response.raw().request().url() + " - " + response.errorBody().string());
            } catch (IOException e) {
                Log.e(LOG_TAG, response.code() + ":" + response.raw().request().url());
                e.printStackTrace();
            }
            error(new Exception(String.valueOf(response.errorBody())), response.code());
        }
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable throwable) {
        Log.e(LOG_TAG, call.request().url() + ": " + throwable.toString());
        error(throwable, 0);
    }

    public abstract void success(T response);

    public abstract void error(Throwable throwable, int code);
}
