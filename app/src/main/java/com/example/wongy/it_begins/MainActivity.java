package com.example.wongy.it_begins;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    ImageView logo = findViewById(R.id.logo);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView logo = findViewById(R.id.logo);
        logo.setImageAlpha(250);

        Handler transition = new Handler();
        transition.postDelayed(new Runnable(){

            @Override
            public void run() {

            }
        }, 500);

        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new newRunnable(), 250);
            }

             class newRunnable implements Runnable{

                 @Override
                 public void run() {
                     int alpha = logo.getImageAlpha();
                     logo.setImageAlpha(alpha - 50);
                 }
             }

        });

    }


}
