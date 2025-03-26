package com.example.androidproject;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
public class Dashboard extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    Intent i = new Intent();
    String email = i.getStringExtra("email");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbd);
        Intent i = new Intent();
        i.getStringExtra("email");
        findviews();
        ftoolbar();
    }
    private int[] iconList ={R.drawable.android,R.drawable.bluetooth, R.drawable.spotify};
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
        tab.getTabAt(0).setIcon(iconList[0]);
        tab.getTabAt(1).setIcon(iconList[1]);
        tab.getTabAt(2).setIcon(iconList[2]);
    }
    private void ftoolbar(){
        toolbar = findViewById(R.id.toolbar12);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.search){
            Toast.makeText(this,email,Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.cart){
            Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
        }
        else if(id == R.id.settings){
            Toast.makeText(this,"search",Toast.LENGTH_SHORT).show();
        }
        else if(id==android.R.id.home){
            Toast.makeText(this,"Back button clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}