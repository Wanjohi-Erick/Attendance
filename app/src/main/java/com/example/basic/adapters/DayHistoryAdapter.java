package com.example.basic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.room.AttendanceModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DayHistoryAdapter extends RecyclerView.Adapter<DayHistoryAdapter.MyViewHolder> {
    Context context;
    List<AttendanceModel> attendanceList;
    public DayHistoryAdapter(Context applicationContext) {
        this.context = applicationContext;
    }

    public void setAttendanceList(List<AttendanceModel> attendanceList) {
        this.attendanceList = attendanceList;
        notifyDataSetChanged();
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
        holder.student_name.setText(attendanceList.get(position).student_name);
        holder.reg_no.setText(attendanceList.get(position).reg_no);
        holder.attendance_state.setChecked(true);
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView student_name, reg_no;
        CheckBox attendance_state;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            student_name = itemView.findViewById(R.id.student_name);
            reg_no = itemView.findViewById(R.id.reg_no);
            attendance_state = itemView.findViewById(R.id.attendance_state);
        }
    }
}
