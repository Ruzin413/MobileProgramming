package com.example.androidproject;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
public class Dbd extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbd);
        findviews();
        ftoolbar();
    }
    private void setupWithViewPager(){
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Home_Fragment(),"Home");
        adapter.addFragment(new Profile_Fragment(),"Profile");
        adapter.addFragment(new Setting_Fragment(),"Settings");
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }
    private void findviews(){
        tab= findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);
        setupWithViewPager();
    }
    private void ftoolbar(){
        toolbar = findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}