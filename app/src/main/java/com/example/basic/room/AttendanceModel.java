package com.example.basic.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attendance")
public class AttendanceModel {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    public int uid;

    @ColumnInfo(name = "unit_name")
    public String unit_name;
    @ColumnInfo(name = "date")
    public String date;
    @ColumnInfo(name = "student_name")
    public String student_name;
    @ColumnInfo(name = "reg_no")
    public String reg_no;
    @ColumnInfo(name = "attendance_state")
    public String attendance_state;
    @ColumnInfo(name = "attendance_count")
    public String attendance_count;
}
