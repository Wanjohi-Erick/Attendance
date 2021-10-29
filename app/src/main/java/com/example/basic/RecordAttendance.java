package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.basic.adapters.AttendanceSelectAdapter;
import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;

import java.util.ArrayList;
import java.util.List;

public class RecordAttendance extends AppCompatActivity {
    RecyclerView recyclerView;
    Button saveAttendance;
    AttendanceSelectAdapter attendanceSelectAdapter;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_attendance);

        recyclerView = findViewById(R.id.take_attendance_recycler);
        saveAttendance = findViewById(R.id.save_attendance_btn);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        attendanceSelectAdapter = new AttendanceSelectAdapter(this);

        StudentDatabase studentDatabase = StudentDatabase.getStudentDatabase(this);
        studentList = studentDatabase.studentDao().getAllUsers();
        attendanceSelectAdapter.setStudentList(studentList);

        recyclerView.setAdapter(attendanceSelectAdapter);

    }
}