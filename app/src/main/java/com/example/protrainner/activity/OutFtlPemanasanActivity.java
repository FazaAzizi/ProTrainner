package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListIntiAdapter;
import com.example.protrainner.adapter.ListPemanasanAdapter;
import com.example.protrainner.adapter.ListPendinginanAdapter;
import com.example.protrainner.model.Inti;
import com.example.protrainner.model.Pemanasan;
import com.example.protrainner.model.Pendinginan;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class OutFtlPemanasanActivity extends AppCompatActivity {
    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private ListPemanasanAdapter adapterPemanasan;
    ImageView ab;
    String sesi,uid,nama,cek;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cfPemanasan,cfInti,cfPendinginan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_ftl_pemanasan);

        Bundle b = getIntent().getExtras();
        sesi = b.getString("sesi");
        uid = b.getString("id");
        nama = b.getString("nama");
        cek = b.getString("cek");
        ab = (ImageView)findViewById(R.id.ab_outftilpemanasan);
        recyclerView1 = findViewById(R.id.list_ftl_pemanasan);
        cfPemanasan = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Pemanasan");

        setUpRecyclerView();
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
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
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterPemanasan.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterPemanasan.stopListening();
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("sesi",sesi);
        c.putString("id",uid);
        c.putString("nama",nama);
        c.putString("cek",cek);
        Intent intent = new Intent(OutFtlPemanasanActivity.this, OutFtlDetailActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}