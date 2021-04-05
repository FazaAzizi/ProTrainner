package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MemberPengukuranDetailActivity extends AppCompatActivity {

    TextView tvnama,tvbb,tvtb;
    String id,nama,tanggal;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    ImageView ab,an;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_pengukuran_detail2);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        tvnama = (TextView)findViewById(R.id.tv_memberpengukurandetail_nama);
        tvbb =(TextView) findViewById(R.id.tv_out_bb);
        tvtb =(TextView) findViewById(R.id.tv_out_tb);

        ab = findViewById(R.id.ab_memberpengukurandetail);
        Bundle b = getIntent().getExtras();
        tanggal = b.getString("tgl");
        nama = b.getString("nama");
        id = b.getString("id");

        DocumentReference df1 = fStore.collection("Akun").document(id);
        df1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String name = task.getResult().getString("namalengkap");
                tvnama.setText(name);
            }
        });

        DocumentReference df = fStore.collection("Akun").document(id).collection("Pengukuran").document(tanggal);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String bb = task.getResult().getString("bb");
                    String tb = task.getResult().getString("tb");

                    //tvnama.setText(nama);
                    tvbb.setText(bb);
                    tvtb.setText(tb);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",id);
        Intent intent = new Intent(MemberPengukuranDetailActivity.this, MemberPengukuranActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}