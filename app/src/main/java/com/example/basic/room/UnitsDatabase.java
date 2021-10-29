package com.example.basic.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Units.class}, version = 1)
public abstract class UnitsDatabase extends RoomDatabase {
    public abstract UnitsDAO unitsDAO();
    public static UnitsDatabase unitsDatabase;

    public static UnitsDatabase getUnitsDatabase(Context context) {

        if (unitsDatabase == null) {
            unitsDatabase = Room.databaseBuilder(context.getApplicationContext(), UnitsDatabase.class, "UnitsDatabase")
                    .allowMainThreadQueries().build();
        }

        return unitsDatabase;
    }
}
