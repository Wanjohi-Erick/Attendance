package com.example.basic.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.basic.R;
import com.example.basic.RecordAttendance;
import com.example.basic.room.AttendanceDatabase;
import com.example.basic.room.AttendanceModel;
import com.squareup.timessquare.CalendarPickerView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class AttendanceFragment extends Fragment {
    CalendarPickerView calendarView;
    Button takeAttendance;
    public Date today;
    public long instance;
    String selectedDate, title, unit_name;
    List<AttendanceModel> attendance = new ArrayList<>();
    List<Date> attendanceDates = new ArrayList<>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_take_attendance, container, false);
        takeAttendance = view.findViewById(R.id.take_attendance);
        calendarView = view.findViewById(R.id.calendar);
        Bundle bundle = requireActivity().getIntent().getExtras();
        title = bundle.getString("Title");
        //unit_name = bundle.getString("Unit Name");
        today = new Date();
        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);
        loadDates(this.getContext());
        if (attendanceDates.size() == 0) {
            calendarView.init(today, nextYear.getTime()).withSelectedDate(today);
            selectedDate = DateFormat.getDateInstance().format(today);
        } else {
           calendarView.init(attendanceDates.get(0), nextYear.getTime()).inMode(CalendarPickerView.SelectionMode.MULTIPLE).withSelectedDates(attendanceDates);
           selectedDate = DateFormat.getDateInstance().format(today);
        }
        calendarView.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {
                selectedDate = DateFormat.getDateInstance().format(date);
            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
        takeAttendance.setOnClickListener(v -> {
            Intent intent = new Intent(this.getActivity(), RecordAttendance.class);
            intent.putExtra("Date", selectedDate);
            intent.putExtra("Title", title);
            startActivityForResult(intent, 100);
        });
        return view;
    }

    private void loadDates(Context context) {
        AttendanceDatabase attendanceDatabase = AttendanceDatabase.getAttendanceDatabase(this.getContext());
        attendance = attendanceDatabase.attendanceDao().getAllAttendance(title);
        for (int position = 0; position < attendance.size(); position++) {
            Date newDate = new Date(attendance.get(position).date);
            attendanceDates.add(newDate);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        requireActivity().recreate();
    }
}
