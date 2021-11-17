package com.example.basic.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.adapters.HistoryAdapter;
import com.example.basic.room.AttendanceDatabase;
import com.example.basic.room.AttendanceModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryFragment extends Fragment {
    RecyclerView recyclerView;
    HistoryAdapter historyAdapter;
    List<AttendanceModel> attendanceList;
    String title;
    private static final String TAG = "HistoryFragment";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerView = view.findViewById(R.id.history_recycler);
        historyAdapter = new HistoryAdapter(this.getContext());
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Bundle bundle = requireActivity().getIntent().getExtras();
        title = bundle.getString("title");

        loadHistory();
        Log.d(TAG, "onCreateView: size: " + attendanceList.size());
        //Toast.makeText(getContext(), "size: " + attendanceList.size(), Toast.LENGTH_SHORT).show();

        return view;
    }

    private void loadHistory() {
        AttendanceDatabase attendanceDatabase = AttendanceDatabase.getAttendanceDatabase(this.getContext());
        attendanceList = attendanceDatabase.attendanceDao().getAllAttendance(title);
        historyAdapter.setAttendanceList(attendanceList);
        recyclerView.setAdapter(historyAdapter);
    }
}
