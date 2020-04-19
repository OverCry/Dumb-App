package com.example.wongy.it_begins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReminderCollect extends AppCompatActivity {

    static final int CREATE = 0;
    Date date;
    String reminderContent;
    ReminderDatabase reminderDatabase;
    List<Reminder> allReminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_collect);
        reminderDatabase = new ReminderDatabase(getApplicationContext());


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
        // if commit button is pressed when creating a reminder
        if (requestCode == CREATE && resultCode == RESULT_OK) {
            String day = data.getExtras().getString("day");
            String month = data.getExtras().getString("month");
            String year = data.getExtras().getString("year");
            reminderContent = data.getExtras().getString("reminder");
            //format to dat
            if (day.length()==1){
                day = "0"+day;
            }
            if (month.length()==1){
                month = "0" +month;
            }
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = df.parse(day+"/"+month+"/"+year);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            reminderDatabase.insertReminder((new Reminder(reminderContent,date)));
            allReminders = reminderDatabase.getAllReminders();



//            String dateString = "27/10/2016";
//            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//            Date date = df.parse(dateString);
//            System.out.println(date);
//            System.out.println(df.format(date));


            Toast.makeText(getApplicationContext(), day + "/" + month + "/" + year, Toast.LENGTH_LONG).show();
        }
        // if cancel button is pressed when creating a reminder
        if (requestCode == CREATE && resultCode == RESULT_CANCELED){
            Toast.makeText(getApplicationContext(), "Reminder was cancelled", Toast.LENGTH_LONG);
        }
    }
}
