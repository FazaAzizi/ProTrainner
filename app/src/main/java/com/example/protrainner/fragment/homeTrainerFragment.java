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
import com.example.protrainner.activity.BusinessPlanActivity;
import com.example.protrainner.activity.MemberListActivity;
import com.example.protrainner.activity.PriceListMemberActivity;
import com.example.protrainner.activity.TrainerListActivity;
import com.example.protrainner.activity.WsTrainerActivity;
import com.example.protrainner.activity.weekly_schedule_trainer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class homeTrainerFragment extends Fragment {

    CardView cvBp,cvWs,cvPtl,cvMl;
    FirebaseAuth mAuth;
    TextView nL;
    String id;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_trainer, container, false);

        mAuth = FirebaseAuth.getInstance();
        cvBp = (CardView) view.findViewById(R.id.kr1);
        cvWs= (CardView) view.findViewById(R.id.knn1);
        cvMl= (CardView) view.findViewById(R.id.knn2);
        cvPtl= (CardView) view.findViewById(R.id.kr2);
        nL = (TextView)view.findViewById(R.id.namaHomeTrainer);

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

        cvBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BusinessPlanActivity.class);
                startActivity(i);
            }
        });

        cvWs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), weekly_schedule_trainer.class);
                startActivity(i);
            }
        });

        cvPtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), TrainerListActivity.class);
                startActivity(i);
            }
        });

        cvMl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), MemberListActivity.class);
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
