package com.example.app;

import com.safous.waap.ApiProtection;
import com.safous.waap.ApiProtectionCallBack;

import java.io.IOException;
import java.security.GeneralSecurityException;

import okhttp3.OkHttpClient;

public class ExampleRegistration {
    public static void main(String[] args) {
        try {
            ExampleRegistration example = new ExampleRegistration();
            example.registration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registration() throws IOException, GeneralSecurityException, InterruptedException, ReflectiveOperationException {
        ApiProtection apiProtection = new ApiProtection();

        ApiProtectionCallBack callBack = new ApiProtectionCallBack() {
            @Override
            public void onCompleted(OkHttpClient okHttpClient, String deviceId) throws IOException, GeneralSecurityException, ReflectiveOperationException {
                apiProtection.verifyDevice();
            }
        };

        apiProtection.registerDevice(callBack);
    }
}
