package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailMemberListActivity extends AppCompatActivity {

    String uid,nm;
    TextView nL,tTL,gndr,addrsJgj,addrsAsal;
    Button btFtl,btUkur;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_member_list);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        nL = findViewById(R.id.tvMl1);
        tTL = findViewById(R.id.tvMl2);
        gndr = findViewById(R.id.tvMl3);
        addrsJgj = findViewById(R.id.tvMl4);
        addrsAsal = findViewById(R.id.tvMl5);

        btFtl = findViewById(R.id.inp_ftl);
        btUkur = findViewById(R.id.inp_dataukur);



        Bundle b = getIntent().getExtras();
        uid = b.getString("UID");

        DocumentReference df = fStore.collection("Akun").document(uid).collection("Data").document(uid);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("namalengkap");
                    String tTl1 = task.getResult().getString("ttl");
                    String  gndr1 = task.getResult().getString("jeniskelamin");
                    String addrsJgj1 = task.getResult().getString("alamatasal");
                    String addrsAsal1 = task.getResult().getString("alamatjogja");

                    nm = nL1;

                    nL.setText(nL1);
                    tTL.setText(tTl1);
                    gndr.setText(gndr1);
                    addrsJgj.setText(addrsJgj1);
                    addrsAsal.setText(addrsAsal1);

                }

            }
        });

        btFtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("nama",nm);
                c.putString("id",uid);
                Intent intent = new Intent(DetailMemberListActivity.this, FtlTrainer1Activity.class);
                intent.putExtras(c);
                startActivity(intent);
            }
        });

        btUkur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}