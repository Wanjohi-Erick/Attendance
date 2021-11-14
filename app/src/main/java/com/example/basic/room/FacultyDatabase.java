package com.example.basic.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Faculty.class, version = 1)
public abstract class FacultyDatabase extends RoomDatabase {
    public abstract FacultyDao facultyDao();
    public static FacultyDatabase facultyDatabase;
    public static FacultyDatabase getAllFaculty(Context context) {
        if (facultyDatabase == null) {
            facultyDatabase = Room.databaseBuilder(context.getApplicationContext(), FacultyDatabase.class, "facultyDatabase")
                    .allowMainThreadQueries().build();
        }
        return facultyDatabase;
    }
}
