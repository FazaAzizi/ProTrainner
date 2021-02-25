package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.protrainner.R;
import com.example.protrainner.fragment.homeTrainerFragment;
import com.example.protrainner.fragment.profileTrainerFragment;
import com.example.protrainner.fragment.settingTrainerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeTrainerActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_trainer);

        chipNavigationBar = findViewById(R.id.botNav);
        chipNavigationBar.setItemSelected(R.id.home_trainer,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new homeTrainerFragment()).commit();
        botMenu();

    }

    private void botMenu(){
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.home_trainer:
                        fragment = new homeTrainerFragment();
                        break;
                    case R.id.profile_trainer:
                        fragment = new profileTrainerFragment();
                        break;
                    case R.id.setting_trainer:
                        fragment = new settingTrainerFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            }
        });
    }
}