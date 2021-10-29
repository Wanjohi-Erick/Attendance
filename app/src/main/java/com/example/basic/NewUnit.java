package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.basic.room.Units;
import com.example.basic.room.UnitsDatabase;

public class NewUnit extends AppCompatActivity {
    EditText unitName, academicYear, semester, attendanceExpectation;
    Button saveUnitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_unit);

        unitName = findViewById(R.id.unit_name);
        academicYear = findViewById(R.id.academic_year);
        semester = findViewById(R.id.semester);
        attendanceExpectation = findViewById(R.id.attendance_expectation);
        saveUnitBtn = findViewById(R.id.save_unit);

        saveUnitBtn.setOnClickListener(v -> {
            saveNewUnit(unitName.getText().toString(), academicYear.getText().toString(), semester.getText().toString(), attendanceExpectation.getText().toString());
        });
    }

    private void saveNewUnit(String unitName, String academicYear, String semester, String attendanceExpectation) {
        UnitsDatabase unitsDatabase = UnitsDatabase.getUnitsDatabase(getApplicationContext());
        Units units = new Units();
        units.unit_name = unitName;
        units.academic_year = academicYear;
        units.number_of_classes = attendanceExpectation;
        units.semester = semester;

        unitsDatabase.unitsDAO().insertUnit(units);

        finish();
    }
}