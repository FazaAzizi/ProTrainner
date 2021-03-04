package com.example.protrainner.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profileTrainerFragment extends Fragment {

    TextView namal,ttl,mail,gender,addrs;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_trainer, container, false);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        namal = (TextView) view.findViewById(R.id.out_nama);
        ttl = (TextView) view.findViewById(R.id.out_ttl);
        mail = (TextView) view.findViewById(R.id.out_mail);
        gender = (TextView) view.findViewById(R.id.out_gender);
        addrs = (TextView) view.findViewById(R.id.out_address);

        userId = mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String namal1 = task.getResult().getString("Full name");
                    String mail1 = task.getResult().getString("Email");
                    namal.setText(namal1);
                    mail.setText(mail1);
                }
            }
        });

        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()){
                    String ttl1 = task.getResult().getString("Ttl");
                    String gender1 = task.getResult().getString("Jenis kelamin");
                    String addrs1 = task.getResult().getString("Alamat jogja");
                    ttl.setText(ttl1);
                    gender.setText(gender1);
                    addrs.setText(addrs1);
                }

            }
        });





        return view;

    }}
