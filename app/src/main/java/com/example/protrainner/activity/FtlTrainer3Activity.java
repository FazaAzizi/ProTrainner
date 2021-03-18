package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.model.Inti;
import com.example.protrainner.model.Pemanasan;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FtlTrainer3Activity extends AppCompatActivity {

    String id, sesi,noInti;
    TextView tv1,etIntiOutNo;
    EditText etIntiNo,etIntiJp,etIntiReps
            ,etIntiDurasi,etIntiLoad,etIntiSet;

    Button buttonInti,buttonIntiCek,buttonIntiNext,buttonPendinginan,buttonKonfirmasi;
    String Sesi,Gt,Mg,Note,PemanasanJp,PemanasanReps
            ,PemanasanDurasi,IntiJp,IntiLoad,IntiReps,IntiDurasi
            ,IntiSet,PendinginanJp,PendinginanReps,PendinginanDurasi;
    Integer noPendinginan,noSesi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftl_trainer3);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        sesi = b.getString("sesi");


        etIntiNo = findViewById(R.id.ftl_inti_no);
        etIntiJp= findViewById(R.id.ftl_inti_jenis);
        etIntiLoad =findViewById(R.id.ftl_inti_load);
        etIntiReps= findViewById(R.id.ftl_inti_reps);
        etIntiDurasi= findViewById(R.id.ftl_inti_durasi);
        etIntiSet = findViewById(R.id.ftl_inti_set);
        etIntiOutNo = findViewById(R.id.ftl_inti_out_no);

        buttonInti= findViewById(R.id.button_ftl_inti);
        buttonIntiCek= findViewById(R.id.button_ftl_inti_cek);
        buttonIntiNext=findViewById(R.id.next_inti);

        buttonInti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noInti = etIntiNo.getText().toString();
                IntiJp= etIntiJp.getText().toString();
                IntiLoad = etIntiLoad.getText().toString();
                IntiReps= etIntiReps.getText().toString();
                IntiDurasi= etIntiDurasi.getText().toString();
                IntiSet = etIntiSet.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(id).
                        collection("FTL").document(sesi).collection("Inti").document(noInti);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noInti", noInti);
                userinfo.put("jenisInti", IntiJp);
                userinfo.put("loadInti",IntiLoad);
                userinfo.put("repsInti", IntiReps);
                userinfo.put("durasiInti", IntiDurasi);
                userinfo.put("setInti",IntiSet);
                df.set(userinfo);

                etIntiNo.setText("");
                etIntiJp.setText("");
                etIntiLoad.setText("");
                etIntiReps.setText("");
                etIntiDurasi.setText("");
                etIntiSet.setText("");
            }
        });

        buttonIntiCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPemanasan(v);
            }
        });

        buttonIntiNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("id",id);
                c.putString("sesi",sesi);
                Intent inthome =new Intent(FtlTrainer3Activity.this, FtlTrainer4Activity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });

    }
    public void loadPemanasan(View v){
        CollectionReference cr = fStore.collection("Akun").document(id).collection("FTL")
                .document(sesi).collection("Inti");
        cr.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String data = "";
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Inti inti = documentSnapshot.toObject(Inti.class);


                    String no = inti.getNoInti();
                    String jp = inti.getJenisInti();
                    String load = inti.getLoadInti();
                    String reps = inti.getRepsInti();
                    String durasi = inti.getDurasiInti();
                    String set = inti.getSetInti();

                    data+= "No     : " +no+"\nJenis  :"+ jp+"\nLoad   : "+load+"\nReps   : "+reps+"\nDurasi :"+durasi+"\nSet    : "+set+"\n\n";
                }
                etIntiOutNo.setText(data);
            }

        });


    }
}