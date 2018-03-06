package com.example.shristy.dietplan;


import android.app.Application;

import com.firebase.client.Firebase;


public class DietPlan extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
