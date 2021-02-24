package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.protrainner.adapter.LoginAdapter;
import com.example.protrainner.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewpager;
    TextView textView;
    FloatingActionButton google;
    float v=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout = findViewById(R.id.tab_layout);
        viewpager = findViewById(R.id.view_pager);
        google = findViewById(R.id.fab_google);
        textView = findViewById(R.id.create_acc);

        tabLayout.addTab(tabLayout.newTab().setText("Member"));
        tabLayout.addTab(tabLayout.newTab().setText("Trainer"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterMemberActivity.class);
                startActivity(myIntent);
            }
        });

        final LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewpager.setAdapter(adapter);

        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        google.setTranslationY(300);
        tabLayout.setTranslationY(300);
        textView.setTranslationY(300);

        google.setAlpha(v);
        tabLayout.setAlpha(v);
        textView.setAlpha(v);

        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        textView.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();
    }

    public void onBackPressed() {
        //do nothing
    }


}