package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.example.protrainner.activity.LoginActivity;
import com.example.protrainner.activity.PriceListMemberActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class homeMemberFragment extends Fragment {

    CardView cvPriceList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_member, container, false);
        cvPriceList = (CardView) view.findViewById(R.id.kr1);

        cvPriceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PriceListMemberActivity.class);
                startActivity(i);
            }
        });



        return view;




//        Button logout = findViewById(R.id.logout);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                Intent i = new Intent(HomeTrainerActivity.this, LoginActivity.class);
//                startActivity(i);
//            }
//        });
    }
}
