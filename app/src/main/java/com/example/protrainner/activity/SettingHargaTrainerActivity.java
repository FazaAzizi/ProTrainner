package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.activity.DetailPriceMemberActivity;
import com.example.protrainner.activity.HomeTrainerActivity;
import com.example.protrainner.adapter.ListHargaAdapter;
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

import org.w3c.dom.Document;

import java.util.List;

import io.grpc.InternalNotifyOnServerBuild;

public class SettingHargaTrainerActivity extends AppCompatActivity {

    String uid;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    ImageView ab, ac;
    private RecyclerView recyclerView;
    private ListHargaAdapter adapter;
    FirebaseFirestore getfStore1 = FirebaseFirestore.getInstance();
    private CollectionReference cF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_harga_trainer);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        ab = (ImageView)findViewById(R.id.icon_back_SettingHarga);
        ac = (ImageView)findViewById(R.id.icon_tambah_SettingHarga);
        recyclerView = findViewById(R.id.rv_edit_harga_paket);

        Bundle b = getIntent().getExtras();
        uid = b.getString("UID");

        setUpRecyclerView();

        //back pressed
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //tambah harga paket
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent plus = new Intent(SettingHargaTrainerActivity.this, SettingTambahHargaTrainerActivity.class);
                startActivity(plus);
            }
        });

    }

    private void setUpRecyclerView() {
        cF = getfStore1.collection("Akun").document(uid).collection("Harga");
        Query query = cF.orderBy("NoPaket", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<Harga> options = new FirestoreRecyclerOptions.Builder<Harga>()
                .setQuery(query,Harga.class)
                .build();

        adapter = new ListHargaAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListHargaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                Akun akun = dS.toObject(Akun.class);
                String id = dS.getId();
                String isConnected = akun.getIsConnected();
                Bundle b = new Bundle();
                b.putString("UID",id);

                Intent intent = new Intent(SettingHargaTrainerActivity.this, EditDataHargaActivity.class);
                intent.putExtras(b);
                startActivity(intent);
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
    public void onBackPressed() {
        Intent intent = new Intent(SettingHargaTrainerActivity.this, HomeTrainerActivity.class);
        startActivity(intent);
    }
}