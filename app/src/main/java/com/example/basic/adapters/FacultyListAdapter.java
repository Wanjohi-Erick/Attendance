package com.example.basic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.room.Faculty;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FacultyListAdapter extends RecyclerView.Adapter<FacultyListAdapter.MyViewHolder> {
    Context context;
    List<Faculty> facultyList;
    public FacultyListAdapter(Context context) {
        this.context = context;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
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
        holder.first.setText(facultyList.get(position).first_name);
        holder.last.setText(facultyList.get(position).last_name);
    }

    @Override
    public int getItemCount() {
        Toast.makeText(context.getApplicationContext(), "Size: " + facultyList.size(), Toast.LENGTH_SHORT).show();
        return facultyList.size();

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView first, last;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            first = itemView.findViewById(R.id.student_name);
            last = itemView.findViewById(R.id.reg_no);
        }
    }
}
