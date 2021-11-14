package com.example.basic.room;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.basic.R;

import java.util.Objects;

public class addNewStudent extends AppCompatActivity {
    EditText firstNameEdit, lastNameEdit, phoneEdit, emailEdit;
    Spinner programSpinner, semesterSpinner;
    String first_name, last_name, phone, email, program, semester;
    String[] programs = {"Computer Science", "Mechanical Engineering", "Information Technology"};
    String[] semesters = {"1.1", "1.2", "1.3", "2.1", "2.2", "2.3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        firstNameEdit = findViewById(R.id.first_name_edit);
        lastNameEdit = findViewById(R.id.last_name_edit);
        phoneEdit = findViewById(R.id.contact_edit);
        emailEdit = findViewById(R.id.address_edit);
        programSpinner = findViewById(R.id.program);
        semesterSpinner = findViewById(R.id.semester);
        SpinnerAdapter programAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, programs);
        programSpinner.setAdapter(programAdapter);
        SpinnerAdapter semesterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, semesters);
        semesterSpinner.setAdapter(semesterAdapter);
        Button save = findViewById(R.id.save);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        save.setOnClickListener(v -> verifyInputs(firstNameEdit, lastNameEdit, phoneEdit, emailEdit, programSpinner, semesterSpinner));
    }

    private void verifyInputs(EditText firstNameEdit, EditText lastNameEdit, EditText phoneEdit, EditText emailEdit, Spinner programSpinner, Spinner semesterSpinner) {
        first_name = firstNameEdit.getText().toString();
        last_name = lastNameEdit.getText().toString();
        phone = phoneEdit.getText().toString();
        email = emailEdit.getText().toString();
        program = programSpinner.getSelectedItem().toString();
        semester = semesterSpinner.getSelectedItem().toString();

        if (TextUtils.isEmpty(first_name)) {
            firstNameEdit.setError("Field cannot be empty");
            firstNameEdit.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(last_name)) {
            lastNameEdit.setError("Field cannot be empty");
            lastNameEdit.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(phone)) {
            phoneEdit.setError("Field cannot be empty");
            phoneEdit.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            emailEdit.setError("Field cannot be empty");
            emailEdit.requestFocus();
        }
        saveNewUser(first_name, last_name, phone, email, program, semester);
    }

    private void saveNewUser(String first_name, String last_name, String phone, String email, String program, String semester) {
        StudentDatabase db = StudentDatabase.getStudentDatabase(this.getApplicationContext());

        Student student = new Student();
        student.first_name = first_name;
        student.last_name = last_name;
        student.phone = phone;
        student.email = email;
        student.program = program;
        student.semester = semester;
        db.studentDao().insertUser(student);

        finish();
    }
}