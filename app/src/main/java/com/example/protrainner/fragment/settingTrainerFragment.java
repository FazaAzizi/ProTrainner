package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.example.protrainner.activity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class settingTrainerFragment extends Fragment {
    CardView cv1,cv2;
    Button logout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_trainer, container, false);
        Button logout = (Button) view.findViewById(R.id.logout);
        cv1 = (CardView)view.findViewById(R.id.cardView2);
        cv2 = (CardView)view.findViewById(R.id.cardView3);

                logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}
