package com.example.wongy.it_begins;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Special extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        final Button lolicon = findViewById(R.id.youAreLolicon);

        lolicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MediaPlayer play = MediaPlayer.create(Special.this,R.raw.youarelolicon);
                play.start();
            }
        });

    }
}
