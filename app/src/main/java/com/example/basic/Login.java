package com.example.basic;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basic.room.Faculty;
import com.example.basic.room.FacultyDatabase;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {
    private EditText loginEdit, usernameEdit, passwordEdit;
    private Button loginBtn;
    private String faculty, username, password;
    List<Faculty> loginDetails = new ArrayList<>();
    AlertDialog.Builder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEdit = findViewById(R.id.login_category);
        usernameEdit = findViewById(R.id.username);
        passwordEdit = findViewById(R.id.password);
        loginBtn = findViewById(R.id.login);
        dialogBuilder = new AlertDialog.Builder(this);

        loginBtn.setOnClickListener(v -> getFromEditTexts(loginEdit, usernameEdit, passwordEdit));
    }

    private void getFromEditTexts(EditText loginEdit, EditText usernameEdit, EditText passwordEdit) {
        faculty = loginEdit.getText().toString();
        username = usernameEdit.getText().toString();
        password = passwordEdit.getText().toString();

        if (!isFilled(faculty, username, password)) return;

        if (verifyLogin(faculty, username, password)) {
            startActivity(new Intent(this, FacultyPanel.class));
        }
    }

    private boolean verifyLogin(String faculty, String username, String password) {
        //todo get login details from database
        FacultyDatabase facultyDatabase = FacultyDatabase.getAllFaculty(this);
        loginDetails = facultyDatabase.facultyDao().getUser(username);
        if (loginDetails.size() > 0) {
            String dbPassword = loginDetails.get(0).password;
            if (password.equals(dbPassword)) {
                return true;
            } else {
                dialogBuilder.setTitle("Login Failed");
                dialogBuilder.setMessage("Check details and try again");
                dialogBuilder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                return false;
            }
        } else {
            dialogBuilder.setTitle("Login Failed");
            dialogBuilder.setMessage("User doesn't exist \n Please create an account if you don't have one");
            dialogBuilder.setPositiveButton("Ok", (dialog, which) -> dialog.dismiss());
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
            return false;
        }
    }

    private boolean isFilled(String faculty, String username, String password) {
        if (TextUtils.isEmpty(faculty)) {
            loginEdit.setError("Field cannot be empty");
            loginEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(username)) {
            usernameEdit.setError("Field cannot be empty");
            usernameEdit.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            passwordEdit.setError("Field cannot be empty");
            passwordEdit.requestFocus();
        }
        return true;
    }

    public void register(View view) {
        startActivity(new Intent(this, AddFaculty.class));
    }
}