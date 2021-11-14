package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.basic.adapters.FacultyListAdapter;
import com.example.basic.room.Faculty;
import com.example.basic.room.FacultyDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ViewFaculty extends AppCompatActivity {
    RecyclerView viewFacultyRecycler;
    FacultyListAdapter facultyListAdapter;
    List<Faculty> facultyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_faculty);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        viewFacultyRecycler = findViewById(R.id.view_faculty);
        viewFacultyRecycler.setHasFixedSize(true);
        viewFacultyRecycler.setLayoutManager(new LinearLayoutManager(this));
        facultyListAdapter = new FacultyListAdapter(this);

        FacultyDatabase facultyDatabase = FacultyDatabase.getAllFaculty(this);
        facultyList = facultyDatabase.facultyDao().getAllFaculty();
        facultyListAdapter.setFacultyList(facultyList);
        //Toast.makeText(this, "length: " + facultyList.size(), Toast.LENGTH_SHORT).show();
    }
}