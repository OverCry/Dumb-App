package com.example.wongy.it_begins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ReminderCollect extends AppCompatActivity {

    static final int CREATE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_collect);

        Button make = findViewById(R.id.newReminder);
        Button edit = findViewById(R.id.editReminder);
        Button view = findViewById(R.id.viewReminders);

        make.setVisibility(View.VISIBLE);

        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toMaker = new Intent(ReminderCollect.this, create_reminder.class);
                ReminderCollect.this.startActivityForResult(toMaker, CREATE);
            }
        });



    }

    //method for creating reminder
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE) { // this 100 needs to match the 100 we used when we called startActivityForResult!
            //store
        }
    }
}
