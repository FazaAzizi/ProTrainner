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

import com.example.protrainner.activity.MemberOutFtlActivity;
import com.example.protrainner.R;
import com.example.protrainner.activity.MemberPengukuranActivity;
import com.example.protrainner.activity.PriceListMemberActivity;
import com.example.protrainner.activity.weekly_schedule_member;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class homeMemberFragment extends Fragment {

    CardView cvPriceList,cvWs,cvFTL,cvDataPengukuran;
    FirebaseAuth mAuth;
    TextView nL;
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
        nL = (TextView)view.findViewById(R.id.namaHome);

        id =mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(id);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("fullname");

                    nL.setText(nL1);
                }

            }
        });

        cvPriceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PriceListMemberActivity.class);
                startActivity(i);
            }
        });

        cvWs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), weekly_schedule_member.class);
                startActivity(i);
            }
        });

        cvDataPengukuran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id = mAuth.getCurrentUser().getUid();
                Bundle b = new Bundle();
                b.putString("id",id);
                Intent i = new Intent(getActivity(), MemberPengukuranActivity.class);
                i.putExtras(b);
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
