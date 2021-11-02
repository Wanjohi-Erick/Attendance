package com.example.basic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.basic.adapters.DayHistoryAdapter;
import com.example.basic.room.AttendanceDatabase;
import com.example.basic.room.AttendanceModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DayHistory extends AppCompatActivity {
    private RecyclerView dayHistoryRecycler;
    private List<AttendanceModel> attendanceList = new ArrayList<>();
    DayHistoryAdapter dayHistoryAdapter;
    TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_history);

        dayHistoryRecycler = findViewById(R.id.day_history_recycler);
        dateView = findViewById(R.id.date_view);
        dayHistoryAdapter = new DayHistoryAdapter(this);

        dayHistoryRecycler.setHasFixedSize(true);
        dayHistoryRecycler.setLayoutManager(new LinearLayoutManager(this));
        dayHistoryRecycler.setAdapter(dayHistoryAdapter);

        Bundle bundle = getIntent().getExtras();

        loadList(this, bundle);
    }

    private void loadList(Context context, Bundle bundle) {
        Date date = new Date(bundle.getString("Date"));
        dateView.setText(date.toString());
        //Toast.makeText(context, "date: " + date.toString(), Toast.LENGTH_SHORT).show();
        AttendanceDatabase attendanceDatabase = AttendanceDatabase.getAttendanceDatabase(context);
        attendanceList = attendanceDatabase.attendanceDao().select(date.toString());
        dayHistoryAdapter.setAttendanceList(attendanceList);
    }
}