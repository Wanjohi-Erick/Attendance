package com.example.basic.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {

    private Context context;
    private List<Student> studentList;
    public StudentListAdapter(Context context) {
        this.context = context;
    }

    public void setUserList(List<Student> studentList) {
        this.studentList = studentList;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_students_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.studentName.setText(studentList.get(position).student_name);
        holder.reg_no.setText(studentList.get(position).reg_no);
        holder.percentage_attendance.setText(studentList.get(position).attendance);
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, reg_no, percentage_attendance;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            reg_no = itemView.findViewById(R.id.reg_no);
            percentage_attendance = itemView.findViewById(R.id.percentage_attendance);
        }
    }
}
