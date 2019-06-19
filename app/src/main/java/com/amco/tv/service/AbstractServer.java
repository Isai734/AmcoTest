/*
 * Copyright (c) 2017. Desarrollado por <a href="https://plus.google.com/u/0/+IsaiCastroAlv">Isai Castro G+</a>
 */

package com.amco.tv.service;

import android.support.annotation.NonNull;
import android.util.Log;

import com.amco.tv.model.ResponseError;
import com.amco.tv.tools.Constans;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author isaicastro
 */

public abstract class AbstractServer {

    private static final String TAG = AbstractServer.class.getSimpleName();

    protected void attemptRequest(Constans.Operations operation, Call call) {

        call.enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) {

                if (!response.isSuccessful()) {
                    String json = "";
                    if (response.errorBody().contentType().subtype().equals("json")) {
                        try {
                            json = response.errorBody().string();
                            ResponseError responseApi = ResponseError.fromResponseBody(json);
                            Log.d(TAG, "01: " + responseApi.toString());
                            onError(responseApi);
                        } catch (Exception e) {
                            try {
                                onError(new ResponseError(0, new JSONObject(json).get("Message").toString(), "", 403));
                            } catch (JSONException e1) {
                                Log.i(TAG, "02: " + e1.toString());
                            }
                            Log.i(TAG, "03: " + e.toString());
                        }
                    } else {
                        try {
                            /*
                             *Reportar causas de error no relacionado con la API
                             */
                            Log.d(TAG, "04: " + response.errorBody().string());
                            onError(new ResponseError(0, "Problemas al conectarse con el servidor", "404", 404));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    onSucces(operation, response);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                /*
                 * Aqui se notifican errores relacionados con la comunicación...
                 */
                Log.d(TAG, "onFailure with message : " + t.getMessage());
                onError(new ResponseError(0, t.getMessage(), "onFailure with message", 404));
            }
        });
    }

    protected abstract void onError(ResponseError errorResponse);

    protected abstract void onSucces(Constans.Operations operations, Response response);

}
