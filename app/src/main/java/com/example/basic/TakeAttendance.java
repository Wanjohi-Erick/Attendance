package com.example.basic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.basic.ui.main.SectionsPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class TakeAttendance extends AppCompatActivity {
    TextView titleView;
    ImageButton backBtn;
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
        backBtn = findViewById(R.id.back_arrow);
        backBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });
        getBundle();
    }

    private void getBundle() {
        Bundle bundle = getIntent().getExtras();
        title = bundle.getString("title");
        //unit_name = bundle.getString("Unit Name");
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