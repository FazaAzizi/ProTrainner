package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListIntiAdapter;
import com.example.protrainner.adapter.ListPemanasanAdapter;
import com.example.protrainner.adapter.ListPendinginanAdapter;
import com.example.protrainner.adapter.ListTrainerAdapter;
import com.example.protrainner.model.Akun;
import com.example.protrainner.model.Inti;
import com.example.protrainner.model.Pemanasan;
import com.example.protrainner.model.Pendinginan;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class OutFtlDetailActivity extends AppCompatActivity {

    Button btPemanasan,btPendinginan,btInti;
    TextView nama_df,sesi_df,gt_df,mg_df,notes_df,tanggal_df;
    String sesi,uid,nama,mg,notes,gt,cek,tanggal;
    FirebaseAuth mAuth;
    ImageView ab;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cfPemanasan,cfInti,cfPendinginan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_ftl_detail);

        Bundle b = getIntent().getExtras();
        sesi = b.getString("sesi");
        uid = b.getString("id");
        nama = b.getString("nama");
        cek = b.getString("cek");

        ab =(ImageView) findViewById(R.id.ab_outftldetail);

        sesi_df = findViewById(R.id.cek_ftl_sesi);
        gt_df = findViewById(R.id.cek_ftl_gt);
        mg_df= findViewById(R.id.cek_ftl_mg);
        notes_df = findViewById(R.id.cek_ftl_note);
        tanggal_df = findViewById(R.id.cek_ftl_tgl);

        btPemanasan = (Button) findViewById(R.id.bt_pemanasan_outftldetail);
        btInti = (Button) findViewById(R.id.bt_inti_outftldetail);
        btPendinginan = (Button) findViewById(R.id.bt_pendinginan_outftldetail);

//        recyclerView1 = findViewById(R.id.list_ftl_pemanasan);
//        recyclerView2 = findViewById(R.id.list_ftl_inti);
//        recyclerView3 = findViewById(R.id.list_ftl_pendinginan);

        DocumentReference df = fStore.collection("Akun").document(uid).collection("FTL").document(sesi);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    tanggal = task.getResult().getString("tanggal");
                    sesi = task.getResult().getString("noSesi");
                    gt = task.getResult().getString("goalTraining");
                    mg = task.getResult().getString("muscleGroup");
                    notes = task.getResult().getString("notes");

                    tanggal_df.setText(tanggal);
                    sesi_df.setText(sesi);
                    gt_df.setText(gt);
                    mg_df.setText(mg);
                    notes_df.setText(notes);
                }
            }
        });

        btPemanasan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("sesi",sesi);
                b.putString("id",uid);
                b.putString("nama",nama);
                b.putString("cek",cek);
                Intent intent = new Intent(OutFtlDetailActivity.this, OutFtlPemanasanActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btInti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("sesi",sesi);
                b.putString("id",uid);
                b.putString("nama",nama);
                b.putString("cek",cek);
                Intent intent = new Intent(OutFtlDetailActivity.this, OutFtlIntiActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        btPendinginan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("sesi",sesi);
                b.putString("id",uid);
                b.putString("nama",nama);
                b.putString("cek",cek);
                Intent intent = new Intent(OutFtlDetailActivity.this, OutFtlPendinginanActivity.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",uid);
        if (cek.equals("0")){
            Intent intent = new Intent(OutFtlDetailActivity.this, OutFtlActivity.class);
            intent.putExtras(c);
            startActivity(intent);
        }
        if (cek.equals("1")){
            Intent intent = new Intent(OutFtlDetailActivity.this, MemberOutFtlActivity.class);
            intent.putExtras(c);
            startActivity(intent);
        }

    }

}