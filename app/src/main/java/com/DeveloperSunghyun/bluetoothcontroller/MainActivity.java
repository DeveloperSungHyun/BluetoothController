package com.DeveloperSunghyun.bluetoothcontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.DeveloperSunghyun.bluetoothcontroller.FragmentView.Controller_FragmentView;
import com.DeveloperSunghyun.bluetoothcontroller.FragmentView.Monitor_FragmentView;
import com.DeveloperSunghyun.bluetoothcontroller.FragmentView.Terminal_FragmentView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView BottomNavigationView_SelectButton;

    private void id_mapping(){
        BottomNavigationView_SelectButton = findViewById(R.id.BottomNavigationView_SelectButton);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id_mapping();


        BottomNavigationView_SelectButton.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.Controller){
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new Controller_FragmentView()).commit();
                    return true;
                }
                if(item.getItemId() == R.id.Monitor) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new Monitor_FragmentView()).commit();
                    return true;
                }
                if(item.getItemId() == R.id.Command) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new Terminal_FragmentView()).commit();
                    return true;
                }

                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        //초기 프래그먼트 뷰
        getSupportFragmentManager().beginTransaction().replace(R.id.FrameLayout_View, new Controller_FragmentView()).commit();
    }
}