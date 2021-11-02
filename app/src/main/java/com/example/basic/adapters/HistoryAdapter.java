package com.example.basic.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.DayHistory;
import com.example.basic.R;
import com.example.basic.room.AttendanceModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {
    private Context context;
    private List<AttendanceModel> attendanceList;
    List<Date> listWithoutDuplicates = new ArrayList<>();

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

    public List<Date> dates() {
        for (int i = 0; i < attendanceList.size(); i++) {
            Date date = new Date(attendanceList.get(i).date);
            if (!(listWithoutDuplicates.contains(date))) {
                listWithoutDuplicates.add(date);
            }
        }
        return listWithoutDuplicates;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {
        holder.dateView.setText(String.valueOf(dates().get(position)));
        holder.dateView.setOnClickListener(v -> {
            Intent intent = new Intent(context.getApplicationContext(), DayHistory.class);
            intent.putExtra("Date", attendanceList.get(position).date);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return dates().size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView dateView;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            dateView = itemView.findViewById(R.id.date_view);
        }
    }
}
