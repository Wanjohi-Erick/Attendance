package com.example.basic;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.basic.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TakeAttendance extends AppCompatActivity {
    TextView titleView;
    String title, unit_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_take_attendance);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        titleView = findViewById(R.id.title);
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("Title");
        unit_name = bundle.getString("Unit Name");
        titleView.setText(title);
        title();
        unitName();
    }

    public String title() {
        return title;
    }
    public String unitName() {
        return unit_name;
    }
}