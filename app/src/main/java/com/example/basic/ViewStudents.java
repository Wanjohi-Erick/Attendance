package com.example.basic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.basic.room.addNewStudent;
import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;
import com.example.basic.room.StudentListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.Objects;

public class ViewStudents extends AppCompatActivity {
    StudentListAdapter studentListAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recyclerView);
        FloatingActionButton addStudent = findViewById(R.id.addNewUserButton);
        addStudent.setOnClickListener(v -> {
            startActivityForResult(new Intent(this, addNewStudent.class), 100);
        });
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
        List<Student> studentList = db.studentDao().getAllUsers();
        studentListAdapter.setUserList(studentList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        recreate();
    }
}