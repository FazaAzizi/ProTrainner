package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListHargaAdapter;
import com.example.protrainner.adapter.ListTrainerPriceAdapter;
import com.example.protrainner.model.Akun;
import com.example.protrainner.model.Harga;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class DetailPriceMemberActivity extends AppCompatActivity {

    String uid;
    TextView nL,tTL,gndr,addrsJgj,addrsAsal;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    ImageView ab;
    private RecyclerView recyclerView;
    private ListHargaAdapter adapter;
    FirebaseFirestore fStore1 = FirebaseFirestore.getInstance();
    private CollectionReference cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_price_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        nL = findViewById(R.id.textView2);
        tTL = findViewById(R.id.textView3);
        gndr = findViewById(R.id.textView5);
        addrsJgj = findViewById(R.id.textView4);
        ab = (ImageView)findViewById(R.id.ab_detailpricemember);
        recyclerView = findViewById(R.id.rv_harga_paket);


        Bundle b = getIntent().getExtras();
        uid = b.getString("UID");

        DocumentReference df = fStore.collection("Akun").document(uid);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("namalengkap");
                    String tTl1 = task.getResult().getString("ttl");
                    String  gndr1 = task.getResult().getString("jeniskelamin");
                    String addrsJgj1 = task.getResult().getString("usia");

                    nL.setText(nL1);
                    tTL.setText(tTl1);
                    gndr.setText(gndr1);
                    addrsJgj.setText(addrsJgj1);
                }

            }
        });

        setUpRecyclerView();

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setUpRecyclerView() {
        cF = fStore1.collection("Akun").document(uid).collection("Harga");
        Query query = cF.orderBy("noPaket", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Harga> options = new FirestoreRecyclerOptions.Builder<Harga>()
                .setQuery(query,Harga.class)
                .build();

        adapter = new ListHargaAdapter(options);

        recyclerView.setHasFixedSize(true);
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
        Intent intent = new Intent(DetailPriceMemberActivity.this, PriceListMemberActivity.class);
        startActivity(intent);
    }
}