package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FormTrainerActivity extends AppCompatActivity {

    EditText input_namaLengkap_trainer, input_jenisKelamin_trainer, input_ttl_trainer, input_alamatAsal_trainer, input_alamatJogja_trainer;
    Button button;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_trainer);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        input_namaLengkap_trainer = findViewById(R.id.inp_nama_lengkap_trainer);
        input_jenisKelamin_trainer = findViewById(R.id.inp_jenis_kelamin_trainer);
        input_ttl_trainer = findViewById(R.id.inp_ttl_trainer);
        input_alamatAsal_trainer = findViewById(R.id.inp_asal_alamat_trainer);
        input_alamatJogja_trainer = findViewById(R.id.inp_alamat_jogja_trainer);

        button = findViewById(R.id.konfirmasi_trainer);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkap = input_namaLengkap_trainer.getText().toString();
                String jenisKelamin = input_jenisKelamin_trainer.getText().toString();
                String ttl = input_ttl_trainer.getText().toString();
                String alamatAsal = input_alamatAsal_trainer.getText().toString();
                String alamatJogja = input_alamatJogja_trainer.getText().toString();

                if (!(namaLengkap.isEmpty() && jenisKelamin.isEmpty() && ttl.isEmpty() && alamatAsal.isEmpty() && alamatJogja.isEmpty())){
                    FirebaseUser user = mAuth.getCurrentUser();
                    DocumentReference df = fStore.collection("Akun").document(user.getUid())
                            .collection("Data").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("namalengkap",namaLengkap);
                    userinfo.put("jeniskelamin",jenisKelamin);
                    userinfo.put("ttl",ttl);
                    userinfo.put("alamatasal",alamatAsal);
                    userinfo.put("alamatjogja",alamatJogja);

                    df.set(userinfo);
                    Intent inthome =new Intent(FormTrainerActivity.this, HomeTrainerActivity.class);
                    startActivity(inthome);
                }

            }
        });
    }
}