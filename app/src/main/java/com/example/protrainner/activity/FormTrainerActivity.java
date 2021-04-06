package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
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

import java.util.HashMap;
import java.util.Map;

public class FormTrainerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String id, harga, hargaNoPaket, hargaDurasiLat, hargaHarga ;
    EditText input_namaLengkap_trainer, input_jenisKelamin_trainer, input_ttl_trainer, input_usia__trainer, input_alamatJogja_trainer, input_pengalaman_trainer
            ,input_nomor_paket, input_durasi_latihan, input_harga_pt;
    TextView tvOutPaket;
    Spinner spinner;
    String jenisKelamin;
    Button btnSelesai, btnTambah_paket, btnCek_paket;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_trainer);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();



        input_namaLengkap_trainer = findViewById(R.id.inp_nama_lengkap_trainer);
        //input_jenisKelamin_trainer = findViewById(R.id.inp_jenis_kelamin_trainer);
        input_ttl_trainer = findViewById(R.id.inp_ttl_trainer);
        input_usia__trainer = findViewById(R.id.inp_usia_trainer);
        input_alamatJogja_trainer = findViewById(R.id.inp_alamat_jogja_trainer);
        input_pengalaman_trainer = findViewById(R.id.inp_pengalaman_trainer);

        tvOutPaket = findViewById(R.id.form_harga_out_no);

        spinner =findViewById(R.id.spin_gender_formtrainer);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.kelamin, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        input_nomor_paket = findViewById(R.id.inp_no_paket);
        input_durasi_latihan = findViewById(R.id.inp_durasi_trainer);
        input_harga_pt = findViewById(R.id.inp_harga_trainer);

        btnTambah_paket = findViewById(R.id.tambah_paket);
        btnCek_paket = findViewById(R.id.cek_paket);
        btnSelesai = findViewById(R.id.konfirmasi_trainer);

        FirebaseUser user = mAuth.getCurrentUser();

        btnTambah_paket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hargaNoPaket = input_nomor_paket.getText().toString();
                hargaDurasiLat = input_durasi_latihan.getText().toString();
                hargaHarga = input_harga_pt.getText().toString();

                DocumentReference df = fStore.collection("Akun").document(user.getUid()).
                        collection("Harga").document(hargaHarga);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("noPaket", hargaNoPaket);
                userinfo.put("durasiLatihan", hargaDurasiLat);
                userinfo.put("harga", hargaHarga);
                df.set(userinfo);

                input_nomor_paket.setText("");
                input_durasi_latihan.setText("");
                input_harga_pt.setText("");
            }
        });

        btnCek_paket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { loadHarga (v); }
        });

        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaLengkap = input_namaLengkap_trainer.getText().toString();
                //String jenisKelamin = input_jenisKelamin_trainer.getText().toString();
                String ttl = input_ttl_trainer.getText().toString();
                String usia = input_usia__trainer.getText().toString();
                String alamatJogja = input_alamatJogja_trainer.getText().toString();
                String pengalaman = input_pengalaman_trainer.getText().toString();

                if (!(namaLengkap.isEmpty() && jenisKelamin.isEmpty() && ttl.isEmpty() && usia.isEmpty() && alamatJogja.isEmpty() && pengalaman.isEmpty())){
                    FirebaseUser user = mAuth.getCurrentUser();
                    DocumentReference df = fStore.collection("Akun").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("namalengkap",namaLengkap);
                    userinfo.put("jeniskelamin",jenisKelamin);
                    userinfo.put("ttl",ttl);
                    userinfo.put("usia",usia);
                    userinfo.put("alamatjogja",alamatJogja);
                    userinfo.put("pengalaman",pengalaman);
                    df.update(userinfo);
                    Intent inthome =new Intent(FormTrainerActivity.this, HomeTrainerActivity.class);
                    startActivity(inthome);
                }

            }
        });
    }

    public void loadHarga(View v) {
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
                tvOutPaket.setText(data);
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