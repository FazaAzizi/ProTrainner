package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailPriceMemberActivity extends AppCompatActivity {

    String uid;
    TextView nL,tTL,gndr,addrsJgj,addrsAsal;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_price_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        nL = findViewById(R.id.textView2);
        tTL = findViewById(R.id.textView3);
        gndr = findViewById(R.id.textView4);
        addrsJgj = findViewById(R.id.textView5);
        addrsAsal = findViewById(R.id.textView6);

        Bundle b = getIntent().getExtras();
        uid = b.getString("UID");

        DocumentReference df = fStore.collection("Akun").document(uid).collection("Data").document(uid);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("namalengkap");
                    String tTl1 = task.getResult().getString("ttl");
                    String  gndr1 = task.getResult().getString("jeniskelamin");
                    String addrsJgj1 = task.getResult().getString("alamatasal");
                    String addrsAsal1 = task.getResult().getString("alamatjogja");

                    nL.setText(nL1);
                    tTL.setText(tTl1);
                    gndr.setText(gndr1);
                    addrsJgj.setText(addrsJgj1);
                    addrsAsal.setText(addrsAsal1);

                }

            }
        });
    }
}