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

public class OutFtlIntiActivity extends AppCompatActivity {

    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private ListIntiAdapter adapterInti;String sesi,uid,nama;
    ImageView ab;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cfPemanasan,cfInti,cfPendinginan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_ftl_inti);

        Bundle b = getIntent().getExtras();
        sesi = b.getString("sesi");
        uid = b.getString("id");
        nama = b.getString("nama");
        ab = (ImageView)findViewById(R.id.ab_outftilinti);

        recyclerView2 = findViewById(R.id.list_ftl_inti);

        cfInti = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Inti");

        setUpRecyclerView();
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setUpRecyclerView() {

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
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterInti.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterInti.stopListening();
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("sesi",sesi);
        c.putString("id",uid);
        c.putString("nama",nama);
        Intent intent = new Intent(OutFtlIntiActivity.this, OutFtlDetailActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}