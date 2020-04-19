package com.example.wongy.it_begins;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


import java.util.Date;
import java.util.UUID;

@Entity
public class Reminder {

    //need to change to reminder and date
    Reminder(String reminder, Date date) {
        this.uuid = UUID.randomUUID().toString();
        this.reminder = reminder;
        this.date = date;
    }

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uuid")
    private String uuid;

    @NonNull
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @NonNull
    @ColumnInfo(name = "reminder")
    private String reminder;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;


    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public Date getDate() {
        return (date);
    }

    public void setDate(Date date) {
        this.date = (date);
    }

    public static class Converters {
        @TypeConverter
        public static Date fromTimestamp(Long value) {
            return value == null ? null : new Date(value);
        }
        @TypeConverter
        public static Long dateToTimestamp(Date date) {
            return date == null ? null : date.getTime();
        }
    }

}