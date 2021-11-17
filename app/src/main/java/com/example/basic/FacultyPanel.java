package com.example.basic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class FacultyPanel extends AppCompatActivity {
    Button viewAddStudentBtn, viewAddSubjectBtn, viewAttendanceBtn, addFacultyBtn, viewFacultyBtn, logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_panel);

        viewAddStudentBtn = findViewById(R.id.view_add_student);
        viewAddSubjectBtn = findViewById(R.id.view_add_units);
        viewAttendanceBtn = findViewById(R.id.view_attendance_per_student);
        addFacultyBtn = findViewById(R.id.add_faculty);
        viewFacultyBtn = findViewById(R.id.view_faculty);
        logoutBtn = findViewById(R.id.logout);

        viewAddStudentBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewStudents.class)));
        viewAddSubjectBtn.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        viewAttendanceBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewAttendance.class)));
        addFacultyBtn.setOnClickListener(v -> startActivity(new Intent(this, AddFaculty.class)));
        viewFacultyBtn.setOnClickListener(v -> startActivity(new Intent(this, ViewFaculty.class)));
        logoutBtn.setOnClickListener(v -> startActivity(new Intent(this, Login.class)));
    }
}