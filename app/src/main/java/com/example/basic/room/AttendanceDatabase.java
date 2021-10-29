package com.example.basic.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = AttendanceModel.class, version = 1)
public abstract class AttendanceDatabase extends RoomDatabase {
    public static AttendanceDatabase attendanceDatabase;
    public static AttendanceDatabase getAttendanceDatabase(Context context) {
        if (attendanceDatabase == null) {
            attendanceDatabase = Room.databaseBuilder(context.getApplicationContext(), AttendanceDatabase.class, "attendanceDatabase")
                    .allowMainThreadQueries()
                    .build();
        }

        return attendanceDatabase;
    }
}
