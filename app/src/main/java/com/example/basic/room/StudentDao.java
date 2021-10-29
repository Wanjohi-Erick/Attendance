package com.example.basic.room;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDao {

    @Query("SELECT * FROM Student")
    List<Student> getAllUsers();

    @Insert
    void insertUser(Student... students);

    @Delete
    void delete(Student student);
}
