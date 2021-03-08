package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FtlTrainer1Activity extends AppCompatActivity {

    String id, nama;
    TextView tv1;
    EditText etSesi,etGt,etMg,etNote,etPemanasanNo,etPemanasanJp,etPemansanReps
            ,etPemanasanDurasi,etIntiNo,etIntiJp,etIntiLoad,etIntiReps,etIntiDurasi
            ,etIntiSet,etPendinginanNo,etPendinginanJp,etPendinginanReps,etPendinginanDurasi;
    Button buttonPemanasan,buttonInti,buttonPendinginan,buttonKonfirmasi;
    String Sesi,Gt,Mg,Note,PemanasanJp,PemanasanReps
            ,PemanasanDurasi,IntiJp,IntiLoad,IntiReps,IntiDurasi
            ,IntiSet,PendinginanJp,PendinginanReps,PendinginanDurasi;
    Integer noPemanasan,noPendinginan,noInti,noSesi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftl_trainer1);

        tv1 = findViewById(R.id.ftl_out_nama);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");
        id = b.getString("id");

        tv1.setText(nama);

        etSesi = findViewById(R.id.ftl_sesi);
        etGt= findViewById(R.id.ftl_goalTraining);
        etMg= findViewById(R.id.ftl_muscleGroup);
        etNote= findViewById(R.id.ftl_notes);

//        etPemanasanNo = findViewById(R.id.ftl_pemanasan_no);
//        etPemanasanJp= findViewById(R.id.ftl_pemanasan_jenis);
//        etPemansanReps= findViewById(R.id.ftl_pemanasan_reps);
//        etPemanasanDurasi= findViewById(R.id.ftl_pemanasan_durasi);
//
//
//        etIntiNo = findViewById(R.id.ftl_inti_no);
//        etIntiJp= findViewById(R.id.ftl_inti_jenis);
//        etIntiLoad= findViewById(R.id.ftl_inti_load);
//        etIntiReps= findViewById(R.id.ftl_inti_reps);
//        etIntiDurasi= findViewById(R.id.ftl_inti_durasi);
//        etIntiSet= findViewById(R.id.ftl_inti_set);
//
//
//        etPendinginanNo = findViewById(R.id.ftl_pendinginan_no);
//        etPendinginanJp= findViewById(R.id.ftl_pendinginan_jenis);
//        etPendinginanReps= findViewById(R.id.ftl_pendinginan_reps);
//        etPendinginanDurasi= findViewById(R.id.ftl_pendinginan_durasi);
//
//
//        buttonPemanasan= findViewById(R.id.button_ftl_pemanasan);
//        buttonInti= findViewById(R.id.button_ftl_inti);
//        buttonPendinginan= findViewById(R.id.button_ftl_pendinginan);
        buttonKonfirmasi= findViewById(R.id.konfirmasi_ftl);
//
//        buttonPemanasan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                noPemanasan = Integer.parseInt(etPemanasanNo.getText().toString());
//                PemanasanJp= etPemanasanJp.getText().toString();
//                PemanasanReps= etPemanasanJp.getText().toString();
//                PemanasanDurasi= etPemanasanDurasi.getText().toString();
//
//                DocumentReference df = fStore.collection("Akun").document(id).
//                        collection("FTL").document(Sesi).collection("Pemanasan").document(String.valueOf(noPemanasan));
//                Map<String,Object> userinfo = new HashMap<>();
//                userinfo.put("noPemanasan", noPemanasan);
//                userinfo.put("jenisPemanasan", PemanasanJp);
//                userinfo.put("repsPemanasan", PemanasanReps);
//                userinfo.put("durasiPemanasan", PemanasanDurasi);
//                df.set(userinfo);
//
//
//            }
//        });
//
//        buttonInti.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                noInti = Integer.parseInt(etIntiNo.getText().toString());
//                IntiJp= etIntiNo.getText().toString();
//                IntiLoad= etIntiLoad.getText().toString();
//                IntiReps= etIntiReps.getText().toString();
//                IntiDurasi= etIntiDurasi.getText().toString();
//                IntiSet= etIntiSet.getText().toString();
//
//                DocumentReference df = fStore.collection("Akun").document(id).
//                        collection("FTL").document(Sesi).collection("Inti").document(String.valueOf(noInti));
//                Map<String,Object> userinfo = new HashMap<>();
//                userinfo.put("noInti", noInti);
//                userinfo.put("jenisInti", IntiJp);
//                userinfo.put("loadInti", IntiLoad);
//                userinfo.put("repsInti", IntiReps);
//                userinfo.put("durasiInti", IntiDurasi);
//                userinfo.put("setInti", IntiSet);
//                df.set(userinfo);
//            }
//        });
//
//        buttonPendinginan.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                noPendinginan = Integer.parseInt(etPendinginanNo.getText().toString());
//                PendinginanJp= etPendinginanJp.getText().toString();
//                PendinginanReps= etPendinginanReps.getText().toString();
//                PendinginanDurasi= etPendinginanDurasi.getText().toString();
//
//                DocumentReference df = fStore.collection("Akun").document(id).
//                        collection("FTL").document(Sesi).collection("Pendinginan").document(String.valueOf(noPendinginan));
//                Map<String,Object> userinfo = new HashMap<>();
//                userinfo.put("noPendinginan", noPendinginan);
//                userinfo.put("jenisPendinginan", PendinginanJp);
//                userinfo.put("repsPendinginan", PendinginanReps);
//                userinfo.put("durasiPendinginan", PendinginanDurasi);
//                df.set(userinfo);
//            }
//        });
//
        buttonKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sesi = etSesi.getText().toString();
                Gt= etGt.getText().toString();
                Mg= etMg.getText().toString();
                Note= etNote.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(id).
                        collection("FTL").document(Sesi);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noSesi", Sesi);
                userinfo.put("goalTraining", Gt);
                userinfo.put("muscleGroup", Mg);
                userinfo.put("notes", Note);
                df.set(userinfo);

                Bundle c = new Bundle();
                c.putString("id",id);
                c.putString("sesi",Sesi);
                Intent inthome =new Intent(FtlTrainer1Activity.this, FtlTrainer2Activity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });
    }
}