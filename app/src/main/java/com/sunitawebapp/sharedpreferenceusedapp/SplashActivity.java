package com.sunitawebapp.sharedpreferenceusedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Retrieving the value using its keys the file name
       // must be same in both saving and retrieving the data
        SharedPreferences sh = getSharedPreferences("Login", Context.MODE_PRIVATE);

    // The value will be default as empty string because for
    // the very first time when the app is opened, there is nothing to show
     Boolean islogin=sh.getBoolean("islogin",false);



        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if (islogin){
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(mainIntent);
                    finish();
                }else {
                    Intent mainIntent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(mainIntent);
                    finish();
                }

            }
    },1000);
    }
}
