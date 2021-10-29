package com.example.basic.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AttendanceDao {
    @Query("SELECT * FROM attendance")
    List<AttendanceModel> getAllAttendance();

    @Insert
    void insertAttendance(AttendanceModel... attendanceModel);

    @Delete
    void delete(AttendanceModel attendanceModel);

    @Query("UPDATE attendance SET attendance_count = :attendance_count WHERE uid = :uid")
    void update(String attendance_count, int uid);

    @Update
    void update(AttendanceModel attendanceModel);
}
