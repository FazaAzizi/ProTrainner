package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListTrainerPriceAdapter;
import com.example.protrainner.model.Akun;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class PriceListMemberActivity extends AppCompatActivity implements  ListTrainerPriceAdapter.OnItemClickListener{


    private RecyclerView recyclerView;
    private ListTrainerPriceAdapter adapter;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cF = fStore.collection("Akun");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_list_member);


        recyclerView = findViewById(R.id.list_trainer);
        setUpRecyclerView();


//        //Query
//        Query query = fStore.collection("Akun");
//        //Recycle
//        FirestoreRecyclerOptions<ListTrainer> options = new FirestoreRecyclerOptions.Builder<>().setQuery(query,ListTrainer.class).build();
//
//        //View

    }

    private void setUpRecyclerView() {
        Query query = cF.whereEqualTo("isMember","0");
        FirestoreRecyclerOptions<Akun> options = new FirestoreRecyclerOptions.Builder<Akun>()
                .setQuery(query,Akun.class)
                .build();

        adapter = new ListTrainerPriceAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListTrainerPriceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                Akun akun = dS.toObject(Akun.class);
                String id = dS.getId();

                Bundle b = new Bundle();
                b.putString("UID",id);
                Intent intent = new Intent(PriceListMemberActivity.this, DetailPriceMemberActivity.class);
                intent.putExtras(b);
                startActivity(intent);

                Toast.makeText(PriceListMemberActivity.this, "id = " + id,Toast.LENGTH_SHORT).show();
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
}