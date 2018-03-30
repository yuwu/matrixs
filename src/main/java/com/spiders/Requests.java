package com.spiders;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Requests {

    private OkHttpClient getDefaultOkHttpClient(){
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        return client;
    }

    private void get(String url, Map<String, String> params){
        OkHttpClient client = getDefaultOkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = params.keySet();
        for(String name : keys){
            builder.add(name, params.get(name));
        }
        RequestBody requestBodyPost = builder.build();
        Request requestPost = new Request.Builder()
                .url(url)
                .post(requestBodyPost)
                .build();
        client.newCall(requestPost).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String result = response.body().string();
            }
        });
    }

    private void psot(String url, Map<String, String> params){
        OkHttpClient client = getDefaultOkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        Set<String> keys = params.keySet();
        for(String name : keys){
            builder.add(name, params.get(name));
        }
        RequestBody requestBodyPost = builder.build();
        Request requestPost = new Request.Builder()
                .url(url)
                .post(requestBodyPost)
                .build();
        client.newCall(requestPost).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //final String result = response.body().string();
            }
        });
    }
}
