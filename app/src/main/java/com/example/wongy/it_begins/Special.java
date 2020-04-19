package com.example.wongy.it_begins;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class Special extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        final Button lolicon = findViewById(R.id.youAreLolicon);


        lolicon.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.P)
            @Override
            public void onClick(View view) {
                //disable rapid executions
                lolicon.setEnabled(false);
                MediaPlayer play = MediaPlayer.create(Special.this,R.raw.youarelolicon);
                play.start();

                //enable button press
                Handler enabler = new Handler();
                enabler.postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        lolicon.setEnabled(true);
                    }
                }, 9000);

            }
        });


    }
}
