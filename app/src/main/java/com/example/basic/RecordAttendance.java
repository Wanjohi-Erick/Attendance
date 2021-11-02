package com.example.basic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basic.adapters.AttendanceSelectAdapter;
import com.example.basic.models.AttendanceStateModel;
import com.example.basic.room.AttendanceDatabase;
import com.example.basic.room.AttendanceModel;
import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RecordAttendance extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    Button saveAttendance;
    AttendanceSelectAdapter attendanceSelectAdapter;
    List<Student> studentList = new ArrayList<>();
    String unit_name;
    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_attendance);
        Bundle bundle = getIntent().getExtras();
        date = Calendar.getInstance().getTime();
        unit_name = bundle.getString("Title");

        recyclerView = findViewById(R.id.take_attendance_recycler);
        saveAttendance = findViewById(R.id.save_attendance_btn);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        attendanceSelectAdapter = new AttendanceSelectAdapter(this);

        StudentDatabase studentDatabase = StudentDatabase.getStudentDatabase(this);
        studentList = studentDatabase.studentDao().getAllUsers();
        attendanceSelectAdapter.setStudentList(studentList);

        recyclerView.setAdapter(attendanceSelectAdapter);
        saveAttendance.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == findViewById(R.id.save_attendance_btn)) {
            List<Student> studentsPresent = ((AttendanceSelectAdapter) Objects.requireNonNull(recyclerView.getAdapter())).getCheckedItems();
            Toast.makeText(this, "Size: " + studentsPresent.size(), Toast.LENGTH_SHORT).show();
            String student_name, reg_no, attendance_state, attendance_count;
            for (int i = 0; i < studentsPresent.size(); i++) {
                student_name = studentsPresent.get(i).student_name;
                reg_no = studentsPresent.get(i).reg_no;
                attendance_state = studentsPresent.get(i).attendance;
                attendance_count = "1";
                saveToDatabase(unit_name, date, student_name, reg_no, attendance_state, attendance_count);
            }
        }
    }

    private void saveToDatabase(String unit_name, Date date, String student_name, String reg_no, String attendance_state, String attendance_count) {
        AttendanceDatabase attendanceDatabase = AttendanceDatabase.getAttendanceDatabase(getApplicationContext());
        AttendanceModel attendance = new AttendanceModel();
        attendance.unit_name = unit_name;
        attendance.date = String.valueOf(date);
        attendance.student_name = student_name;
        attendance.reg_no = reg_no;
        attendance.attendance_state = attendance_state;
        attendance.attendance_count = attendance_count;

        attendanceDatabase.attendanceDao().insertAttendance(attendance);
    }
}