package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.model.Pemanasan;
import com.example.protrainner.model.Pendinginan;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class FtlTrainer4Activity extends AppCompatActivity {

    String id, sesi,noPendinginan;
    TextView tv1,etPendinginanOutNo,etPemanasanOutJp,etPemansanOutReps
            ,etPemanasanOutDurasi;
    EditText etPendinginanNo,etPendinginanJp,etPendinginanReps
            ,etPendinginanDurasi;

    Button buttonPendinginan,buttonPendinginanCek,buttonPendinginanNext,buttonInti,buttonKonfirmasi;
    String Sesi,Gt,Mg,Note,PemanasanJp,PemanasanReps
            ,PemanasanDurasi,IntiJp,IntiLoad,IntiReps,IntiDurasi
            ,IntiSet,PendinginanJp,PendinginanReps,PendinginanDurasi;
    Integer noInti,noSesi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftl_trainer4);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        sesi = b.getString("sesi");

        etPendinginanNo = findViewById(R.id.ftl_pendinginan_no);
        etPendinginanJp= findViewById(R.id.ftl_pendinginan_jenis);
        etPendinginanReps= findViewById(R.id.ftl_pendinginan_reps);
        etPendinginanDurasi= findViewById(R.id.ftl_pendinginan_durasi);

        etPendinginanOutNo = findViewById(R.id.ftl_pendinginan_out_no);

        buttonPendinginan= findViewById(R.id.button_ftl_pendinginan);
        buttonPendinginanCek= findViewById(R.id.button_ftl_pendinginan_cek);
        buttonPendinginanNext=findViewById(R.id.finish_ftl);

        buttonPendinginan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noPendinginan = etPendinginanNo.getText().toString();
                PendinginanJp= etPendinginanJp.getText().toString();
                PendinginanReps= etPendinginanReps.getText().toString();
                PendinginanDurasi= etPendinginanDurasi.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(id).
                        collection("FTL").document(sesi).collection("Pendinginan").document(noPendinginan);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noPendinginan", noPendinginan);
                userinfo.put("jenisPendinginan", PendinginanJp);
                userinfo.put("repsPendinginan", PendinginanReps);
                userinfo.put("durasiPendinginan", PendinginanDurasi);
                df.set(userinfo);

                etPendinginanNo.setText("");
                etPendinginanJp.setText("");
                etPendinginanReps.setText("");
                etPendinginanDurasi.setText("");

            }
        });

        buttonPendinginanCek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPendinginan(v);
            }
        });

        buttonPendinginanNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("UID",id);
                Intent inthome =new Intent(FtlTrainer4Activity.this, DetailMemberListActivity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });
    }

    public void loadPendinginan(View v){
        CollectionReference cr = fStore.collection("Akun").document(id).collection("FTL")
                .document(sesi).collection("Pendinginan");
        cr.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String data = "";
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for(QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Pendinginan pendinginan = documentSnapshot.toObject(Pendinginan.class);

                    String no = pendinginan.getNoPendinginan();
                    String jp = pendinginan.getJenisPendinginan();
                    String reps = pendinginan.getRepsPendinginan();
                    String durasi = pendinginan.getDurasiPendinginan();

                    data+= "No     : " +no+"\nJenis  :"+ jp+"\nReps   : "+reps+"\nDurasi :"+durasi+"\n\n";
//                    etPemanasanNo.setText(no);
//                    etPemanasanJp.setText(jp);
//                    etPemansanReps.setText(reps);
//                    etPemanasanDurasi.setText(durasi);
                }
                etPendinginanOutNo.setText(data);
            }

        });


    }
}