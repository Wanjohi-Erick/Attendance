package com.example.basic.room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "student_name")
    public String student_name;
    @ColumnInfo(name = "reg_no")
    public String reg_no;
    @ColumnInfo(name = "attendance")
    public String attendance;

}