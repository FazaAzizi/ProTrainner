package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListDataTrainerAdapter;
import com.example.protrainner.adapter.ListTrainerPriceAdapter;
import com.example.protrainner.model.Akun;
import com.example.protrainner.model.Data;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PriceListMemberActivity extends AppCompatActivity implements ListTrainerPriceAdapter.OnItemClickListener {


    private RecyclerView recyclerView;
    private ListDataTrainerAdapter adapter;
    FirebaseAuth mAuth;
    ImageView ab;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cF = fStore.collection("Akun");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list_member);


        recyclerView = findViewById(R.id.list_trainer);
        setUpRecyclerView();
        ab = (ImageView) findViewById(R.id.ab_pricelistmember);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


//        //Query
//        Query query = fStore.collection("Akun");
//        //Recycle
//        FirestoreRecyclerOptions<ListTrainer> options = new FirestoreRecyclerOptions.Builder<>().setQuery(query,ListTrainer.class).build();
//
//        //View

    }

    private void setUpRecyclerView() {
        Query query = cF.whereEqualTo("isMember", "0");
        FirestoreRecyclerOptions<Data> options = new FirestoreRecyclerOptions.Builder<Data>()
                .setQuery(query, Data.class)
                .build();

        adapter = new ListDataTrainerAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListDataTrainerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                Akun akun = dS.toObject(Akun.class);
                String id = dS.getId();

                Bundle b = new Bundle();
                b.putString("UID", id);
                Intent intent = new Intent(PriceListMemberActivity.this, DetailPriceMemberActivity.class);
                intent.putExtras(b);
                startActivity(intent);

                //Toast.makeText(PriceListMemberActivity.this, "id = " + id,Toast.LENGTH_SHORT).show();
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
        Intent intent = new Intent(PriceListMemberActivity.this, MainActivity.class);
        startActivity(intent);
    }
}