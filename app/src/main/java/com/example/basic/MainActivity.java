package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.basic.adapters.UnitsAdapter;
import com.example.basic.models.UnitsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView unitsRecycler;
    UnitsAdapter unitsAdapter;
    List<UnitsModel> unitsList = new ArrayList<>();
    String unit_name, academic_year, semester;
    int number_of_classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unitsRecycler = findViewById(R.id.unitsRecycler);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewUnit.class);
            startActivity(intent);
        });
        unitsRecycler.setHasFixedSize(true);
        unitsRecycler.setLayoutManager(new LinearLayoutManager(this));

        //unitsList.add("Data Structures and Algorithms");
        //unitsList.add("Operating Systems");
        //unitsList.add("Database Systems");
        UnitsModel unitsModel = new UnitsModel(unit_name, academic_year, semester, number_of_classes);
        unitsModel.setUnit_name("Database Systems");
        unitsModel.setAcademic_year("2021/2022");
        unitsModel.setNumber_of_classes(10);
        unitsModel.setSemester("2.1");

        unitsList.add(unitsModel);

        unitsAdapter = new UnitsAdapter(unitsList);
        unitsRecycler.setAdapter(unitsAdapter);
    }
}