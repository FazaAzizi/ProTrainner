    package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

    public class FormMemberActivity extends AppCompatActivity {

        EditText input_namaLengkap, input_jenisKelamin, input_ttl, input_alamatAsal, input_alamatJogja;
        CheckBox ya1, td1, ya2, td2, ya3, td3, ya4, td4, ya5, td5, ya6, td6, ya7, td7;
        Button button;
        FirebaseAuth mAuth;
        FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        input_namaLengkap = findViewById(R.id.inp_nama_lengkap);
        input_jenisKelamin = findViewById(R.id.inp_jenis_kelamin);
        input_ttl = findViewById(R.id.inp_ttl);
        input_alamatAsal = findViewById(R.id.inp_asal_alamat);
        input_alamatJogja = findViewById(R.id.inp_alamat_jogja);

        button = findViewById(R.id.konfirmasi);

        ya1 = findViewById(R.id.y1);
        td1 = findViewById(R.id.t1);
        ya2 = findViewById(R.id.y2);
        td2 = findViewById(R.id.t2);
        ya3 = findViewById(R.id.y3);
        td3 = findViewById(R.id.t3);
        ya4 = findViewById(R.id.y4);
        td4 = findViewById(R.id.t4);
        ya5 = findViewById(R.id.y5);
        td5 = findViewById(R.id.t5);
        ya6 = findViewById(R.id.y6);
        td6 = findViewById(R.id.t6);
        ya7 = findViewById(R.id.y7);
        td7 = findViewById(R.id.t7);

        checkbutton();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkap = input_namaLengkap.getText().toString();
                String jenisKelamin = input_jenisKelamin.getText().toString();
                String ttl = input_ttl.getText().toString();
                String alamatAsal = input_alamatAsal.getText().toString();
                String alamatJogja = input_alamatJogja.getText().toString();

                if (!(namaLengkap.isEmpty() && jenisKelamin.isEmpty() && ttl.isEmpty() && alamatAsal.isEmpty() && alamatJogja.isEmpty())){
                    FirebaseUser user = mAuth.getCurrentUser();
                    DocumentReference df = fStore.collection("Akun").document(user.getUid())
                            .collection("Data").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("Nama lengkap",namaLengkap);
                    userinfo.put("Jenis kelamin",jenisKelamin);
                    userinfo.put("Ttl",ttl);
                    userinfo.put("Alamat asal",alamatAsal);
                    userinfo.put("Alamat jogja",alamatJogja);

                    if (ya1.isChecked()){
                        userinfo.put("Dada","1");
                    }
                    if (td1.isChecked()){
                        userinfo.put("Dada","0");
                    }
                    if (ya2.isChecked()){
                        userinfo.put("Batuk","1");
                    }
                    if (td2.isChecked()){
                        userinfo.put("Batuk","0");
                    }
                    if (ya3.isChecked()){
                        userinfo.put("Sendi","1");
                    }
                    if (td3.isChecked()){
                        userinfo.put("Sendi","0");
                    }
                    if (ya4.isChecked()){
                        userinfo.put("Cedera","1");
                    }
                    if (td4.isChecked()){
                        userinfo.put("Cedera","0");
                    }
                    if (ya5.isChecked()){
                        userinfo.put("Cacat","1");
                    }
                    if (td5.isChecked()){
                        userinfo.put("Cacat","0");
                    }
                    if (ya6.isChecked()){
                        userinfo.put("Rokok","1");
                    }
                    if (td6.isChecked()){
                        userinfo.put("Rokok","0");
                    }
                    if (ya7.isChecked()){
                        userinfo.put("Tidur","1");
                    }
                    if (td7.isChecked()){
                        userinfo.put("Tidur","0");
                    }
                    
                    df.set(userinfo);
                    Intent inthome =new Intent(FormMemberActivity.this, MainActivity.class);
                    startActivity(inthome);
                }
                
            }
        });


    }

    private void checkbutton(){
        ya1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td1.setChecked(false);
                }
            }
        });

        td1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya1.setChecked(false);
                }
            }
        });
        ya2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td2.setChecked(false);
                }
            }
        });

        td2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya2.setChecked(false);
                }
            }
        });
        ya3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td3.setChecked(false);
                }
            }
        });

        td3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya3.setChecked(false);
                }
            }
        });
        ya4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td4.setChecked(false);
                }
            }
        });

        td4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya4.setChecked(false);
                }
            }
        });
        ya5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td5.setChecked(false);
                }
            }
        });


        td5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya5.setChecked(false);
                }
            }
        });
        ya6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td6.setChecked(false);
                }
            }
        });


        td6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya6.setChecked(false);
                }
            }
        });
        ya7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td7.setChecked(false);
                }
            }
        });

        td7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya7.setChecked(false);
                }
            }
        });

    }
}