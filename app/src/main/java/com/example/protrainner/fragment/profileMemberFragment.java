package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.example.protrainner.activity.LoginActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.concurrent.Executor;

public class profileMemberFragment extends Fragment {

    TextView nL,tTL,mail,gndr,addrs;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_member, container, false);


        //Button logout = (Button) view.findViewById(R.id.logout);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        nL = (TextView) view.findViewById(R.id.out_nama);
        tTL = (TextView) view.findViewById(R.id.out_ttl);
        mail = (TextView) view.findViewById(R.id.out_mail);
        gndr = (TextView) view.findViewById(R.id.out_gender);
        addrs = (TextView) view.findViewById(R.id.out_address);


        userId =mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("Full name");
                    String mail1 = task.getResult().getString("Email");
                    nL.setText(nL1);
                    mail.setText(mail1);
                }

            }
        });

        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String ttl1 = task.getResult().getString("Ttl");
                    String gndr1 = task.getResult().getString("Jenis kelamin");
                    String addr1 = task.getResult().getString("Alamat jogja");
                    tTL.setText(ttl1);
                    gndr.setText(gndr1);
                    addrs.setText(addr1);
                }
            }
        });

//        df.addSnapshotListener((Executor)this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                nL.setText(value.getString("Full name"));
//                mail.setText(value.getString("Email"));
//            }
//        });
//
//        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
//        df2.addSnapshotListener(getActivity(), new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
//                nL.setText(value.getString("Ttl"));
//                mail.setText(value.getString("Jenis kelamin"));
//                mail.setText(value.getString("Alamat jogja"));
//            }
//        });






        return view;
}}
