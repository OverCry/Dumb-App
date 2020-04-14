package com.example.wongy.it_begins;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

//    ImageView logo = findViewById(R.id.logo);
    Boolean interrupt = false;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView logo = findViewById(R.id.logo);
        logo.setImageAlpha(250);


        Handler transition = new Handler();

        //if nothing happens, go to main page
        transition.postDelayed(new Runnable(){
            @Override
            public void run() {
                if (!interrupt) {
                    Intent toRemainders = new Intent(MainActivity.this, ReminderCollect.class);
                    MainActivity.this.startActivity(toRemainders);
                }
            }
        }, interrupt, 4000);

        //if icon is clicked before change, show Special activity
        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logo.setImageAlpha(100);
                Handler handler = new Handler();
                handler.postDelayed(new newRunnable(), 250);
            }

             class newRunnable implements Runnable{

                 @Override
                 public void run() {
                     logo.setImageAlpha(0);
                     interrupt = true;
                     Intent yay = new Intent(MainActivity.this, Special.class);
                     MainActivity.this.startActivity(yay);
                 }
             }

        });

    }


}
