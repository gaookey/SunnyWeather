package com.gaowenli.myapp.api;

import android.util.Log;

import androidx.annotation.NonNull;

import com.gaowenli.myapp.util.AppConfig;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Api {
    private static String requestUrl;
    private static OkHttpClient client;
    private static HashMap<String, Object> mParams;
    public static Api api = new Api();

    public Api() {

    }

    public static Api config(String url, HashMap<String, Object> params) {
        client = new OkHttpClient.Builder().build();

        requestUrl = ApiConfig.BASE_URL + url;
        mParams = params;
        return api;
    }

    public void postRequest(GoCallback callback) {

        JSONObject jsonObject = new JSONObject(mParams);
        String jsonString = jsonObject.toString();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonString);

        Request request = new Request.Builder()
                .url(requestUrl)
                .addHeader("contentType", "application/json;charset=utf-8")
                .post(requestBody)
                .build();

        final Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                callback.onFailure(e);
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String result = response.body().string();
                callback.onSuccess(result);
            }
        });
    }
}
