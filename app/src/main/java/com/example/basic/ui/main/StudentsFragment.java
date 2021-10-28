package com.example.basic.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.adapters.StudentsAdapter;
import com.example.basic.models.StudentsModel;

import java.util.ArrayList;
import java.util.List;

public class StudentsFragment extends Fragment {
    RecyclerView students_recycler;
    StudentsAdapter studentsAdapter;
    List<StudentsModel> studentsList = new ArrayList<StudentsModel>();
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_students, container, false);
        String student_name, reg_no;
        int attendance;
        students_recycler = view.findViewById(R.id.students_recycler);
         students_recycler.setHasFixedSize(true);
        students_recycler.setLayoutManager(new LinearLayoutManager(this.getContext()));
        student_name = "Erick Wanjohi";
        reg_no = "C026-01-0695/2020";
        attendance = 66;
        StudentsModel studentsModel = new StudentsModel(student_name, reg_no, attendance);
        studentsList.add(studentsModel);
        studentsAdapter = new StudentsAdapter(studentsList);
        students_recycler.setAdapter(studentsAdapter);

        return view;
    }
}
