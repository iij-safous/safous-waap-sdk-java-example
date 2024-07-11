package com.example.app;

import com.safous.waap.ApiProtection;
import com.safous.waap.ApiProtectionCallBack;

import java.io.IOException;
import java.security.GeneralSecurityException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ExampleTerminate {
    public static void main(String[] args) {
        try {
            ExampleTerminate example = new ExampleTerminate();
            example.accessBackendSimpleWithTerminate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void accessBackendSimpleWithTerminate() throws IOException, GeneralSecurityException, InterruptedException, ReflectiveOperationException {
        ApiProtection apiProtection = new ApiProtection();

        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
            @Override
            public void onCompleted(OkHttpClient okHttpClient) throws IOException, GeneralSecurityException {
                Request request = new Request.Builder()
                    .url("https://simple-web.example-waap.waap.safous.com")
                    .get()
                    .build();

                Response response = okHttpClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    System.out.println(response.body().string());
                } else {
                    throw new IOException("HTTP Error: " + response.code());
                }

                apiProtection.terminate();
            }
        };

        apiProtection.transaction(callBack);
    }
}
