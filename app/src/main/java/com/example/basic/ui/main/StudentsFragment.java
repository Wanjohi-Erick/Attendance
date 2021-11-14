package com.example.basic.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.room.addNewStudent;
import com.example.basic.room.Student;
import com.example.basic.room.StudentDatabase;
import com.example.basic.room.StudentListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentsFragment extends Fragment {
    StudentListAdapter studentListAdapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students, container, false);
        FloatingActionButton addUser = view.findViewById(R.id.addNewUserButton);
        recyclerView = view.findViewById(R.id.recyclerView);
        addUser.setOnClickListener(v -> {
            startActivityForResult(new Intent(this.getActivity(), addNewStudent.class), 100);
        });

        initRecyclerView();
        loadUserList();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        studentListAdapter = new StudentListAdapter(this.getContext());
        recyclerView.setAdapter(studentListAdapter);
    }

    private void loadUserList() {
        StudentDatabase db = StudentDatabase.getStudentDatabase(this.getContext());
        List<Student> studentList = db.studentDao().getAllStudents();
        studentListAdapter.setUserList(studentList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        requireActivity().recreate();
    }
}
