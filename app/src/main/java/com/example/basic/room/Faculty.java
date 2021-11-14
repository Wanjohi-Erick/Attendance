package com.example.basic.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "facultyTable")
public class Faculty {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "first_name")
    public String first_name;
    @ColumnInfo(name = "last_name")
    public String last_name;
    @ColumnInfo(name = "phone")
    public String phone;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "username")
    public String username;
    @ColumnInfo(name = "password")
    public String password;
}
