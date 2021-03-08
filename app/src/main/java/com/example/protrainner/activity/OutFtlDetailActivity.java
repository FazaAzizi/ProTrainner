package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private ListIntiAdapter adapterInti;
    private ListPemanasanAdapter adapterPemanasan;
    private ListPendinginanAdapter adapterPendinginan;
    TextView nama_df,sesi_df,gt_df,mg_df,notes_df;
    String sesi,uid,nama;
    FirebaseAuth mAuth;
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

        nama_df = findViewById(R.id.cek_ftl_nama);
        sesi_df = findViewById(R.id.cek_ftl_sesi);
        gt_df = findViewById(R.id.cek_ftl_gt);
        mg_df= findViewById(R.id.cek_ftl_mg);
        notes_df = findViewById(R.id.cek_ftl_note);

        recyclerView1 = findViewById(R.id.list_ftl_pemanasan);
        recyclerView2 = findViewById(R.id.list_ftl_inti);
        recyclerView3 = findViewById(R.id.list_ftl_pendinginan);

        DocumentReference df = fStore.collection("Akun").document(uid).collection("FTL").document(sesi);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String sesi = task.getResult().getString("noSesi");
                    String gt = task.getResult().getString("goalTraining");
                    String mg = task.getResult().getString("muscleGroup");
                    String notes = task.getResult().getString("notes");

                    nama_df.setText(nama);
                    sesi_df.setText(sesi);
                    gt_df.setText(gt);
                    mg_df.setText(mg);
                    notes_df.setText(notes);
                }
            }
        });

        cfPemanasan = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Pemanasan");

        cfInti = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Inti");

        cfPendinginan = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Pendinginan");

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        Query queryPemanasan = cfPemanasan;
        FirestoreRecyclerOptions<Pemanasan> options1 = new FirestoreRecyclerOptions.Builder<Pemanasan>()
                .setQuery(queryPemanasan,Pemanasan.class)
                .build();

        adapterPemanasan = new ListPemanasanAdapter(options1);
        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(adapterPemanasan);

        Query queryInti = cfInti;
        FirestoreRecyclerOptions<Inti> options2 = new FirestoreRecyclerOptions.Builder<Inti>()
                .setQuery(queryInti,Inti.class)
                .build();

        adapterInti = new ListIntiAdapter(options2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapterInti);

        Query queryPendinginan = cfPendinginan;
        FirestoreRecyclerOptions<Pendinginan> options3 = new FirestoreRecyclerOptions.Builder<Pendinginan>()
                .setQuery(queryPendinginan, Pendinginan.class)
                .build();

        adapterPendinginan = new ListPendinginanAdapter(options3);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        recyclerView3.setAdapter(adapterPendinginan);

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterPemanasan.startListening();
        adapterInti.startListening();
        adapterPendinginan.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterPemanasan.stopListening();
        adapterInti.stopListening();
        adapterPendinginan.stopListening();
    }
}