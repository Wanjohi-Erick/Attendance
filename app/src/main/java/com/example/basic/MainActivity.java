package com.example.basic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.basic.adapters.UnitsAdapter;
import com.example.basic.models.UnitsModel;
import com.example.basic.room.Units;
import com.example.basic.room.UnitsDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView unitsRecycler;
    UnitsAdapter unitsAdapter;
    List<Units> unitsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolbar = getSupportActionBar();
        assert toolbar != null;
        toolbar.setTitle("Units");

        unitsRecycler = findViewById(R.id.unitsRecycler);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            Intent intent = new Intent(this, NewUnit.class);
            startActivityForResult(intent, 100);
        });
        unitsRecycler.setHasFixedSize(true);
        unitsRecycler.setLayoutManager(new LinearLayoutManager(this));

        UnitsDatabase unitsDatabase = UnitsDatabase.getUnitsDatabase(this);
        unitsList = unitsDatabase.unitsDAO().getAllUnits();
        unitsAdapter = new UnitsAdapter(this);
        unitsAdapter.setUnitsList(unitsList);
        unitsRecycler.setAdapter(unitsAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        recreate();
    }
}