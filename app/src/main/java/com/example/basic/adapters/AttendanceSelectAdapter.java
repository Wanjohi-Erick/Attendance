package com.example.basic.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.RecordAttendance;
import com.example.basic.room.Student;
import com.example.basic.ui.main.AttendanceFragment;

import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public class AttendanceSelectAdapter extends RecyclerView.Adapter<AttendanceSelectAdapter.MyViewHolder> {
    Context context;
    List<Student> studentList;
    public AttendanceSelectAdapter(Context context) {
        this.context = context;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_attendance_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.studentName.setText(studentList.get(position).student_name);
        holder.regNo.setText(studentList.get(position).reg_no);
        holder.attendanceState.setOnClickListener(v -> {
            if (holder.attendanceState.getText().toString().equalsIgnoreCase("P")) {
                holder.attendanceState.setText("A");
                holder.attendanceState.setBackgroundColor(Color.rgb(243, 32, 19));
            } else {
                holder.attendanceState.setText("P");
                holder.attendanceState.setBackgroundColor(Color.rgb(0, 0, 255));
            }
        });
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, regNo, attendanceState;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            regNo = itemView.findViewById(R.id.reg_no);
            attendanceState = itemView.findViewById(R.id.attendance_state);
        }
    }
}
