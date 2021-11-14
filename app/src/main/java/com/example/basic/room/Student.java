package com.example.basic.room;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String first_name;
    @ColumnInfo(name = "last_name")
    public String last_name;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "program")
    public String program;
    @ColumnInfo(name = "semester")
    public String semester;
    @ColumnInfo(name = "attendance")
    public String attendance;
}