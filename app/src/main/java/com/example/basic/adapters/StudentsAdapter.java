package com.example.basic.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.models.StudentsModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.MyViewHolder> {
    List<StudentsModel> studentsList;
    public StudentsAdapter(List<StudentsModel> studentsList) {
        this.studentsList = studentsList;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_students_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull MyViewHolder holder, int position) {
        holder.stud_name.setText(studentsList.get(position).getStudent_name());
        holder.reg_no.setText(studentsList.get(position).getReg_no());
        holder.attendance_percentage.setText(String.valueOf(studentsList.get(position).getAttendance()));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stud_name, reg_no, attendance_percentage;
        public MyViewHolder(@NotNull View itemView) {
            super(itemView);
            stud_name = itemView.findViewById(R.id.student_name);
            reg_no = itemView.findViewById(R.id.reg_no);
            attendance_percentage = itemView.findViewById(R.id.percentage_attendance);
        }
    }
}
