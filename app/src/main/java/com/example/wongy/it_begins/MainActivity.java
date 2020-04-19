package com.example.wongy.it_begins;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Boolean interrupt = false;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView logo = findViewById(R.id.logo);

        //make name fade in
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        findViewById(R.id.name).startAnimation(animFadeIn);
        logo.startAnimation(animFadeIn);

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
        }, interrupt, 3000);

        //if icon is clicked before change, show Special activity
        findViewById(R.id.logo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                interrupt = true;

                //create fade out animation
                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                logo.startAnimation(animFadeOut);

                //create handler to change scenes
                Handler handler = new Handler();
                handler.postDelayed(new newRunnable(), 1000);
            }

             class newRunnable implements Runnable{

                 @Override
                 public void run() {
                     Intent yay = new Intent(MainActivity.this, Special.class);
                     MainActivity.this.startActivity(yay);
                 }
             }

        });

    }


}
