package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListMemberAdapter;
import com.example.protrainner.adapter.ListTrainerAdapter;
import com.example.protrainner.model.Akun;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class  MemberListActivity extends AppCompatActivity implements  ListTrainerAdapter.OnItemClickListener {

    private RecyclerView recyclerView;
    private ListMemberAdapter adapter;
    ImageView ab;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    private CollectionReference cF = fStore.collection("Akun");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);

        recyclerView = findViewById(R.id.list_member);
        setUpRecyclerView();
        ab =findViewById(R.id.ab_memberlist3);
        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void setUpRecyclerView() {
        Query query = cF.whereEqualTo("isMember","1");
        FirestoreRecyclerOptions<Akun> options = new FirestoreRecyclerOptions.Builder<Akun>()
                .setQuery(query,Akun.class)
                .build();

        adapter = new ListMemberAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ListMemberAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot dS, int position) {
                Akun akun = dS.toObject(Akun.class);
                String id = dS.getId();
                String isConnected = akun.getIsConnected();
                Bundle b = new Bundle();
                b.putString("UID",id);

                if (isConnected.equals("0")) {
                    Intent intent = new Intent(MemberListActivity.this, DetailMemberListActivity.class);
                    intent.putExtras(b);
                    startActivity(intent);
                }

                if (isConnected.equals("1")) {
                    Intent intent2 = new Intent(MemberListActivity.this, DetailMemberList_Connected.class);
                    intent2.putExtras(b);
                    startActivity(intent2);
                }


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
        Intent intent = new Intent(MemberListActivity.this, HomeTrainerActivity.class);
        startActivity(intent);
    }
}