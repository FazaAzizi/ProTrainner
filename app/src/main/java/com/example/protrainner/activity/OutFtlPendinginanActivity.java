package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

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

public class OutFtlPendinginanActivity extends AppCompatActivity {
    private RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private ListPendinginanAdapter adapterPendinginan;
    String sesi,uid,nama;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cfPemanasan,cfInti,cfPendinginan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_out_ftl_pendinginan);

        Bundle b = getIntent().getExtras();
        sesi = b.getString("sesi");
        uid = b.getString("id");
        nama = b.getString("nama");

        recyclerView3 = findViewById(R.id.list_ftl_pendinginan);
        cfPendinginan = fStore.collection("Akun").document(uid)
                .collection("FTL").document(sesi).collection("Pendinginan");
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
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
        adapterPendinginan.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterPendinginan.stopListening();
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("sesi",sesi);
        c.putString("id",uid);
        c.putString("nama",nama);
        Intent intent = new Intent(OutFtlPendinginanActivity.this, OutFtlDetailActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}