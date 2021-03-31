package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditDataTrainerActivity extends AppCompatActivity {

    EditText etNl,etUsia,etTtl,etJk,etPengalaman,etAj;
    Button accperubahan;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_trainer);

        etNl = (EditText)findViewById(R.id.et_ubahdata_trainer_nl);
        etUsia = (EditText)findViewById(R.id.et_ubahdata_trainer_usia);
        etTtl = (EditText)findViewById(R.id.et_ubahdata_trainer_ttl);
        etJk = (EditText)findViewById(R.id.et_ubahdata_trainer_jk);
        etPengalaman = (EditText)findViewById(R.id.et_ubahdata_trainer_pengalaman);
        etAj = (EditText)findViewById(R.id.et_ubahdata_trainer_aj);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId =mAuth.getCurrentUser().getUid();

        DocumentReference df = fStore.collection("Akun").document(userId);

        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("fullname");
                    etNl.setText(nL1);
                }

            }
        });

        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String ttl1 = task.getResult().getString("ttl");
                    String gndr1 = task.getResult().getString("jeniskelamin");
                    String addr1 = task.getResult().getString("alamatjogja");
                    String usia = task.getResult().getString("alamatasal");
                    String pengalaman = task.getResult().getString("alamatasal");

                    etTtl.setText(ttl1);
                    etJk.setText(gndr1);
                    etAj.setText(addr1);
                    etUsia.setText(usia);
                    etPengalaman.setText(pengalaman);
                }
            }
        });

        accperubahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ttl1 = etTtl.getText().toString();
                String gndr1 = etJk.getText().toString();
                String addr1 = etAj.getText().toString();
                String nL1 = etNl.getText().toString();
                String pengalaman = etPengalaman.getText().toString();
                String usia = etUsia.getText().toString();


                if (!(ttl1.isEmpty() && gndr1.isEmpty() && addr1.isEmpty() && usia.isEmpty() && nL1.isEmpty()&&pengalaman.isEmpty())){
                    DocumentReference df = fStore.collection("Akun").document(userId)
                            .collection("Data").document(userId);
                    Map<String,Object> userinfo1 = new HashMap<>();
                    userinfo1.put("namalengkap",nL1);
                    userinfo1.put("jeniskelamin",gndr1);
                    userinfo1.put("ttl",ttl1);
                    userinfo1.put("usia",usia);
                    userinfo1.put("alamatjogja",addr1);
                    userinfo1.put("pengalaman",pengalaman);
                    df.update(userinfo1);

                    DocumentReference df1 = fStore.collection("Akun").document(userId);
                    Map<String,Object> userinfo2 = new HashMap<>();
                    userinfo2.put("fullname",nL1);
                    df1.update(userinfo2);


                    Intent inthome =new Intent(EditDataTrainerActivity.this, MainActivity.class);
                    startActivity(inthome);
                }

            }
        });
    }
}