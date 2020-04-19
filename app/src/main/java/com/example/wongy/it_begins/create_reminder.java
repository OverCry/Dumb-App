package com.example.wongy.it_begins;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class create_reminder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);

        final DatePicker datePicker = findViewById(R.id.datePicker);
        Button confirmButton = findViewById(R.id.confirmButton);
        Button cancelButton = findViewById(R.id.cancelButton);
        final EditText text = findViewById(R.id.reminderText);


        // submitting
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = "" + datePicker.getDayOfMonth();
                String month = "" + (datePicker.getMonth() + 1);
                String year = "" + datePicker.getYear();
                String reminderContent = text.getText().toString();

                Intent data = new Intent();
                data.putExtra("day", day);
                data.putExtra("month", month);
                data.putExtra("year", year);
                data.putExtra("reminder", reminderContent);
                setResult(RESULT_OK,data);
                finish();
            }
        });











    }
}
