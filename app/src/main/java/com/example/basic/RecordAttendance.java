package com.example.basic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basic.adapters.AttendanceSelectAdapter;
import com.example.basic.models.AttendanceStateModel;
import com.example.basic.room.AttendanceDatabase;
import com.example.basic.room.AttendanceModel;
import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecordAttendance extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    Button saveAttendance;
    AttendanceSelectAdapter attendanceSelectAdapter;
    List<Student> studentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_attendance);
        Bundle bundle = getIntent().getExtras();
        String date = bundle.getString("Date");

        recyclerView = findViewById(R.id.take_attendance_recycler);
        saveAttendance = findViewById(R.id.save_attendance_btn);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        attendanceSelectAdapter = new AttendanceSelectAdapter(this);

        StudentDatabase studentDatabase = StudentDatabase.getStudentDatabase(this);
        studentList = studentDatabase.studentDao().getAllUsers();
        attendanceSelectAdapter.setStudentList(studentList);

        recyclerView.setAdapter(attendanceSelectAdapter);
        saveAttendance.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.save_attendance_btn)) {
            List<Student> studentsPresent = ((AttendanceSelectAdapter) Objects.requireNonNull(recyclerView.getAdapter())).getCheckedItems();
            Toast.makeText(this, "Size: " + studentsPresent.size(), Toast.LENGTH_SHORT).show();
            //todo Save the attendance records on the attendance database
        }
    }
}