package com.example.protrainner.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.adapter.ListHargaAdapter;
import com.example.protrainner.model.Harga;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class profileTrainerFragment extends Fragment {

    TextView namal,ttl,mail,gender,addrs,exp,price;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    private RecyclerView recyclerView;
    private ListHargaAdapter adapter;
    FirebaseFirestore fStore1 = FirebaseFirestore.getInstance();
    private CollectionReference cF;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_trainer, container, false);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        namal = (TextView) view.findViewById(R.id.out_nama);
        ttl = (TextView) view.findViewById(R.id.out_ttl);
        mail = (TextView) view.findViewById(R.id.out_mail);
        gender = (TextView) view.findViewById(R.id.out_gender);
        addrs = (TextView) view.findViewById(R.id.out_address);
        exp = (TextView) view.findViewById(R.id.out_experience);

        recyclerView = (RecyclerView)view.findViewById(R.id.rv_paket_profile) ;
        userId = mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String namal1 = task.getResult().getString("fullname");
                    String mail1 = task.getResult().getString("email");
                    String ttl1 = task.getResult().getString("ttl");
                    String gender1 = task.getResult().getString("jeniskelamin");
                    String addrs1 = task.getResult().getString("alamatjogja");
                    String exp1 = task.getResult().getString("pengalaman");
                    ttl.setText(ttl1);
                    gender.setText(gender1);
                    addrs.setText(addrs1);
                    exp.setText(exp1);
                    namal.setText(namal1);
                    mail.setText(mail1);
                }
            }
        });

        setUpRecyclerView();
        return view;
    }

    private void setUpRecyclerView() {
        cF = fStore1.collection("Akun").document(userId).collection("Harga");
        Query query = cF;
        FirestoreRecyclerOptions<Harga> options = new FirestoreRecyclerOptions.Builder<Harga>()
                .setQuery(query,Harga.class)
                .build();

        adapter = new ListHargaAdapter(options);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
