package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.example.protrainner.model.Harga;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class SettingTambahHargaTrainerActivity extends AppCompatActivity {

    String tambah_hargaNoPaket, tambah_hargaDurasiLat, tambah_hargaHarga;
    EditText input_tambahNoPaket, input_tambahDurasiLat, input_tambahHarga;
    TextView tvOutPaket1;
    Button btnSelesaiTambah, btnTambahTambah, btnCekTambah;
    ImageView ab;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_tambah_harga_trainer);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        tvOutPaket1 = findViewById(R.id.form_harga_out_no1);

        input_tambahNoPaket = findViewById(R.id.inp_no_paket1);
        input_tambahDurasiLat = findViewById(R.id.inp_durasi_trainer1);
        input_tambahHarga = findViewById(R.id.inp_harga_trainer1);

        ab = (ImageView) findViewById(R.id.icon_back_SettingTambahHarga);

        btnTambahTambah = findViewById(R.id.tambah_paketTambah);
        btnCekTambah = findViewById(R.id.cek_paketTambah);


        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



        FirebaseUser user = mAuth.getCurrentUser();

        btnTambahTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tambah_hargaNoPaket = input_tambahNoPaket.getText().toString();
                tambah_hargaDurasiLat = input_tambahHarga.getText().toString();
                tambah_hargaHarga = input_tambahHarga.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(user.getUid()).
                        collection("Harga").document(tambah_hargaHarga);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noPaket", tambah_hargaNoPaket);
                userinfo.put("durasiLatihan", tambah_hargaDurasiLat);
                userinfo.put("harga", tambah_hargaHarga);
                df.set(userinfo);

                input_tambahNoPaket.setText("");
                input_tambahDurasiLat.setText("");
                input_tambahHarga.setText("");
            }
        });

        btnCekTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadHarga (v);
            }
        });

    }

    private void loadHarga(View v) {
        FirebaseUser user = mAuth.getCurrentUser();
        CollectionReference cr = fStore.collection("Akun").document(user.getUid()).collection("Harga");
        cr.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            String data = "";
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots){
                    Harga harga = documentSnapshot.toObject(Harga.class);

                    String noPaket = harga.getNoPaket();
                    String durasiLatihan = harga.getDurasiLatihan();
                    String hargaPkt = harga.getHarga();

                    data+= "No. Paket\t: " +noPaket+ "\nDurasi\t: " +durasiLatihan+ "\nHarga Paket\t: "  +hargaPkt+ "\n\n";

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SettingTambahHargaTrainerActivity.this, SettingHargaTrainerActivity.class);
        startActivity(intent);
    }


}