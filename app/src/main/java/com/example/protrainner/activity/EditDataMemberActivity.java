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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditDataMemberActivity extends AppCompatActivity {

    EditText etNl,etTtl,etJk,etAa,etAj;
    Button accperubahan;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_member);

        etNl = (EditText)findViewById(R.id.et_ubahdata_member_nl);
        etTtl = (EditText)findViewById(R.id.et_ubahdata_member_ttl);
        etJk = (EditText)findViewById(R.id.et_ubahdata_member_jk);
        etAa = (EditText)findViewById(R.id.et_ubahdata_member_aa);
        etAj = (EditText)findViewById(R.id.et_ubahdata_member_aj);
        accperubahan = (Button)findViewById(R.id.btn_perubahan_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId =mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nL1 = task.getResult().getString("fullname");
                    String ttl1 = task.getResult().getString("ttl");
                    String gndr1 = task.getResult().getString("jeniskelamin");
                    String addr1 = task.getResult().getString("alamatjogja");
                    String addr2 = task.getResult().getString("alamatasal");
                    etTtl.setText(ttl1);
                    etJk.setText(gndr1);
                    etAj.setText(addr1);
                    etAa.setText(addr2);
                    etNl.setText(nL1);
                }

            }
        });


        accperubahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ttl1 = etTtl.getText().toString();
                String gndr1 = etJk.getText().toString();
                String addr1 = etAj.getText().toString();
                String addr2 = etAa.getText().toString();
                String nL1 = etNl.getText().toString();


                if (!(ttl1.isEmpty() && gndr1.isEmpty() && addr1.isEmpty() && addr2.isEmpty() && nL1.isEmpty())){
                    DocumentReference df = fStore.collection("Akun").document(userId);
                    Map<String,Object> userinfo1 = new HashMap<>();
                    userinfo1.put("namalengkap",nL1);
                    userinfo1.put("jeniskelamin",gndr1);
                    userinfo1.put("ttl",ttl1);
                    userinfo1.put("alamatasal",addr2);
                    userinfo1.put("alamatjogja",addr1);
                    userinfo1.put("fullname",nL1);
                    df.update(userinfo1);
                    Intent inthome =new Intent(EditDataMemberActivity.this, MainActivity.class);
                    startActivity(inthome);
                }

            }
        });
    }
}