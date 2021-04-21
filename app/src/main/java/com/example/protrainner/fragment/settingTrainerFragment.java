package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.example.protrainner.activity.EditDataHargaActivity;
import com.example.protrainner.activity.EditDataMemberActivity;
import com.example.protrainner.activity.EditDataTrainerActivity;
import com.example.protrainner.activity.LoginActivity;
import com.example.protrainner.activity.SettingHargaTrainerActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class settingTrainerFragment extends Fragment {
    String id, no, durlat, harga;
    CardView cv1, cv2;
    Button logout;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_trainer, container, false);
        Button logout = (Button) view.findViewById(R.id.logout);
        cv1 = (CardView) view.findViewById(R.id.cardView2);
        cv2 = (CardView) view.findViewById(R.id.cardView3);




/*        id =mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(id).
                collection("Harga").document("Harga");
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    no = task.getResult().getString("noPaket");
                    durlat = task.getResult().getString("durasiLatihan");
                    harga = task.getResult().getString("harga");
                }

            }
        }); */



        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditDataTrainerActivity.class);
                startActivity(i);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SettingHargaTrainerActivity.class);
                startActivity(i);
            }
        });

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
