package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basic.room.Faculty;
import com.example.basic.room.FacultyDatabase;

import java.util.Objects;

public class AddFaculty extends AppCompatActivity {
    EditText fNameEdit, lNameEdit, phoneEdit, addressEdit, usernameEdit, passEdit;
    Button submitBtn, cancelBtn;
    String first_name, last_name, phone, address, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        fNameEdit = findViewById(R.id.first_name);
        lNameEdit = findViewById(R.id.last_name);
        phoneEdit = findViewById(R.id.phone);
        addressEdit = findViewById(R.id.address);
        usernameEdit = findViewById(R.id.username);
        passEdit = findViewById(R.id.password);
        submitBtn = findViewById(R.id.submit);
        cancelBtn = findViewById(R.id.cancel);

        cancelBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, FacultyPanel.class));
            finish();
        });

        submitBtn.setOnClickListener(v -> {
            getFromEditTexts();
        });
    }

    private void getFromEditTexts() {
        first_name = fNameEdit.getText().toString();
        last_name = lNameEdit.getText().toString();
        phone = phoneEdit.getText().toString();
        address = addressEdit.getText().toString();
        username = usernameEdit.getText().toString();
        password = passEdit.getText().toString();

        if (checkFields(first_name, last_name, phone, address, username, password)) {
            createAccount(first_name, last_name, phone, address, username, password);
        }
    }

    private void createAccount(String first_name, String last_name, String phone, String address, String username, String password) {
        //todo Create account
        FacultyDatabase facultyDatabase = FacultyDatabase.getAllFaculty(this);
        Faculty faculty = new Faculty();
        faculty.first_name = first_name;
        faculty.last_name = last_name;
        faculty.phone  =phone;
        faculty.address = address;
        faculty.username = username;
        faculty.password = password;

        facultyDatabase.facultyDao().insertFaculty(faculty);
        startActivity(new Intent(this, ViewFaculty.class));
        finish();
    }

    private boolean checkFields(String first_name, String last_name, String phone, String address, String username, String password) {
        if (TextUtils.isEmpty(first_name)) {
            fNameEdit.setError("Field cannot be empty");
            fNameEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(last_name)) {
            lNameEdit.setError("Field cannot be empty");
            lNameEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(phone)) {
            phoneEdit.setError("Field cannot be empty");
            phoneEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(address)) {
            addressEdit.setError("Field cannot be empty");
            addressEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(username)) {
            usernameEdit.setError("Field cannot be empty");
            usernameEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            passEdit.setError("Field cannot be empty");
            passEdit.requestFocus();
            return false;
        }

        return true;
    }
}