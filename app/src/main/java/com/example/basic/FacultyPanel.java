package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.basic.room.addNewStudent;

public class FacultyPanel extends AppCompatActivity {
    Button addStudentBtn, viewStudentsBtn, viewAttendanceBtn, addFacultyBtn, viewFacultyBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_panel);

        addStudentBtn = findViewById(R.id.add_student);
        viewStudentsBtn = findViewById(R.id.view_students);
        viewAttendanceBtn = findViewById(R.id.view_attendance_per_student);
        addFacultyBtn = findViewById(R.id.add_faculty);
        viewFacultyBtn = findViewById(R.id.view_faculty);
        logoutBtn = findViewById(R.id.logout);

        addStudentBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, addNewStudent.class));
        });

        viewStudentsBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewStudents.class)));
        viewAttendanceBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewAttendance.class)));
        addFacultyBtn.setOnClickListener(v -> startActivity(new Intent(this, AddFaculty.class)));
        viewFacultyBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewFaculty.class)));
    }
}