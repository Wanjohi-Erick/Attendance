package com.example.basic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.basic.databinding.ActivityTakeAttendanceBinding;
import com.example.basic.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TakeAttendance extends AppCompatActivity {

    private ActivityTakeAttendanceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityTakeAttendanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        TextView title = binding.title;

        Bundle bundle = getIntent().getExtras();
        title.setText(bundle.getString("Title"));
    }
}