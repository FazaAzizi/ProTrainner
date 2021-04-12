package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PermintaanActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId,namaT;
    TextView namaTrainer;
    Button acc,tolak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permintaan);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        acc = (Button)findViewById(R.id.bt_accpermintaan);
        tolak = (Button)findViewById(R.id.bt_tolakpermintaan);
        namaTrainer = (TextView) findViewById(R.id.tv_nama_permintaan);

        userId =mAuth.getCurrentUser().getUid();


        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    namaT = task.getResult().getString("nameWaiting");

                    namaTrainer.setText(namaT);
                }
            }
        });
        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference df2 = fStore.collection("Akun").document(userId);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("isWaiting","0");
                userinfo.put("nameWaiting","");
                userinfo.put("isConnected","1");
                userinfo.put("nameConnected",namaT);
                df2.update(userinfo);
                Toast.makeText(PermintaanActivity.this,"Permohonan berhasil diterima",Toast.LENGTH_SHORT).show();
                namaTrainer.setText("");
            }
        });
        tolak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference df2 = fStore.collection("Akun").document(userId);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("isWaiting","0");
                userinfo.put("nameWaiting","");
                df2.update(userinfo);
                Toast.makeText(PermintaanActivity.this,"Permohonan ditolak",Toast.LENGTH_SHORT).show();
                namaTrainer.setText("");
            }
        });
    }
}