package com.example.basic;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;
import com.example.basic.room.StudentListAdapter;

import java.util.List;
import java.util.Objects;

public class ViewAttendance extends AppCompatActivity {
    StudentListAdapter studentListAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);
        recyclerView = findViewById(R.id.recyclerView);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        initRecyclerView();
        loadUserList();
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        studentListAdapter = new StudentListAdapter(this);
        recyclerView.setAdapter(studentListAdapter);
    }

    private void loadUserList() {
        StudentDatabase db = StudentDatabase.getStudentDatabase(this);
        List<Student> studentList = db.studentDao().getAllStudents();
        studentListAdapter.setUserList(studentList);
    }
}