package com.example.wongy.it_begins;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

public class ReminderDatabase {
    private final AppDatabase db;

    ReminderDatabase(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "reminder-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public List<Reminder> getAllReminders() {
        return db.reminderDao().getAll();
    }

    public void insertReminder(Reminder reminder) {
        db.reminderDao().insertAll(reminder);
    }

    public void deleteReminder(String reminder) {
        List<Reminder> allReminders = db.reminderDao().getAll();
        for (Reminder f : allReminders) {
            if (f.getReminder().equals(reminder)) {
                db.reminderDao().delete(f);
            }
        }
    }

    public void updateReminder(Reminder reminder) {
        db.reminderDao().update(reminder);
    }
}
