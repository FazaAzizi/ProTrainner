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

public class input_weekly_schedule extends AppCompatActivity {

    EditText etInputNama;
    CheckBox sen7, sel7, rab7, kam7, jum7, sab7, ming7
            ,sen8, sel8, rab8, kam8, jum8, sab8, ming8
            ,sen9, sel9, rab9, kam9, jum9, sab9, ming9
            ,sen10, sel10, rab10, kam10, jum10, sab10, ming10
            ,sen11, sel11, rab11, kam11, jum11, sab11, ming11
            ,sen12, sel12, rab12, kam12, jum12, sab12, ming12
            ,sen13, sel13, rab13, kam13, jum13, sab13, ming13
            ,sen14, sel14, rab14, kam14, jum14, sab14, ming14
            ,sen15, sel15, rab15, kam15, jum15, sab15, ming15
            ,sen16, sel16, rab16, kam16, jum16, sab16, ming16
            ,sen17, sel17, rab17, kam17, jum17, sab17, ming17
            ,sen18, sel18, rab18, kam18, jum18, sab18, ming18
            ,sen19, sel19, rab19, kam19, jum19, sab19, ming19
            ,sen20, sel20, rab20, kam20, jum20, sab20, ming20;
    Button btnKonfirmasi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_weekly_schedule);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        etInputNama = findViewById(R.id.inp_nama_lengkap);

        btnKonfirmasi = findViewById(R.id.KonfirmasiJadwal);

        sen7 = findViewById(R.id.senin7);
        sen8 = findViewById(R.id.senin8);
        sen9 = findViewById(R.id.senin9);
        sen10 = findViewById(R.id.senin10);
        sen11 = findViewById(R.id.senin11);
        sen12 = findViewById(R.id.senin12);
        sen13 = findViewById(R.id.senin13);
        sen14 = findViewById(R.id.senin14);
        sen15 = findViewById(R.id.senin15);
        sen16 = findViewById(R.id.senin16);
        sen17 = findViewById(R.id.senin17);
        sen18 = findViewById(R.id.senin18);
        sen19 = findViewById(R.id.senin19);
        sen20 = findViewById(R.id.senin20);

        sel7 = findViewById(R.id.selasa7);
        sel8 = findViewById(R.id.selasa8);
        sel9 = findViewById(R.id.selasa9);
        sel10 = findViewById(R.id.selasa10);
        sel11 = findViewById(R.id.selasa11);
        sel12 = findViewById(R.id.selasa12);
        sel13 = findViewById(R.id.selasa13);
        sel14 = findViewById(R.id.selasa14);
        sel15 = findViewById(R.id.selasa15);
        sel16 = findViewById(R.id.selasa16);
        sel17 = findViewById(R.id.selasa17);
        sel18 = findViewById(R.id.selasa18);
        sel19 = findViewById(R.id.selasa19);
        sel20 = findViewById(R.id.selasa20);

        rab7 = findViewById(R.id.rabu7);
        rab8 = findViewById(R.id.rabu8);
        rab9 = findViewById(R.id.rabu9);
        rab10 = findViewById(R.id.rabu10);
        rab11 = findViewById(R.id.rabu11);
        rab12 = findViewById(R.id.rabu12);
        rab13 = findViewById(R.id.rabu13);
        rab14 = findViewById(R.id.rabu14);
        rab15 = findViewById(R.id.rabu15);
        rab16 = findViewById(R.id.rabu16);
        rab17 = findViewById(R.id.rabu17);
        rab18 = findViewById(R.id.rabu18);
        rab19 = findViewById(R.id.rabu19);
        rab20 = findViewById(R.id.rabu20);

        kam7 = findViewById(R.id.kamis7);
        kam8 = findViewById(R.id.kamis8);
        kam9 = findViewById(R.id.kamis9);
        kam10 = findViewById(R.id.kamis10);
        kam11 = findViewById(R.id.kamis11);
        kam12 = findViewById(R.id.kamis12);
        kam13 = findViewById(R.id.kamis13);
        kam14 = findViewById(R.id.kamis14);
        kam15 = findViewById(R.id.kamis15);
        kam16 = findViewById(R.id.kamis16);
        kam17 = findViewById(R.id.kamis17);
        kam18 = findViewById(R.id.kamis18);
        kam19 = findViewById(R.id.kamis19);
        kam20 = findViewById(R.id.kamis20);

        jum7 = findViewById(R.id.jumat7);
        jum8 = findViewById(R.id.jumat8);
        jum9 = findViewById(R.id.jumat9);
        jum10 = findViewById(R.id.jumat10);
        jum11 = findViewById(R.id.jumat11);
        jum12 = findViewById(R.id.jumat12);
        jum13 = findViewById(R.id.jumat13);
        jum14 = findViewById(R.id.jumat14);
        jum15 = findViewById(R.id.jumat15);
        jum16 = findViewById(R.id.jumat16);
        jum17 = findViewById(R.id.jumat17);
        jum18 = findViewById(R.id.jumat18);
        jum19 = findViewById(R.id.jumat19);
        jum20 = findViewById(R.id.jumat20);

        sab7 = findViewById(R.id.sabtu7);
        sab8 = findViewById(R.id.sabtu8);
        sab9 = findViewById(R.id.sabtu9);
        sab10 = findViewById(R.id.sabtu10);
        sab11 = findViewById(R.id.sabtu11);
        sab12 = findViewById(R.id.sabtu12);
        sab13 = findViewById(R.id.sabtu13);
        sab14 = findViewById(R.id.sabtu14);
        sab15 = findViewById(R.id.sabtu15);
        sab16 = findViewById(R.id.sabtu16);
        sab17 = findViewById(R.id.sabtu17);
        sab18 = findViewById(R.id.sabtu18);
        sab19 = findViewById(R.id.sabtu19);
        sab20 = findViewById(R.id.sabtu20);

        ming7 = findViewById(R.id.minggu7);
        ming8 = findViewById(R.id.minggu8);
        ming9 = findViewById(R.id.minggu9);
        ming10 = findViewById(R.id.minggu10);
        ming11 = findViewById(R.id.minggu11);
        ming12 = findViewById(R.id.minggu12);
        ming13 = findViewById(R.id.minggu13);
        ming14 = findViewById(R.id.minggu14);
        ming15 = findViewById(R.id.minggu15);
        ming16 = findViewById(R.id.minggu16);
        ming17 = findViewById(R.id.minggu17);
        ming18 = findViewById(R.id.minggu18);
        ming19 = findViewById(R.id.minggu19);
        ming20 = findViewById(R.id.minggu20);

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaJadwal = etInputNama.getText().toString();

                if (!(namaJadwal.isEmpty())){
                    FirebaseUser user = mAuth.getCurrentUser();
                    DocumentReference df = fStore.collection("Akun").document(user.getUid())
                            .collection("Jadwal").document(user.getUid());
                    Map<String,Object> userinfo = new HashMap<>();
                    userinfo.put("namajadwal",namaJadwal);

                    if (sen7.isChecked()){
                        userinfo.put("senin7","1");
                    }
                    if (sen8.isChecked()){
                        userinfo.put("senin8","1");
                    }
                    if (sen9.isChecked()){
                        userinfo.put("senin9","1");
                    }
                    if (sen10.isChecked()){
                        userinfo.put("senin10","1");
                    }
                    if (sen11.isChecked()){
                        userinfo.put("senin11","1");
                    }
                    if (sen12.isChecked()){
                        userinfo.put("senin12","1");
                    }
                    if (sen13.isChecked()){
                        userinfo.put("senin13","1");
                    }
                    if (sen14.isChecked()){
                        userinfo.put("senin14","1");
                    }
                    if (sen15.isChecked()){
                        userinfo.put("senin15","1");
                    }
                    if (sen16.isChecked()){
                        userinfo.put("senin16","1");
                    }
                    if (sen17.isChecked()){
                        userinfo.put("senin17","1");
                    }
                    if (sen18.isChecked()){
                        userinfo.put("senin18","1");
                    }
                    if (sen19.isChecked()){
                        userinfo.put("senin19","1");
                    }
                    if (sen20.isChecked()){
                        userinfo.put("senin20","1");
                    }



                    if (sel7.isChecked()){
                        userinfo.put("selasa7","1");
                    }
                    if (sel8.isChecked()){
                        userinfo.put("selasa8","1");
                    }
                    if (sel9.isChecked()){
                        userinfo.put("selasa9","1");
                    }
                    if (sel10.isChecked()){
                        userinfo.put("selasa10","1");
                    }
                    if (sel11.isChecked()){
                        userinfo.put("selasa11","1");
                    }
                    if (sel12.isChecked()){
                        userinfo.put("selasa12","1");
                    }
                    if (sel13.isChecked()){
                        userinfo.put("selasa13","1");
                    }
                    if (sel14.isChecked()){
                        userinfo.put("selasa14","1");
                    }
                    if (sel15.isChecked()){
                        userinfo.put("selasa15","1");
                    }
                    if (sel16.isChecked()){
                        userinfo.put("selasa16","1");
                    }
                    if (sel17.isChecked()){
                        userinfo.put("selasa17","1");
                    }
                    if (sel18.isChecked()){
                        userinfo.put("selasa18","1");
                    }
                    if (sel19.isChecked()){
                        userinfo.put("selasa19","1");
                    }
                    if (sel20.isChecked()){
                        userinfo.put("selasa20","1");
                    }



                    if (rab7.isChecked()){
                        userinfo.put("rabu7","1");
                    }
                    if (rab8.isChecked()){
                        userinfo.put("rabu8","1");
                    }
                    if (rab9.isChecked()){
                        userinfo.put("rabu9","1");
                    }
                    if (rab10.isChecked()){
                        userinfo.put("rabu10","1");
                    }
                    if (rab11.isChecked()){
                        userinfo.put("rabu11","1");
                    }
                    if (rab12.isChecked()){
                        userinfo.put("rabu12","1");
                    }
                    if (rab13.isChecked()){
                        userinfo.put("rabu13","1");
                    }
                    if (rab14.isChecked()){
                        userinfo.put("rabu14","1");
                    }
                    if (rab15.isChecked()){
                        userinfo.put("rabu15","1");
                    }
                    if (rab16.isChecked()){
                        userinfo.put("rabu16","1");
                    }
                    if (rab17.isChecked()){
                        userinfo.put("rabu17","1");
                    }
                    if (rab18.isChecked()){
                        userinfo.put("rabu18","1");
                    }
                    if (rab19.isChecked()){
                        userinfo.put("rabu19","1");
                    }
                    if (rab20.isChecked()){
                        userinfo.put("rabu20","1");
                    }



                    if (kam7.isChecked()){
                        userinfo.put("kamis7","1");
                    }
                    if (kam8.isChecked()){
                        userinfo.put("kamis8","1");
                    }
                    if (kam9.isChecked()){
                        userinfo.put("kamis9","1");
                    }
                    if (kam10.isChecked()){
                        userinfo.put("kamis10","1");
                    }
                    if (kam11.isChecked()){
                        userinfo.put("kamis11","1");
                    }
                    if (kam12.isChecked()){
                        userinfo.put("kamis12","1");
                    }
                    if (kam13.isChecked()){
                        userinfo.put("kamis13","1");
                    }
                    if (kam14.isChecked()){
                        userinfo.put("kamis14","1");
                    }
                    if (kam15.isChecked()){
                        userinfo.put("kamis15","1");
                    }
                    if (kam16.isChecked()){
                        userinfo.put("kamis16","1");
                    }
                    if (kam17.isChecked()){
                        userinfo.put("kamis17","1");
                    }
                    if (kam18.isChecked()){
                        userinfo.put("kamis18","1");
                    }
                    if (kam19.isChecked()){
                        userinfo.put("kamis19","1");
                    }
                    if (kam20.isChecked()){
                        userinfo.put("kamis20 ","1");
                    }



                    if (jum7.isChecked()){
                        userinfo.put("jumat7","1");
                    }
                    if (jum8.isChecked()){
                        userinfo.put("jumat8","1");
                    }
                    if (jum9.isChecked()){
                        userinfo.put("jumat9","1");
                    }
                    if (jum10.isChecked()){
                        userinfo.put("jumat10","1");
                    }
                    if (jum11.isChecked()){
                        userinfo.put("jumat11","1");
                    }
                    if (jum12.isChecked()){
                        userinfo.put("jumat12","1");
                    }
                    if (jum13.isChecked()){
                        userinfo.put("jumat13","1");
                    }
                    if (jum14.isChecked()){
                        userinfo.put("jumat14","1");
                    }
                    if (jum15.isChecked()){
                        userinfo.put("jumat15","1");
                    }
                    if (jum16.isChecked()){
                        userinfo.put("jumat16","1");
                    }
                    if (jum17.isChecked()){
                        userinfo.put("jumat17","1");
                    }
                    if (jum18.isChecked()){
                        userinfo.put("jumat18","1");
                    }
                    if (jum19.isChecked()){
                        userinfo.put("jumat19","1");
                    }
                    if (jum20.isChecked()){
                        userinfo.put("jumat20","1");
                    }



                    if (sab7.isChecked()){
                        userinfo.put("sabtu7","1");
                    }
                    if (sab8.isChecked()){
                        userinfo.put("sabtu8","1");
                    }
                    if (sab9.isChecked()){
                        userinfo.put("sabtu9","1");
                    }
                    if (sab10.isChecked()){
                        userinfo.put("sabtu10","1");
                    }
                    if (sab11.isChecked()){
                        userinfo.put("sabtu11","1");
                    }
                    if (sab12.isChecked()){
                        userinfo.put("sabtu12","1");
                    }
                    if (sab13.isChecked()){
                        userinfo.put("sabtu13","1");
                    }
                    if (sab14.isChecked()){
                        userinfo.put("sabtu14","1");
                    }
                    if (sab15.isChecked()){
                        userinfo.put("sabtu15","1");
                    }
                    if (sab16.isChecked()){
                        userinfo.put("sabtu16","1");
                    }
                    if (sab17.isChecked()){
                        userinfo.put("sabtu17","1");
                    }
                    if (sab18.isChecked()){
                        userinfo.put("sabtu18","1");
                    }
                    if (sab19.isChecked()){
                        userinfo.put("sabtu19","1");
                    }
                    if (sab20.isChecked()){
                        userinfo.put("sabtu20","1");
                    }



                    if (ming7.isChecked()){
                        userinfo.put("minggu7","1");
                    }
                    if (ming8.isChecked()){
                        userinfo.put("minggu8","1");
                    }
                    if (ming9.isChecked()){
                        userinfo.put("minggu9","1");
                    }
                    if (ming10.isChecked()){
                        userinfo.put("minggu10","1");
                    }
                    if (ming11.isChecked()){
                        userinfo.put("minggu1","11");
                    }
                    if (ming12.isChecked()){
                        userinfo.put("minggu12","1");
                    }
                    if (ming13.isChecked()){
                        userinfo.put("minggu13","1");
                    }
                    if (ming14.isChecked()){
                        userinfo.put("minggu14","1");
                    }
                    if (ming15.isChecked()){
                        userinfo.put("minggu15","1");
                    }
                    if (ming16.isChecked()){
                        userinfo.put("minggu16","1");
                    }
                    if (ming17.isChecked()){
                        userinfo.put("minggu17","1");
                    }
                    if (ming18.isChecked()){
                        userinfo.put("minggu18","1");
                    }
                    if (ming19.isChecked()){
                        userinfo.put("minggu19","1");
                    }
                    if (ming20.isChecked()){
                        userinfo.put("minggu20","1");
                    }

                    df.set(userinfo);
                    Intent intInfoJadwal = new Intent(input_weekly_schedule.this, weekly_schedule_trainer.class);
                    startActivity(intInfoJadwal);


                }
            }
        });



    }
}