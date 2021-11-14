package com.example.basic.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FacultyDao {
    @Query("SELECT * FROM facultyTable")
    List<Faculty> getAllFaculty();

    @Query("Select * FROM facultyTable WHERE username =:username")
    List<Faculty> getUser(String username);

    @Insert
    void insertFaculty(Faculty... faculty);

    @Delete
    void delete(Faculty faculty);

    //@Query("UPDATE facultyTable SET attendance_count = :attendance_count WHERE uid = :uid")
    //void update(String attendance_count, int uid);

    //@Update
    //void update(AttendanceModel attendanceModel);

    //@Query("SELECT * FROM facultyTable WHERE date = :date")
    //List<AttendanceModel> select(String date);
}
