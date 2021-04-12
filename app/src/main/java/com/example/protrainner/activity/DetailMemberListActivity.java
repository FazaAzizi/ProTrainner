package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DetailMemberListActivity extends AppCompatActivity {

    String uid,nm,nmtrainer;
    TextView nL,tTL,gndr,addrsJgj,addrsAsal,outDada,outSendi,outCedera,outCacat,outRokok,outTidur;

    TextView outBatuk;
    Button btFtl,btUkur, btFtlCek, btUkurCek;
    ImageView ab;
    Button bt;
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

        bt = findViewById(R.id.bt_addmember_detailmemberlist);
        ab = findViewById(R.id.ab_memberlist);


        outBatuk = (TextView) findViewById(R.id.parq_out_batuk);
        outDada = (TextView) findViewById(R.id.parq_out_dada);
        outSendi = (TextView) findViewById(R.id.parq_out_sendi);
        outCedera = (TextView) findViewById(R.id.parq_out_cedera);
        outCacat = (TextView) findViewById(R.id.parq_out_cacat);
        outRokok = (TextView) findViewById(R.id.parq_out_rokok);
        outTidur = (TextView) findViewById(R.id.parq_out_tidur);


        Bundle b = getIntent().getExtras();
        uid = b.getString("UID");
        DocumentReference df = fStore.collection("Akun").document(mAuth.getCurrentUser().getUid());
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("namalengkap");

                    nmtrainer = nL1;
                }
            }
        });

        DocumentReference df3 = fStore.collection("Akun").document(uid);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("namalengkap");
                    String tTl1 = task.getResult().getString("ttl");
                    String  gndr1 = task.getResult().getString("jeniskelamin");
                    String addrsJgj1 = task.getResult().getString("alamatasal");

                    nm = nL1;
                    nL.setText(nL1);
                    tTL.setText(tTl1);
                    gndr.setText(gndr1);
                    addrsJgj.setText(addrsJgj1);
                }
            }
        });

        DocumentReference df1 = fStore.collection("Akun").document(uid).collection("Data").document(uid);
        df1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
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
        });

//        btFtl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle c = new Bundle();
//                c.putString("nama",nm);
//                c.putString("id",uid);
//                Intent intent = new Intent(DetailMemberListActivity.this, FtlTrainer1Activity.class);
//                intent.putExtras(c);
//                startActivity(intent);
//            }
//        });
//
//        btFtlCek.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle c = new Bundle();
//                c.putString("nama",nm);
//                c.putString("id",uid);
//                Intent intent = new Intent(DetailMemberListActivity.this, OutFtlActivity.class);
//                intent.putExtras(c);
//                startActivity(intent);
//            }
//        });
//
//        btUkur.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference df2 = fStore.collection("Akun").document(uid);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("isWaiting","1");
                userinfo.put("nameWaiting",nmtrainer);
                df2.update(userinfo);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetailMemberListActivity.this, MemberListActivity.class);
        startActivity(intent);
    }
}