package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
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

public class FtlTrainer2Activity extends AppCompatActivity {

    String id, sesi,noPemanasan;
    ImageView ab,an;
    TextView tv1,etPemanasanOutNo,etPemanasanOutJp,etPemansanOutReps
            ,etPemanasanOutDurasi;;
    EditText etPemanasanNo,etPemanasanJp,etPemansanReps
            ,etPemanasanDurasi;

    Button buttonPemanasan,buttonPemanasanCek,buttonPemanasanNext,buttonInti,buttonPendinginan,buttonKonfirmasi;
    String Sesi,Gt,Mg,Note,PemanasanJp,PemanasanReps
            ,PemanasanDurasi,IntiJp,IntiLoad,IntiReps,IntiDurasi
            ,IntiSet,PendinginanJp,PendinginanReps,PendinginanDurasi;
    Integer noPendinginan,noInti,noSesi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftl_trainer2);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        sesi = b.getString("sesi");


        etPemanasanNo = findViewById(R.id.ftl_pemanasan_no);
        etPemanasanJp= findViewById(R.id.ftl_pemanasan_jenis);
        etPemansanReps= findViewById(R.id.ftl_pemanasan_reps);
        etPemanasanDurasi= findViewById(R.id.ftl_pemanasan_durasi);

        etPemanasanOutNo = findViewById(R.id.ftl_pemanasan_out_no);

        buttonPemanasan= findViewById(R.id.button_ftl_pemanasan);
        buttonPemanasanCek= findViewById(R.id.button_ftl_pemanasan_cek);
        //buttonPemanasanNext=findViewById(R.id.next_pemanasan);
        ab = findViewById(R.id.ab_ftl2);
        an = findViewById(R.id.an_ftl2);

        buttonPemanasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noPemanasan = etPemanasanNo.getText().toString();
                PemanasanJp= etPemanasanJp.getText().toString();
                PemanasanReps= etPemansanReps.getText().toString();
                PemanasanDurasi= etPemanasanDurasi.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(id).
                        collection("FTL").document(sesi).collection("Pemanasan").document(noPemanasan);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noPemanasan", noPemanasan);
                userinfo.put("jenisPemanasan", PemanasanJp);
                userinfo.put("repsPemanasan", PemanasanReps);
                userinfo.put("durasiPemanasan", PemanasanDurasi);
                df.set(userinfo);

                etPemanasanNo.setText("");
                etPemanasanJp.setText("");
                etPemansanReps.setText("");
                etPemanasanDurasi.setText("");

            }
        });

        buttonPemanasanCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPemanasan(v);
            }
        });



        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("id",id);
                c.putString("sesi",sesi);
                Intent inthome =new Intent(FtlTrainer2Activity.this, FtlTrainer3Activity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }

    public void loadPemanasan(View v){
        CollectionReference cr = fStore.collection("Akun").document(id).collection("FTL")
                .document(sesi).collection("Pemanasan");
        cr.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String data = "";
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Pemanasan pemanasan = documentSnapshot.toObject(Pemanasan.class);

                    String no = pemanasan.getNoPemanasan();
                    String jp = pemanasan.getJenisPemanasan();
                    String reps = pemanasan.getRepsPemanasan();
                    String durasi = pemanasan.getDurasiPemanasan();

                    data+= "No     : " +no+"\nJenis  :"+ jp+"\nReps   : "+reps+"\nDurasi :"+durasi+"\n\n";
//                    etPemanasanNo.setText(no);
//                    etPemanasanJp.setText(jp);
//                    etPemansanReps.setText(reps);
//                    etPemanasanDurasi.setText(durasi);
                }
                etPemanasanOutNo.setText(data);
            }

        });


    }
    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("id",id);
        c.putString("sesi",sesi);
        Intent intent = new Intent(FtlTrainer2Activity.this,FtlTrainer1Activity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}