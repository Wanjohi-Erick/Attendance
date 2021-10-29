package com.example.basic.room;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDao studentDao();
    private static StudentDatabase studentDatabase;

    public static StudentDatabase getStudentDatabase(Context context) {
        if (studentDatabase == null) {
            studentDatabase = Room.databaseBuilder(context.getApplicationContext(), StudentDatabase.class, "Student_Database")
                    .allowMainThreadQueries().build();
        }
        return studentDatabase;
    }
}
