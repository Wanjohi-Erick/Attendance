package com.example.basic.room;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.basic.R;

import java.util.Objects;

public class addNewStudent extends AppCompatActivity {
    EditText student_name, reg_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        student_name = findViewById(R.id.student_name_edit);
        reg_no = findViewById(R.id.reg_no_edit);
        Button save = findViewById(R.id.save);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        save.setOnClickListener(v -> saveNewUser(student_name.getText().toString(), reg_no.getText().toString()));
    }

    private void saveNewUser(String firstName, String lastName) {
        StudentDatabase db = StudentDatabase.getStudentDatabase(this.getApplicationContext());

        Student student = new Student();
        student.student_name = firstName;
        student.reg_no = lastName;
        db.studentDao().insertUser(student);

        finish();
    }
}