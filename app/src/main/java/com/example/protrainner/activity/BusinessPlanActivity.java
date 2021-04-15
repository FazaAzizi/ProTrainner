package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListBPAdapter;
import com.example.protrainner.adapter.ListFtlAdapter;
import com.example.protrainner.model.BP;
import com.example.protrainner.model.FTL;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class BusinessPlanActivity extends AppCompatActivity {

private RecyclerView recyclerView;
private ListBPAdapter adapter;
        String nama,id,coba;
        ImageView ab,tmbh;
        FirebaseAuth mAuth;
        FirebaseFirestore fStore = FirebaseFirestore.getInstance();
private CollectionReference cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_plan);
        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");
        id = b.getString("id");

        ab = findViewById(R.id.ab_bp);
        tmbh = findViewById(R.id.tambah_bp);

        recyclerView = findViewById(R.id.rv_bp);

        setUpRecyclerView();

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("nama",nama);
                c.putString("id",id);
                Intent intent = new Intent(BusinessPlanActivity.this, BusinessPlanInputActivity.class);
                intent.putExtras(c);
                startActivity(intent);
            }
        });
    }

    private void setUpRecyclerView() {
        cF = fStore.collection("Akun").document(id).collection("BP");
        Query query = cF;
        FirestoreRecyclerOptions<BP> options = new FirestoreRecyclerOptions.Builder<BP>()
                .setQuery(query,BP.class)
                .build();

        adapter = new ListBPAdapter(options);


        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



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
    public void onBackPressed() {
        Intent intent = new Intent(BusinessPlanActivity.this, HomeTrainerActivity.class);
        startActivity(intent);
    }
}