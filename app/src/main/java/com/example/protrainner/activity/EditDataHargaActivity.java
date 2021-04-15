package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.sql.BatchUpdateException;
import java.util.HashMap;
import java.util.Map;

public class EditDataHargaActivity extends AppCompatActivity {

    EditText etNopak, etDurlat, etHarpak;
    ImageView ab;
    Button accHargaBaru;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId, hargaa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_harga);

        etNopak = (EditText)findViewById(R.id.et_ubahHargaPaket_nopak);
        etDurlat = (EditText)findViewById(R.id.et_ubahHargaPaket_durlat);
        etHarpak = (EditText)findViewById(R.id.et_ubahHargaPaket_harpak);

        accHargaBaru = (Button)findViewById(R.id.btn_perubahan_dataHarga);
        ab = (ImageView)findViewById(R.id.ab_editdataharga);

        Bundle b = getIntent().getExtras();
        hargaa = b.getString("harga");

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId = mAuth.getCurrentUser().getUid();
        DocumentReference df = fStore.collection("Akun").document(userId).
                collection("Harga").document(hargaa);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String nopak = task.getResult().getString("noPaket");
                    String durlat = task.getResult().getString("durasiLatihan");
                    String harpak = task.getResult().getString("harga");

                    etNopak.setText(nopak);
                    etDurlat.setText(durlat);
                    etHarpak.setText(harpak);
                }

            }
        });

        accHargaBaru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nopak = etNopak.getText().toString();
                String durlat = etDurlat.getText().toString();
                String harpak = etHarpak.getText().toString();

                if(!(nopak.isEmpty() && durlat.isEmpty() && harpak.isEmpty())){
                    DocumentReference df = fStore.collection("Akun").document(userId).
                            collection("Harga").document(hargaa);
                    Map<String,Object> priceinfo1 = new HashMap<>();
                    priceinfo1.put("noPaket",nopak);
                    priceinfo1.put("durasiLatihan",durlat);
                    priceinfo1.put("harga",harpak);
                    df.update(priceinfo1);
                    Intent intback = new Intent(EditDataHargaActivity.this, SettingHargaTrainerActivity.class);

                }
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(EditDataHargaActivity.this, SettingHargaTrainerActivity.class);
        startActivity(intent);
    }
}