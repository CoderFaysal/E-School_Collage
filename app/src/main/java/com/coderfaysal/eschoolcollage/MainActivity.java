package com.coderfaysal.eschoolcollage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Home home = new Home();
    Post post = new Post();
    Contact contact = new Contact();
    Setting setting = new Setting();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.nav_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.navigation_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, home).commit();
                        return true;

                    case R.id.navigation_post:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, post).commit();
                        return true;

                    case R.id.navigation_contact:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, contact).commit();
                        return true;

                    case R.id.navigation_setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, setting).commit();
                        return true;
                }
                return false;
            }
        });



    }
}