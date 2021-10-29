package com.example.basic.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Units {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo
    public String unit_name;

    @ColumnInfo
    public String academic_year;

    @ColumnInfo
    public String semester;

    @ColumnInfo
    public String number_of_classes;

}
