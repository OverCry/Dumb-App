package com.example.wongy.it_begins;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

public class ReminderDatabase {
    private final AppDatabase db;

    ReminderDatabase(Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "flashcard-database")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    public List<Reminder> getAllCards() {
        return db.reminderDao().getAll();
    }

    public void insertCard(Reminder reminder) {
        db.reminderDao().insertAll(reminder);
    }

    public void deleteCard(String flashcardQuestion) {
        List<Reminder> allReminders = db.reminderDao().getAll();
        for (Reminder f : allReminders) {
            if (f.getReminder().equals(flashcardQuestion)) {
                db.reminderDao().delete(f);
            }
        }
    }

    public void updateCard(Reminder flashcard) {
        db.reminderDao().update(flashcard);
    }
}
