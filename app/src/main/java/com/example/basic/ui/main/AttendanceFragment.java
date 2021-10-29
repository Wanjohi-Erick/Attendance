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


public class AttendanceFragment extends Fragment {
    CalendarView calendarView;
    Button takeAttendance;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_attendance, container, false);
        calendarView = view.findViewById(R.id.calendar);
        takeAttendance = view.findViewById(R.id.take_attendance);
        takeAttendance.setOnClickListener(v -> {
            startActivity(new Intent(this.getActivity(), RecordAttendance.class));
        });

        return view;
    }
}
