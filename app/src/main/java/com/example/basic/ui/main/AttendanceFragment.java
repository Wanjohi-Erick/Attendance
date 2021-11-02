package com.example.basic.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.basic.R;
import com.example.basic.RecordAttendance;

import java.util.Date;


public class AttendanceFragment extends Fragment {
    CalendarView calendarView;
    Button takeAttendance;
    public Date dateDate;
    public String date;
    public long instance;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_attendance, container, false);
        takeAttendance = view.findViewById(R.id.take_attendance);
        calendarView = view.findViewById(R.id.calendar);
        Bundle bundle = requireActivity().getIntent().getExtras();
        String title = bundle.getString("Title");
        takeAttendance.setOnClickListener(v -> {
            instance = calendarView.getDate();
            dateDate = new Date(instance);
            date = String.valueOf(dateDate);
            Intent intent = new Intent(this.getActivity(), RecordAttendance.class);
            intent.putExtra("Date", date);
            intent.putExtra("Title", title);
            startActivity(intent);
        });

        return view;
    }
}
