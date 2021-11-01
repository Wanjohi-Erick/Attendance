package com.example.basic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.room.Student;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AttendanceSelectAdapter extends RecyclerView.Adapter<AttendanceSelectAdapter.MyViewHolder> {
    Context context;
    List<Student> studentList;
    String displayText;
    List<Student> checkedItems = new ArrayList<>();
    boolean isCheckedBool;
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
        holder.attendanceState.setOnCheckedChangeListener((buttonView, isChecked) -> {
            isCheckedBool = isChecked;
            if (isChecked) {
                checkedItems.add(studentList.get(position));
            }
        });
    }

    public List<Student> getCheckedItems() {
        return checkedItems;
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView studentName, regNo;
        CheckBox attendanceState;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            regNo = itemView.findViewById(R.id.reg_no);
            attendanceState = itemView.findViewById(R.id.attendance_state);
        }
    }
}
