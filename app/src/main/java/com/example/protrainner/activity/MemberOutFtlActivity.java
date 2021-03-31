package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListFtlAdapter;
import com.example.protrainner.adapter.ListTrainerAdapter;
import com.example.protrainner.model.FTL;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MemberOutFtlActivity extends AppCompatActivity implements  ListTrainerAdapter.OnItemClickListener  {

    private RecyclerView recyclerView;
    private ListFtlAdapter adapter;
    String nama,id;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_out_ftl);

        recyclerView = findViewById(R.id.rv_list_ftl_member);

        Bundle b = getIntent().getExtras();
        id = b.getString("id");

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        cF = fStore.collection("Akun").document(id).collection("FTL");
        Query query = cF;
        FirestoreRecyclerOptions<FTL> options = new FirestoreRecyclerOptions.Builder<FTL>()
                .setQuery(query,FTL.class)
                .build();

        adapter = new ListFtlAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListFtlAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                FTL ftl = dS.toObject(FTL.class);
                String sesii = ftl.getNoSesi();

                Bundle b = new Bundle();
                b.putString("sesi",sesii);
                b.putString("id",id);
                b.putString("nama",nama);

                Intent intent = new Intent(MemberOutFtlActivity.this, OutFtlDetailActivity.class);
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
        Intent intent = new Intent(MemberOutFtlActivity.this, MainActivity.class);
        startActivity(intent);
    }
}