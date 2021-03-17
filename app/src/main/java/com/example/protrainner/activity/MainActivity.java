package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.fragment.homeMemberFragment;
import com.example.protrainner.fragment.homeTrainerFragment;
import com.example.protrainner.fragment.profileMemberFragment;
import com.example.protrainner.fragment.profileTrainerFragment;
import com.example.protrainner.fragment.settingMemberFragment;
import com.example.protrainner.fragment.settingTrainerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    CardView c1,c2,c3,c4;
    LinearLayout l1,l2;
    FirebaseAuth mAuth;
    public String id;
    float v=0;
    ChipNavigationBar chipNavigationBar;
    private FirebaseAuth.AuthStateListener mAutStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        chipNavigationBar = findViewById(R.id.botNavMember);
        chipNavigationBar.setItemSelected(R.id.home_member,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_member,new homeMemberFragment()).commit();

//        id = mAuth.getCurrentUser().getUid();
        botMenu();

//        c1 = findViewById(R.id.kiri1);
//        c2 = findViewById(R.id.kanan1);
//        c3 = findViewById(R.id.kiri2);
//        c4 = findViewById(R.id.kanan2);
//        l1 = findViewById(R.id.kiri3);
//        l2 = findViewById(R.id.kanan3);
//        button = (Button) findViewById(R.id.logout);
//
//        c2.setTranslationX(800);
//        c4.setTranslationX(800);
//        l2.setTranslationX(800);
//        button.setTranslationY(300);
//        c1.setTranslationX(800);
//        c3.setTranslationX(800);
//        l1.setTranslationX(800);
//
//        c2.setAlpha(v);
//        c4.setAlpha(v);
//        l2.setAlpha(v);
//        c1.setAlpha(v);
//        c3.setAlpha(v);
//        l1.setAlpha(v);
//        button.setAlpha(v);
//
//        c2.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
//        c4.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
//        l2.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
//        c1.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
//        c3.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
//        l1.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
//        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
//
//
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent i = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });

    }

    private void botMenu(){
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {

            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i){
                    case R.id.home_member:
                        fragment = new homeMemberFragment();
//                        Bundle bundle= new Bundle();
//                        bundle.putString("id",id);
//                        fragment.setArguments(bundle);
                        break;
                    case R.id.profile_member:
                        fragment = new profileMemberFragment();
                        break;
                    case R.id.setting_member:
                        fragment = new settingMemberFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_member,fragment).commit();
            }
        });
    }

    public void onBackPressed() {
        //do nothing
    }


}