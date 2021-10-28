package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.basic.room.AppDatabase;
import com.example.basic.room.User;

public class AddNewUser extends AppCompatActivity {
    EditText first, last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        first = findViewById(R.id.first_name);
        last = findViewById(R.id.last_name);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(v -> {
            saveNewUser(first.getText().toString(), last.getText().toString());
        });
    }

    private void saveNewUser(String firstName, String lastName) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.firstName = firstName;
        user.lastName = lastName;
        db.userDao().insertUser(user);

        finish();
    }
}