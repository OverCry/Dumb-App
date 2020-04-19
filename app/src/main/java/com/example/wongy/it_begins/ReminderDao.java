package com.example.wongy.it_begins;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ReminderDao {
    @Query("SELECT * FROM reminder")
    List<Reminder> getAll();

    @Insert
    void insertAll(Reminder... reminder);

    @Delete
    void delete(Reminder reminder);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(Reminder flashcard);
}
