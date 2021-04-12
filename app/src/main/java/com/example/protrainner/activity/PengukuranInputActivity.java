package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PengukuranInputActivity extends AppCompatActivity {

    ImageView ab;
    Button simpan;
    EditText etTanggal,etTb,etBb,etBf,etBmi,etVf,etBa,etLl,etLd
            ,etLgang,etLgul,etP,etB;
    String id,nama;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengukuran_input);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        id = b.getString("id");
        nama = b.getString("nama");

        etTanggal = (EditText)findViewById(R.id.et_du_tanggal);
        etTb= (EditText)findViewById(R.id.et_du_tb);
        etBb= (EditText)findViewById(R.id.et_du_bb);
        etBf= (EditText)findViewById(R.id.et_du_bf);
        etBmi= (EditText)findViewById(R.id.et_du_bmi);
        etVf= (EditText)findViewById(R.id.et_du_vf);
        etBa= (EditText)findViewById(R.id.et_du_ba);
        etLl= (EditText)findViewById(R.id.et_du_ll);
        etLd= (EditText)findViewById(R.id.et_du_ld);
        etLgang= (EditText)findViewById(R.id.et_du_lgang);
        etLgul= (EditText)findViewById(R.id.et_du_lgul);
        etP= (EditText)findViewById(R.id.et_du_lp);
        etB= (EditText)findViewById(R.id.et_du_tb);

        ab = (ImageView) findViewById(R.id.ab_du_input);
        simpan = (Button)findViewById(R.id.button_acc_du);

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Tanggal = etTanggal.getText().toString();
                String Tb = etTb.getText().toString();
                String Bb = etBb.getText().toString();
                String Bf = etBf.getText().toString();
                String Bmi = etBmi.getText().toString();
                String Vf = etVf.getText().toString();
                String Ba = etBa.getText().toString();
                String Ll = etLl.getText().toString();
                String Ld = etLd.getText().toString();
                String Lgang = etLgang.getText().toString();
                String Lgul = etLgul.getText().toString();
                String Lp = etP.getText().toString();
                String LB = etB.getText().toString();


                DocumentReference df = fStore.collection("Akun").document(id).collection("Pengukuran").document(Tanggal);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("tanggal",Tanggal);
                userinfo.put("tb",Tb);
                userinfo.put("bb",Bb);
                userinfo.put("bf",Bf);
                userinfo.put("bmi",Bmi);
                userinfo.put("vf",Vf);
                userinfo.put("ba",Ba);
                userinfo.put("ll",Ll);
                userinfo.put("ld",Ld);
                userinfo.put("lgang",Lgang);
                userinfo.put("lgul",Lgul);
                userinfo.put("lp",Lp);
                userinfo.put("lb",LB);
                df.set(userinfo);

                Bundle c = new Bundle();
                c.putString("nama",nama);
                c.putString("id",id);
                Intent inthome =new Intent(PengukuranInputActivity.this, DetailMemberList2Activity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",id);
        Intent intent = new Intent(PengukuranInputActivity.this, PengukuranActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}