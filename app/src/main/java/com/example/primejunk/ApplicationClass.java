package com.example.primejunk;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ApplicationClass extends Application
{
    private static final String API_HOST = "https://api.backendless.com";
    private static final String APP_ID = "3B001C95-398D-E760-FFCD-421C532C3800";
    private static final String APP_KEY = "43013FDB-485B-40F8-9071-8D6C1FD6F796";

    public static String address ;
    public static BackendlessUser user = new BackendlessUser();
    public static List<Address> addresses;

//    private void initBackendless() {
//
//    }
    @Override
    public void onCreate() {
        super.onCreate();
        Backendless.setUrl(API_HOST);
        Backendless.initApp(this, APP_ID, APP_KEY);
    }
}
