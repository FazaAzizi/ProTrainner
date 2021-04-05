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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class profileMemberFragment extends Fragment {

    TextView nL,tTL,mail,gndr,addrs,outBatuk,outDada,outSendi,outCedera,outCacat,outRokok,outTidur;
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
        outBatuk = (TextView) view.findViewById(R.id.parq_out_batuk);
        outDada = (TextView) view.findViewById(R.id.parq_out_dada);
        outSendi = (TextView) view.findViewById(R.id.parq_out_sendi);
        outCedera = (TextView) view.findViewById(R.id.parq_out_cedera);
        outCacat = (TextView) view.findViewById(R.id.parq_out_cacat);
        outRokok = (TextView)view.findViewById(R.id.parq_out_rokok);
        outTidur = (TextView) view.findViewById(R.id.parq_out_tidur);


        userId =mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("fullname");
                    String mail1 = task.getResult().getString("email");
                    String ttl1 = task.getResult().getString("ttl");
                    String gndr1 = task.getResult().getString("jeniskelamin");
                    String addr1 = task.getResult().getString("alamatjogja");

                    nL.setText(nL1);
                    mail.setText(mail1);
                    tTL.setText(ttl1);
                    gndr.setText(gndr1);
                    addrs.setText(addr1);
                }

            }
        });

        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String batuk = task.getResult().getString("batuk");
                    String cacat = task.getResult().getString("cacat");
                    String cedera = task.getResult().getString("cedera");
                    String dada = task.getResult().getString("dada");
                    String rokok = task.getResult().getString("rokok");
                    String sendi = task.getResult().getString("sendi");
                    String tidur = task.getResult().getString("tidur");

                    if(batuk.equals("1")){
                        outBatuk.setText("Ya");
                    }
                    if(batuk.equals("0")){
                        outBatuk.setText("Tidak");
                    }
                    if(sendi.equals("1")){
                        outSendi.setText("Ya");
                    }
                    if(sendi.equals("0")){
                        outSendi.setText("Tidak");
                    }
                    if(dada.equals("1")){
                        outDada.setText("Ya");
                    }
                    if(dada.equals("0")){
                        outDada.setText("Tidak");
                    }
                    if(cedera.equals("1")){
                        outCedera.setText("Ya");
                    }
                    if(cedera.equals("0")){
                        outCedera.setText("Tidak");
                    }
                    if(cacat.equals("1")){
                        outCacat.setText("Ya");
                    }
                    if(cacat.equals("0")){
                        outCacat.setText("Tidak");
                    }
                    if(rokok.equals("1")){
                        outRokok.setText("Ya");
                    }
                    if(rokok.equals("0")){
                        outRokok.setText("Tidak");
                    }
                    if(tidur.equals("1")){
                        outTidur.setText("Ya");
                    }
                    if(tidur.equals("0")){
                        outTidur.setText("Tidak");
                    }
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
