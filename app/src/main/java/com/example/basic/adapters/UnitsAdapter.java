package com.example.basic.adapters;

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
import com.example.basic.room.Units;

import java.util.List;

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.MyViewHolder> {
    List<Units> unitsList;
    Context context;
    public UnitsAdapter(Context context) {
        this.context = context;
    }

    public void setUnitsList(List<Units> unitsList) {
        this.unitsList = unitsList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_units_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitsAdapter.MyViewHolder holder, int position) {
        String unit_name, academic_year, semester, number_of_classes_learnt;
        unit_name = unitsList.get(position).unit_name;
        academic_year = unitsList.get(position).academic_year;
        semester = unitsList.get(position).semester;
        number_of_classes_learnt = unitsList.get(position).number_of_classes;
        holder.unit_name.setText(unit_name);
        holder.academicYear.setText(academic_year);
        holder.semester.setText(semester);
        holder.number_of_classes_learnt.setText(number_of_classes_learnt);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), TakeAttendance.class);
            String title = unit_name + " (" + semester + "-" + academic_year + ")";
            intent.putExtra("Unit Name", unit_name);
            intent.putExtra("Title", title);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return unitsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView unit_name, academicYear, semester, number_of_classes_learnt;
        public MyViewHolder(View itemView) {
            super(itemView);
            unit_name = itemView.findViewById(R.id.unit_name);
            academicYear = itemView.findViewById(R.id.academic_year);
            semester = itemView.findViewById(R.id.semester);
            number_of_classes_learnt = itemView.findViewById(R.id.number_of_classes);
        }
    }
}
