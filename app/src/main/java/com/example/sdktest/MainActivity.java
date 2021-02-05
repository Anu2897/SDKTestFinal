package com.example.sdktest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.os.Bundle;

import com.clevertap.android.sdk.CleverTapAPI;

import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CleverTapAPI clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
        clevertapDefaultInstance.setDebugLevel(3);
        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();

//Update pre-defined profile properties
        profileUpdate.put("Name", "Twain Dan");
        profileUpdate.put("Email", "123@gmail.com");
//Update custom profile properties
        profileUpdate.put("Plan Type", "gold");
        profileUpdate.put("Favorite Food", "Pizza");
        profileUpdate.put("Gender", "F");                           // Can be either M or F
        profileUpdate.put("Employed", "Y");                         // Can be either Y or N
        profileUpdate.put("Education", "Graduate");
        profileUpdate.put("Phone", "2394593464965");
        clevertapDefaultInstance.onUserLogin(profileUpdate);

        //clevertapDefaultInstance.pushProfile(profileUpdate);

        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("Product Name", "Casio Chronograph Watch");
        prodViewedAction.put("Category", "Accessories");
        prodViewedAction.put("Price", 59.99);
        prodViewedAction.put("Date", new Date());

        clevertapDefaultInstance.pushEvent("Product viewed", prodViewedAction);



    }
}