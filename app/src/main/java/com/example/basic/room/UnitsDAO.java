package com.example.basic.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UnitsDAO {
    @Query("SELECT * FROM units")
    List<Units> getAllUnits();

    @Insert
    void insertUnit(Units... units);

    @Delete
    void delete(Units units);
}
