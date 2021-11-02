package com.example.basic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.room.AttendanceModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private Context context;
    private List<AttendanceModel> attendanceList;

    public HistoryAdapter(Context context) {
        this.context = context;
    }

    public void setAttendanceList(List<AttendanceModel> attendanceList) {
        this.attendanceList = attendanceList;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_history_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.dateView.setText(attendanceList.get(position).date);
        //TODO Remove duplicating dates in history fragment and view individual student attendances inside
    }

    @Override
    public int getItemCount() {
        return attendanceList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dateView;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dateView = itemView.findViewById(R.id.date_view);
        }
    }
}
