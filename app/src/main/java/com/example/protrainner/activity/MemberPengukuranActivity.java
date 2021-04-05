package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListPengukuranAdapter;
import com.example.protrainner.model.Pengukuran;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MemberPengukuranActivity extends AppCompatActivity implements  ListPengukuranAdapter.OnItemClickListener{

    private RecyclerView recyclerView;
    private ListPengukuranAdapter adapter;
    String nama,id;
    ImageView ab,tmbh;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_pengukuran2);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        id = b.getString("id");

        ab = findViewById(R.id.ab_memberpengukuran);

        recyclerView = findViewById(R.id.rv_list_pengukuran);

        setUpRecyclerView();

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setUpRecyclerView() {
        cF = fStore.collection("Akun").document(id).collection("Pengukuran");
        Query query = cF;
        FirestoreRecyclerOptions<Pengukuran> options = new FirestoreRecyclerOptions.Builder<Pengukuran>()
                .setQuery(query,Pengukuran.class)
                .build();

        adapter = new ListPengukuranAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListPengukuranAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                Pengukuran pengukuran = dS.toObject(Pengukuran.class);
                String tgl = pengukuran.getTanggal();

                Bundle b = new Bundle();
                b.putString("tgl",tgl);
                b.putString("id",id);
                b.putString("nama",nama);

                Intent intent = new Intent(MemberPengukuranActivity.this, MemberPengukuranDetailActivity.class);
                intent.putExtras(b);
                startActivity(intent);

                //Toast.makeText(MemberListActivity.this, "id = " + id,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    public void onItemClick(DocumentSnapshot dS, int position) {

    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",id);
        Intent intent = new Intent(MemberPengukuranActivity.this, MainActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}