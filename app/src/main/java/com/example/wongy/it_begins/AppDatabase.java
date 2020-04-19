package com.example.wongy.it_begins;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

@Database(entities = {Reminder.class}, version = 1)
@TypeConverters({Reminder.Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract ReminderDao reminderDao();
}