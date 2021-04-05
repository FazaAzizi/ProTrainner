    package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

    public class FormMemberActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        EditText input_namaLengkap, input_jenisKelamin, input_ttl, input_alamatAsal, input_alamatJogja;
        CheckBox ya1, td1, ya2, td2, ya3, td3, ya4, td4, ya5, td5, ya6, td6, ya7, td7;
        Button button;
        Spinner spinner;
        String jenisKelamin;
        FirebaseAuth mAuth;
        FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        input_namaLengkap = findViewById(R.id.inp_nama_lengkap);
        //input_jenisKelamin = findViewById(R.id.inp_jenis_kelamin);
        input_ttl = findViewById(R.id.inp_ttl);
        input_alamatAsal = findViewById(R.id.inp_asal_alamat);
        input_alamatJogja = findViewById(R.id.inp_alamat_jogja);
        spinner =findViewById(R.id.spin_gender_formmember);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kelamin, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

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
                //String jenisKelamin = input_jenisKelamin.getText().toString();
                String ttl = input_ttl.getText().toString();
                String alamatAsal = input_alamatAsal.getText().toString();
                String alamatJogja = input_alamatJogja.getText().toString();

                if (!(namaLengkap.isEmpty() && jenisKelamin.isEmpty() && ttl.isEmpty() && alamatAsal.isEmpty() && alamatJogja.isEmpty())){
                    FirebaseUser user = mAuth.getCurrentUser();
                    DocumentReference df = fStore.collection("Akun").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("namalengkap",namaLengkap);
                    userinfo.put("jeniskelamin",jenisKelamin);
                    userinfo.put("ttl",ttl);
                    userinfo.put("alamatasal",alamatAsal);
                    userinfo.put("alamatjogja",alamatJogja);
                    df.update(userinfo);

                    DocumentReference df1 = fStore.collection("Akun").document(user.getUid())
                            .collection("Data").document(user.getUid());
                    Map<String,Object> userinfo1 = new HashMap<>();
                    if (ya1.isChecked()){
                        userinfo1.put("dada","1");
                    }
                    if (td1.isChecked()){
                        userinfo1.put("dada","0");
                    }
                    if (ya2.isChecked()){
                        userinfo1.put("batuk","1");
                    }
                    if (td2.isChecked()){
                        userinfo1.put("batuk","0");
                    }
                    if (ya3.isChecked()){
                        userinfo1.put("sendi","1");
                    }
                    if (td3.isChecked()){
                        userinfo1.put("sendi","0");
                    }
                    if (ya4.isChecked()){
                        userinfo1.put("cedera","1");
                    }
                    if (td4.isChecked()){
                        userinfo1.put("cedera","0");
                    }
                    if (ya5.isChecked()){
                        userinfo1.put("cacat","1");
                    }
                    if (td5.isChecked()){
                        userinfo1.put("cacat","0");
                    }
                    if (ya6.isChecked()){
                        userinfo1.put("rokok","1");
                    }
                    if (td6.isChecked()){
                        userinfo1.put("rokok","0");
                    }
                    if (ya7.isChecked()){
                        userinfo1.put("tidur","1");
                    }
                    if (td7.isChecked()){
                        userinfo1.put("tidur","0");
                    }
                    df1.set(userinfo1);
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

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            jenisKelamin = parent.getItemAtPosition(position).toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }