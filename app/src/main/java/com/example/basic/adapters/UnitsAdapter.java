package com.example.basic.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basic.R;
import com.example.basic.TakeAttendance;
import com.example.basic.models.UnitsModel;

import java.util.List;

public class UnitsAdapter extends RecyclerView.Adapter<UnitsAdapter.MyViewHolder> {
    List<UnitsModel> unitsList;
    public UnitsAdapter(List<UnitsModel> unitsList) {
        this.unitsList = unitsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_units_row, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UnitsAdapter.MyViewHolder holder, int position) {
        String unit_name, academic_year, semester;
        unit_name = unitsList.get(position).getUnit_name();
        academic_year = unitsList.get(position).getAcademic_year();
        semester = unitsList.get(position).getSemester();
        holder.unit_name.setText(unitsList.get(position).getUnit_name());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), TakeAttendance.class);
            String title = unitsList.get(position).getUnit_name() + " (" + semester + "-" + academic_year + ")";
            intent.putExtra("Title", title);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return unitsList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView unit_name;
        public MyViewHolder(View itemView) {
            super(itemView);
            unit_name = itemView.findViewById(R.id.unit_name);
        }
    }
}
