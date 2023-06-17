package com.example.mymusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.WindowManager;

import com.example.mymusic.Adapter.MainViewPagerAdapter;
import com.example.mymusic.Fragment.Fragment_Search;
import com.example.mymusic.Fragment.Fragment_Trangchu;
import com.example.mymusic.Fragment.Fragment_nhac_tren_ttt;
import com.example.mymusic.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView navigationView ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();

        MainViewPagerAdapter adapter = new MainViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_Trangchu(), "Home");
        adapter.addFragment(new Fragment_Search(), "Search");
        viewPager.setAdapter(adapter);

        

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        viewPager.setCurrentItem(0); // Chuyển đến fragment_home
                        return true;

                    case R.id.action_search:
                        viewPager.setCurrentItem(1); // Chuyển đến fragment_search
                        return true;
                }

                return false;
            }
        });
    }


    private void anhxa() {
        viewPager = findViewById(R.id.myViewPager);
        navigationView = findViewById(R.id.bottom_nav);
    }
}

