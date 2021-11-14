package com.example.basic.room;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.TakeAttendance;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StudentListAdapter extends RecyclerView.Adapter<StudentListAdapter.MyViewHolder> {

    private List<Student> studentList;

    public StudentListAdapter(Context context) {
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
        String first_name, last_name;
        first_name = String.format("%s,", studentList.get(position).first_name);
        last_name = studentList.get(position).last_name;
        holder.studentName.setText(first_name);
        holder.reg_no.setText(last_name);
        //holder.percentage_attendance.setText(studentList.get(position).attendance);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), TakeAttendance.class);
            String title = first_name + last_name;
            intent.putExtra("title", title);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, reg_no;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            reg_no = itemView.findViewById(R.id.reg_no);
        }
    }
}
