package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.protrainner.activity.MemberOutFtlActivity;
import com.example.protrainner.R;
import com.example.protrainner.activity.PriceListMemberActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class homeMemberFragment extends Fragment {

    CardView cvPriceList,cvWs,cvFTL,cvDataPengukuran;
    FirebaseAuth mAuth;
    String id;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        mAuth = FirebaseAuth.getInstance();

        View view = inflater.inflate(R.layout.fragment_home_member, container, false);
        cvPriceList = (CardView) view.findViewById(R.id.kr1);
        cvWs= (CardView) view.findViewById(R.id.knn1);
        cvFTL= (CardView) view.findViewById(R.id.knn2);
        cvDataPengukuran= (CardView) view.findViewById(R.id.kr2);


        cvPriceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PriceListMemberActivity.class);
                startActivity(i);
            }
        });

        cvFTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = mAuth.getCurrentUser().getUid();
                Bundle b = new Bundle();
                b.putString("id",id);
                Intent i = new Intent(getActivity(), MemberOutFtlActivity.class);
                i.putExtras(b);
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
