package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.CompoundButtonCompat;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

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

public class input_weekly_schedule extends AppCompatActivity {

    EditText etInputNama;
    String nm;
    ImageView ab;
    String Ssen7, Ssel7, Srab7, Skam7, Sjum7, Ssab7, Sming7,
           Ssen8, Ssel8, Srab8, Skam8, Sjum8, Ssab8, Sming8,
            Ssen9, Ssel9, Srab9, Skam9, Sjum9, Ssab9, Sming9,
            Ssen10, Ssel10, Srab10, Skam10, Sjum10, Ssab10, Sming10,
            Ssen11, Ssel11, Srab11, Skam11, Sjum11, Ssab11, Sming11,
            Ssen12, Ssel12, Srab12, Skam12, Sjum12, Ssab12, Sming12,
            Ssen13, Ssel13, Srab13, Skam13, Sjum13, Ssab13, Sming13,
            Ssen14, Ssel14, Srab14, Skam14, Sjum14, Ssab14, Sming14,
            Ssen15, Ssel15, Srab15, Skam15, Sjum15, Ssab15, Sming15,
            Ssen16, Ssel16, Srab16, Skam16, Sjum16, Ssab16, Sming16,
            Ssen17, Ssel17, Srab17, Skam17, Sjum17, Ssab17, Sming17,
            Ssen18, Ssel18, Srab18, Skam18, Sjum18, Ssab18, Sming18,
            Ssen19, Ssel19, Srab19, Skam19, Sjum19, Ssab19, Sming19,
            Ssen20, Ssel20, Srab20, Skam20, Sjum20, Ssab20, Sming20;

    CheckBox sen7, sel7, rab7, kam7, jum7, sab7, ming7,
            sen8, sel8, rab8, kam8, jum8, sab8, ming8,
            sen9, sel9, rab9, kam9, jum9, sab9, ming9,
            sen10, sel10, rab10, kam10, jum10, sab10, ming10,
            sen11, sel11, rab11, kam11, jum11, sab11, ming11,
            sen12, sel12, rab12, kam12, jum12, sab12, ming12,
            sen13, sel13, rab13, kam13, jum13, sab13, ming13,
            sen14, sel14, rab14, kam14, jum14, sab14, ming14,
            sen15, sel15, rab15, kam15, jum15, sab15, ming15,
            sen16, sel16, rab16, kam16, jum16, sab16, ming16,
            sen17, sel17, rab17, kam17, jum17, sab17, ming17,
            sen18, sel18, rab18, kam18, jum18, sab18, ming18,
            sen19, sel19, rab19, kam19, jum19, sab19, ming19,
            sen20, sel20, rab20, kam20, jum20, sab20, ming20;
    Button btnKonfirmasi;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore, fStore2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_weekly_schedule);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        fStore2 = FirebaseFirestore.getInstance();

        etInputNama = findViewById(R.id.inp_nama_lengkap);

        btnKonfirmasi = findViewById(R.id.KonfirmasiJadwal);
        Bundle b = getIntent().getExtras();
        nm = b.getString("nama");
        ab = (ImageView) findViewById(R.id.ab_inputws);

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

        cekIsi();

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = mAuth.getCurrentUser();
                DocumentReference df = fStore.collection("Jadwal").document("senin");
                Map<String, Object> userinfo = new HashMap<>();

                if (!sen7.isChecked()) {
                    if (Ssen7.equals("1")) {
                        userinfo.put("senin7", "");
                    }
                }
                if (sen7.isChecked()) {
                    userinfo.put("senin7", nm);
                }



                if (!sen8.isChecked()) {
                    if (Ssen8.equals("1")) {
                        userinfo.put("senin8", "");
                    }
                }
                if (sen8.isChecked()) {
                    userinfo.put("senin8", nm);
                }



                if (!sen9.isChecked()) {
                    if (Ssen9.equals("1")) {
                        userinfo.put("senin9", "");
                    }
                }
                if (sen9.isChecked()) {
                    userinfo.put("senin9", nm);
                }



                if (!sen10.isChecked()) {
                    if (Ssen10.equals("1")) {
                        userinfo.put("senin10", "");
                    }
                }
                if (sen10.isChecked()) {
                    userinfo.put("senin10", nm);
                }


                if (!sen11.isChecked()){
                    if (Ssen11.equals("1")) {
                        userinfo.put("senin11", "");
                    }
                }
                if (sen11.isChecked()) {
                    userinfo.put("senin11", nm);
                }

                if (!sen12.isChecked()){
                    if (Ssen12.equals("1")) {
                        userinfo.put("senin12", "");
                    }
                }
                if (sen12.isChecked()) {
                    userinfo.put("senin12", nm);
                }

                if (!sen13.isChecked()){
                    if (Ssen13.equals("1")) {
                        userinfo.put("senin13", "");
                    }
                }
                if (sen13.isChecked()) {
                    userinfo.put("senin13", nm);
                }


                if (!sen14.isChecked()){
                    if (Ssen14.equals("1")) {
                        userinfo.put("senin14", "");
                    }
                }
                if (sen14.isChecked()) {
                    userinfo.put("senin14", nm);
                }


                if (!sen15.isChecked()){
                    if (Ssen15.equals("1")) {
                        userinfo.put("senin15", "");
                    }
                }
                if (sen15.isChecked()) {
                    userinfo.put("senin15", nm);
                }

                if (!sen16.isChecked()){
                    if (Ssen16.equals("1")) {
                        userinfo.put("senin16", "");
                    }
                }
                if (sen16.isChecked()) {
                    userinfo.put("senin16", nm);
                }

                if (!sen17.isChecked()){
                    if (Ssen17.equals("1")) {
                        userinfo.put("senin17", "");
                    }
                }
                if (sen17.isChecked()) {
                    userinfo.put("senin17", nm);
                }


                if (!sen18.isChecked()){
                    if (Ssen18.equals("1")) {
                        userinfo.put("senin18", "");
                    }
                }
                if (sen18.isChecked()) {
                    userinfo.put("senin18", nm);
                }

                if (!sen19.isChecked()){
                    if (Ssen19.equals("1")) {
                        userinfo.put("senin19", "");
                    }
                }
                if (sen19.isChecked()) {
                    userinfo.put("senin19", nm);
                }

                if (!sen20.isChecked()){
                    if (Ssen20.equals("1")) {
                        userinfo.put("senin20", "");
                    }
                }
                if (sen20.isChecked()) {
                    userinfo.put("senin20", nm);
                }

                df.update(userinfo);
                DocumentReference df2 = fStore2.collection("Jadwal").document("selasa");
                Map<String, Object> userinfo2 = new HashMap<>();

                if (!sel7.isChecked()) {
                    if (Ssel7.equals("1")) {
                        userinfo2.put("selasa7", "");
                    }
                }
                if (sel7.isChecked()) {
                    userinfo2.put("selasa7", nm);
                }


                if (!sel8.isChecked()) {
                    if (Ssel8.equals("1")) {
                        userinfo2.put("selasa8", "");
                    }
                }
                if (sel8.isChecked()) {
                    userinfo2.put("selasa8", nm);
                }



                if (!sel9.isChecked()) {
                    if (Ssel9.equals("1")) {
                        userinfo2.put("selasa9", "");
                    }
                }
                if (sel9.isChecked()) {
                    userinfo2.put("selasa9", nm);
                }



                if (!sel10.isChecked()) {
                    if (Ssel10.equals("1")) {
                        userinfo2.put("selasa10", "");
                    }
                }
                if (sel10.isChecked()) {
                    userinfo2.put("selasa10", nm);
                }



                if (!sel11.isChecked()) {
                    if (Ssel11.equals("1")) {
                        userinfo2.put("selasa11", "");
                    }
                }
                if (sel11.isChecked()) {
                    userinfo2.put("selasa11", nm);
                }



                if (!sel12.isChecked()) {
                    if (Ssel12.equals("1")) {
                        userinfo2.put("selasa12", "");
                    }
                }
                if (sel12.isChecked()) {
                    userinfo2.put("selasa12", nm);
                }



                if (!sel13.isChecked()) {
                    if (Ssel13.equals("1")) {
                        userinfo2.put("selasa13", "");
                    }
                }
                if (sel13.isChecked()) {
                    userinfo2.put("selasa13", nm);
                }



                if (!sel14.isChecked()) {
                    if (Ssel14.equals("1")) {
                        userinfo2.put("selasa14", "");
                    }
                }
                if (sel14.isChecked()) {
                    userinfo2.put("selasa14", nm);
                }



                if (!sel15.isChecked()) {
                    if (Ssel15.equals("1")) {
                        userinfo2.put("selasa15", "");
                    }
                }
                if (sel15.isChecked()) {
                    userinfo2.put("selasa15", nm);
                }



                if (!sel16.isChecked()) {
                    if (Ssel16.equals("1")) {
                        userinfo2.put("selasa16", "");
                    }
                }
                if (sel16.isChecked()) {
                    userinfo2.put("selasa16", nm);
                }



                if (!sel17.isChecked()) {
                    if (Ssel17.equals("1")) {
                        userinfo2.put("selasa17", "");
                    }
                }
                if (sel17.isChecked()) {
                    userinfo2.put("selasa17", nm);
                }



                if (!sel18.isChecked()) {
                    if (Ssel18.equals("1")) {
                        userinfo2.put("selasa18", "");
                    }
                }
                if (sel18.isChecked()) {
                    userinfo2.put("selasa18", nm);
                }



                if (!sel19.isChecked()) {
                    if (Ssel19.equals("1")) {
                        userinfo2.put("selasa19", "");
                    }
                }
                if (sel19.isChecked()) {
                    userinfo2.put("selasa19", nm);
                }



                if (!sel20.isChecked()) {
                    if (Ssel20.equals("1")) {
                        userinfo2.put("selasa20", "");
                    }
                }
                if (sel20.isChecked()) {
                    userinfo2.put("selasa20", nm);
                }




                df2.update(userinfo2);
                DocumentReference df3 = fStore.collection("Jadwal").document("rabu");
                Map<String, Object> userinfo3 = new HashMap<>();

                if (!rab7.isChecked()) {
                    if (Srab7.equals("1")) {
                        userinfo3.put("rabu7", "");
                    }
                }
                if (rab7.isChecked()) {
                    userinfo3.put("rabu7", nm);
                }



                if (!rab8.isChecked()) {
                    if (Srab8.equals("1")) {
                        userinfo3.put("rabu8", "");
                    }
                }
                if (rab8.isChecked()) {
                    userinfo3.put("rabu8", nm);
                }



                if (!rab9.isChecked()) {
                    if (Srab9.equals("1")) {
                        userinfo3.put("rabu9", "");
                    }
                }
                if (rab9.isChecked()) {
                    userinfo3.put("rabu9", nm);
                }



                if (!rab10.isChecked()) {
                    if (Srab10.equals("1")) {
                        userinfo3.put("rabu10", "");
                    }
                }
                if (rab10.isChecked()) {
                    userinfo3.put("rabu10", nm);
                }



                if (!rab11.isChecked()) {
                    if (Srab11.equals("1")) {
                        userinfo3.put("rabu11", "");
                    }
                }
                if (rab11.isChecked()) {
                    userinfo3.put("rabu11", nm);
                }



                if (!rab12.isChecked()) {
                    if (Srab12.equals("1")) {
                        userinfo3.put("rabu12", "");
                    }
                }
                if (rab12.isChecked()) {
                    userinfo3.put("rabu12", nm);
                }



                if (!rab13.isChecked()) {
                    if (Srab13.equals("1")) {
                        userinfo3.put("rabu13", "");
                    }
                }
                if (rab13.isChecked()) {
                    userinfo3.put("rabu13", nm);
                }



                if (!rab14.isChecked()) {
                    if (Srab14.equals("1")) {
                        userinfo3.put("rabu14", "");
                    }
                }
                if (rab14.isChecked()) {
                    userinfo3.put("rabu14", nm);
                }



                if (!rab15.isChecked()) {
                    if (Srab15.equals("1")) {
                        userinfo3.put("rabu15", "");
                    }
                }
                if (rab15.isChecked()) {
                    userinfo3.put("rabu15", nm);
                }



                if (!rab15.isChecked()) {
                    if (Srab15.equals("1")) {
                        userinfo3.put("rabu15", "");
                    }
                }
                if (rab15.isChecked()) {
                    userinfo3.put("rabu15", nm);
                }



                if (!rab16.isChecked()) {
                    if (Srab16.equals("1")) {
                        userinfo3.put("rabu16", "");
                    }
                }
                if (rab16.isChecked()) {
                    userinfo3.put("rabu16", nm);
                }



                if (!rab17.isChecked()) {
                    if (Srab17.equals("1")) {
                        userinfo3.put("rabu17", "");
                    }
                }
                if (rab17.isChecked()) {
                    userinfo3.put("rabu17", nm);
                }



                if (!rab18.isChecked()) {
                    if (Srab18.equals("1")) {
                        userinfo3.put("rabu18", "");
                    }
                }
                if (rab18.isChecked()) {
                    userinfo3.put("rabu18", nm);
                }



                if (!rab19.isChecked()) {
                    if (Srab19.equals("1")) {
                        userinfo3.put("rabu19", "");
                    }
                }
                if (rab10.isChecked()) {
                    userinfo3.put("rabu10", nm);
                }



                if (!rab20.isChecked()) {
                    if (Srab20.equals("1")) {
                        userinfo3.put("rabu20", "");
                    }
                }
                if (rab20.isChecked()) {
                    userinfo3.put("rabu20", nm);
                }





                df3.update(userinfo3);
                DocumentReference df4 = fStore.collection("Jadwal").document("kamis");
                Map<String, Object> userinfo4 = new HashMap<>();
                if (!kam7.isChecked()) {
                    if (Skam7.equals("1")) {
                        userinfo4.put("kamis7", "");
                    }
                }
                if (kam7.isChecked()) {
                    userinfo4.put("kamis7", nm);
                }


                if (!kam8.isChecked()) {
                    if (Skam8.equals("1")) {
                        userinfo4.put("kamis8", "");
                    }
                }
                if (kam8.isChecked()) {
                    userinfo4.put("kamis8", nm);
                }

                if (!kam9.isChecked()) {
                    if (Skam9.equals("1")) {
                        userinfo4.put("kamis9", "");
                    }
                }
                if (kam9.isChecked()) {
                    userinfo4.put("kamis9", nm);
                }



                if (!kam10.isChecked()) {
                    if (Skam10.equals("1")) {
                        userinfo4.put("kamis10", "");
                    }
                }
                if (kam10.isChecked()) {
                    userinfo4.put("kamis10", nm);
                }



                if (!kam11.isChecked()) {
                    if (Skam11.equals("1")) {
                        userinfo4.put("kamis11", "");
                    }
                }
                if (kam11.isChecked()) {
                    userinfo4.put("kamis11", nm);
                }



                if (!kam12.isChecked()) {
                    if (Skam12.equals("1")) {
                        userinfo4.put("kamis12", "");
                    }
                }
                if (kam12.isChecked()) {
                    userinfo4.put("kamis12", nm);
                }



                if (!kam13.isChecked()) {
                    if (Skam13.equals("1")) {
                        userinfo4.put("kamis13", "");
                    }
                }
                if (kam13.isChecked()) {
                    userinfo4.put("kamis13", nm);
                }



                if (!kam14.isChecked()) {
                    if (Skam14.equals("1")) {
                        userinfo4.put("kamis14", "");
                    }
                }
                if (kam14.isChecked()) {
                    userinfo4.put("kamis14", nm);
                }



                if (!kam15.isChecked()) {
                    if (Skam15.equals("1")) {
                        userinfo4.put("kamis15", "");
                    }
                }
                if (kam15.isChecked()) {
                    userinfo4.put("kamis15", nm);
                }



                if (!kam16.isChecked()) {
                    if (Skam16.equals("1")) {
                        userinfo4.put("kamis16", "");
                    }
                }
                if (kam16.isChecked()) {
                    userinfo4.put("kamis16", nm);
                }



                if (!kam17.isChecked()) {
                    if (Skam17.equals("1")) {
                        userinfo4.put("kamis17", "");
                    }
                }
                if (kam17.isChecked()) {
                    userinfo4.put("kamis17", nm);
                }



                if (!kam18.isChecked()) {
                    if (Skam18.equals("1")) {
                        userinfo4.put("kamis18", "");
                    }
                }
                if (kam18.isChecked()) {
                    userinfo4.put("kamis18", nm);
                }



                if (!kam19.isChecked()) {
                    if (Skam19.equals("1")) {
                        userinfo4.put("kamis19", "");
                    }
                }
                if (kam19.isChecked()) {
                    userinfo4.put("kamis19", nm);
                }



                if (!kam20.isChecked()) {
                    if (Skam20.equals("1")) {
                        userinfo4.put("kamis20", "");
                    }
                }
                if (kam20.isChecked()) {
                    userinfo4.put("kamis20", nm);
                }


                df4.update(userinfo4);
                DocumentReference df5 = fStore.collection("Jadwal").document("jumat");
                Map<String, Object> userinfo5 = new HashMap<>();
                if (!jum7.isChecked()) {
                    if (Sjum7.equals("1")) {
                        userinfo5.put("jumat7", "");
                    }
                }
                if (jum7.isChecked()) {
                    userinfo5.put("jumat7", nm);
                }



                if (!jum8.isChecked()) {
                    if (Sjum8.equals("1")) {
                        userinfo5.put("jumat8", "");
                    }
                }
                if (jum8.isChecked()) {
                    userinfo5.put("jumat8", nm);
                }



                if (!jum9.isChecked()) {
                    if (Sjum9.equals("1")) {
                        userinfo5.put("jumat9", "");
                    }
                }
                if (jum9.isChecked()) {
                    userinfo5.put("jumat9", nm);
                }



                if (!jum10.isChecked()) {
                    if (Sjum10.equals("1")) {
                        userinfo5.put("jumat10", "");
                    }
                }
                if (jum10.isChecked()) {
                    userinfo5.put("jumat10", nm);
                }



                if (!jum11.isChecked()) {
                    if (Sjum11.equals("1")) {
                        userinfo5.put("jumat11", "");
                    }
                }
                if (jum11.isChecked()) {
                    userinfo5.put("jumat11", nm);
                }



                if (!jum12.isChecked()) {
                    if (Sjum12.equals("1")) {
                        userinfo5.put("jumat12", "");
                    }
                }
                if (jum12.isChecked()) {
                    userinfo5.put("jumat12", nm);
                }



                if (!jum13.isChecked()) {
                    if (Sjum13.equals("1")) {
                        userinfo5.put("jumat13", "");
                    }
                }
                if (jum13.isChecked()) {
                    userinfo5.put("jumat13", nm);
                }



                if (!jum14.isChecked()) {
                    if (Sjum14.equals("1")) {
                        userinfo5.put("jumat14", "");
                    }
                }
                if (jum14.isChecked()) {
                    userinfo5.put("jumat14", nm);
                }



                if (!jum15.isChecked()) {
                    if (Sjum15.equals("1")) {
                        userinfo5.put("jumat15", "");
                    }
                }
                if (jum15.isChecked()) {
                    userinfo5.put("jumat15", nm);
                }



                if (!jum16.isChecked()) {
                    if (Sjum16.equals("1")) {
                        userinfo5.put("jumat16", "");
                    }
                }
                if (jum16.isChecked()) {
                    userinfo5.put("jumat16", nm);
                }



                if (!jum17.isChecked()) {
                    if (Sjum17.equals("1")) {
                        userinfo5.put("jumat17", "");
                    }
                }
                if (jum17.isChecked()) {
                    userinfo5.put("jumat17", nm);
                }



                if (!jum18.isChecked()) {
                    if (Sjum18.equals("1")) {
                        userinfo5.put("jumat18", "");
                    }
                }
                if (jum18.isChecked()) {
                    userinfo5.put("jumat18", nm);
                }



                if (!jum19.isChecked()) {
                    if (Sjum19.equals("1")) {
                        userinfo5.put("jumat19", "");
                    }
                }
                if (jum19.isChecked()) {
                    userinfo5.put("jumat19", nm);
                }



                if (!jum20.isChecked()) {
                    if (Sjum20.equals("1")) {
                        userinfo5.put("jumat20", "");
                    }
                }
                if (jum20.isChecked()) {
                    userinfo5.put("jumat20", nm);
                }

                df5.update(userinfo5);
                DocumentReference df6 = fStore.collection("Jadwal").document("sabtu");
                Map<String, Object> userinfo6 = new HashMap<>();
                if (!sab7.isChecked()) {
                    if (Ssab7.equals("1")) {
                        userinfo6.put("sabtu7", "");
                    }
                }
                if (sab7.isChecked()) {
                    userinfo6.put("sabtu7", nm);
                }



                if (!sab8.isChecked()) {
                    if (Ssab8.equals("1")) {
                        userinfo6.put("sabtu8", "");
                    }
                }
                if (sab8.isChecked()) {
                    userinfo6.put("sabtu8", nm);
                }



                if (!sab9.isChecked()) {
                    if (Ssab9.equals("1")) {
                        userinfo6.put("sabtu9", "");
                    }
                }
                if (sab9.isChecked()) {
                    userinfo6.put("sabtu9", nm);
                }



                if (!sab10.isChecked()) {
                    if (Ssab10.equals("1")) {
                        userinfo6.put("sabtu10", "");
                    }
                }
                if (sab10.isChecked()) {
                    userinfo6.put("sabtu10", nm);
                }



                if (!sab11.isChecked()) {
                    if (Ssab11.equals("1")) {
                        userinfo6.put("sabtu11", "");
                    }
                }
                if (sab11.isChecked()) {
                    userinfo6.put("sabtu11", nm);
                }



                if (!sab12.isChecked()) {
                    if (Ssab12.equals("1")) {
                        userinfo6.put("sabtu12", "");
                    }
                }
                if (sab12.isChecked()) {
                    userinfo6.put("sabtu12", nm);
                }



                if (!sab13.isChecked()) {
                    if (Ssab13.equals("1")) {
                        userinfo6.put("sabtu13", "");
                    }
                }
                if (sab13.isChecked()) {
                    userinfo6.put("sabtu13", nm);
                }


                if (!sab14.isChecked()) {
                    if (Ssab14.equals("1")) {
                        userinfo6.put("sabtu14", "");
                    }
                }
                if (sab14.isChecked()) {
                    userinfo6.put("sabtu14", nm);
                }



                if (!sab15.isChecked()) {
                    if (Ssab15.equals("1")) {
                        userinfo6.put("sabtu15", "");
                    }
                }
                if (sab15.isChecked()) {
                    userinfo6.put("sabtu15", nm);
                }



                if (!sab16.isChecked()) {
                    if (Ssab16.equals("1")) {
                        userinfo6.put("sabtu16", "");
                    }
                }
                if (sab16.isChecked()) {
                    userinfo6.put("sabtu16", nm);
                }



                if (!sab17.isChecked()) {
                    if (Ssab17.equals("1")) {
                        userinfo6.put("sabtu17", "");
                    }
                }
                if (sab17.isChecked()) {
                    userinfo6.put("sabtu17", nm);
                }



                if (!sab18.isChecked()) {
                    if (Ssab18.equals("1")) {
                        userinfo6.put("sabtu18", "");
                    }
                }
                if (sab18.isChecked()) {
                    userinfo6.put("sabtu18", nm);
                }



                if (!sab19.isChecked()) {
                    if (Ssab19.equals("1")) {
                        userinfo6.put("sabtu19", "");
                    }
                }
                if (sab19.isChecked()) {
                    userinfo6.put("sabtu19", nm);
                }



                if (!sab20.isChecked()) {
                    if (Ssab20.equals("1")) {
                        userinfo6.put("sabtu20", "");
                    }
                }
                if (sab20.isChecked()) {
                    userinfo6.put("sabtu20", nm);
                }


            df6.update(userinfo6);
                DocumentReference df7 = fStore.collection("Jadwal").document("minggu");
                Map<String, Object> userinfo7 = new HashMap<>();
                if (!ming7.isChecked()) {
                    if (Sming7.equals("1")) {
                        userinfo7.put("minggu7", "");
                    }
                }
                if (ming7.isChecked()) {
                    userinfo7.put("minggu7", nm);
                }


                if (!ming8.isChecked()) {
                    if (Sming8.equals("1")) {
                        userinfo7.put("minggu8", "");
                    }
                }
                if (ming8.isChecked()) {
                    userinfo7.put("minggu8", nm);
                }



                if (!ming9.isChecked()) {
                    if (Sming9.equals("1")) {
                        userinfo7.put("minggu9", "");
                    }
                }
                if (ming9.isChecked()) {
                    userinfo7.put("minggu9", nm);
                }



                if (!ming10.isChecked()) {
                    if (Sming10.equals("1")) {
                        userinfo7.put("minggu10", "");
                    }
                }
                if (ming10.isChecked()) {
                    userinfo7.put("minggu10", nm);
                }



                if (!ming11.isChecked()) {
                    if (Sming11.equals("1")) {
                        userinfo7.put("minggu11", "");
                    }
                }
                if (ming11.isChecked()) {
                    userinfo7.put("minggu11", nm);
                }



                if (!ming12.isChecked()) {
                    if (Sming12.equals("1")) {
                        userinfo7.put("minggu12", "");
                    }
                }
                if (ming12.isChecked()) {
                    userinfo7.put("minggu12", nm);
                }




                if (!ming13.isChecked()) {
                    if (Sming13.equals("1")) {
                        userinfo7.put("minggu13", "");
                    }
                }
                if (ming13.isChecked()) {
                    userinfo7.put("minggu13", nm);
                }



                if (!ming14.isChecked()) {
                    if (Sming14.equals("1")) {
                        userinfo7.put("minggu14", "");
                    }
                }
                if (ming14.isChecked()) {
                    userinfo7.put("minggu14", nm);
                }



                if (!ming15.isChecked()) {
                    if (Sming15.equals("1")) {
                        userinfo7.put("minggu15", "");
                    }
                }
                if (ming15.isChecked()) {
                    userinfo7.put("minggu15", nm);
                }



                if (!ming16.isChecked()) {
                    if (Sming16.equals("1")) {
                        userinfo7.put("minggu16", "");
                    }
                }
                if (ming16.isChecked()) {
                    userinfo7.put("minggu16", nm);
                }



                if (!ming17.isChecked()) {
                    if (Sming17.equals("1")) {
                        userinfo7.put("minggu17", "");
                    }
                }
                if (ming17.isChecked()) {
                    userinfo7.put("minggu17", nm);
                }



                if (!ming18.isChecked()) {
                    if (Sming18.equals("1")) {
                        userinfo7.put("minggu18", "");
                    }
                }
                if (ming18.isChecked()) {
                    userinfo7.put("minggu18", nm);
                }



                if (!ming19.isChecked()) {
                    if (Sming19.equals("1")) {
                        userinfo7.put("minggu19", "");
                    }
                }
                if (ming19.isChecked()) {
                    userinfo7.put("minggu19", nm);
                }



                if (!ming20.isChecked()) {
                    if (Sming20.equals("1")) {
                        userinfo7.put("minggu20", "");
                    }
                }
                if (ming20.isChecked()) {
                    userinfo7.put("minggu20", nm);
                }


                df7.update(userinfo7);


                Bundle c = new Bundle();
                c.putString("nama", nm);
                Intent intInfoJadwal = new Intent(input_weekly_schedule.this, weekly_schedule_trainer.class);
                intInfoJadwal.putExtras(c);
                startActivity(intInfoJadwal);


            }
        });


    }

    private void cekIsi() {
        DocumentReference df = fStore.collection("Jadwal").document("senin");
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()) {
                    Ssen7=new String("0");
                    Ssel7=new String("0");
                    Srab7=new String("0");
                    Skam7=new String("0");
                    Sjum7=new String("0");
                    Ssab7=new String("0");
                    Sming7=new String("0");

                            Ssen8=new String("0");
                            Ssel8=new String("0");
                            Srab8=new String("0");
                            Skam8=new String("0");
                            Sjum8=new String("0");
                            Ssab8=new String("0");
                            Sming8=new String("0");

                            Ssen9=new String("0");
                            Ssel9=new String("0");
                            Srab9=new String("0");
                            Skam9=new String("0");
                            Sjum9=new String("0");
                            Ssab9=new String("0");
                            Sming9=new String("0");
                            Ssen10=new String("0");
                            Ssel10=new String("0");
                            Srab10=new String("0");
                            Skam10=new String("0");
                            Sjum10=new String("0");
                            Ssab10=new String("0");
                            Sming10=new String("0");

                            Ssen11=new String("0");
                            Ssel11=new String("0");
                            Srab11=new String("0");
                            Skam11=new String("0");
                            Sjum11=new String("0");
                            Ssab11=new String("0");
                            Sming11=new String("0");
                            Ssen12=new String("0");
                            
                    Ssel12=new String("0");
                    Srab12=new String("0");
                    Skam12=new String("0");
                    Sjum12=new String("0");
                    Ssab12=new String("0");
                    Sming12=new String("0");

                    Ssen13=new String("0");
                    Ssel13=new String("0");
                    Srab13=new String("0");
                    Skam13=new String("0");
                    Sjum13=new String("0");
                    Ssab13=new String("0");
                    Sming13=new String("0");

                    Ssen14=new String("0");
                    Ssel14=new String("0");
                    Srab14=new String("0");
                    Skam14=new String("0");
                    Sjum14=new String("0");
                    Ssab14=new String("0");
                    Sming14=new String("0");

                    Ssen15=new String("0");
                    Ssel15=new String("0");
                    Srab15=new String("0");
                    Skam15=new String("0");
                    Sjum15=new String("0");
                    Ssab15=new String("0");
                    Sming15=new String("0");

                    Ssen16=new String("0");
                    Ssel16=new String("0");
                    Srab16=new String("0");
                    Skam16=new String("0");
                    Sjum16=new String("0");
                    Ssab16=new String("0");
                    Sming16=new String("0");

                    Ssen17=new String("0");
                    Ssel17=new String("0");
                    Srab17=new String("0");
                    Skam17=new String("0");
                    Sjum17=new String("0");
                    Ssab17=new String("0");
                    Sming17=new String("0");

                    Ssen18=new String("0");
                    Ssel18=new String("0");
                    Srab18=new String("0");
                    Skam18=new String("0");
                    Sjum18=new String("0");
                    Ssab18=new String("0");
                    Sming18=new String("0");

                    Ssen19=new String("0");
                    Ssel19=new String("0");
                    Srab19=new String("0");
                    Skam19=new String("0");
                    Sjum19=new String("0");
                    Ssab19=new String("0");
                    Sming19=new String("0");

                    Ssen20=new String("0");
                    Ssel20=new String("0");
                    Srab20=new String("0");
                    Skam20=new String("0");
                    Sjum20=new String("0");
                    Ssab20=new String("0");
                    Sming20=new String("0");


                    String outSenin7 = task.getResult().getString("senin7");
                    String outSenin8 = task.getResult().getString("senin8");
                    String outSenin9 = task.getResult().getString("senin9");
                    String outSenin10 = task.getResult().getString("senin10");
                    String outSenin11 = task.getResult().getString("senin11");
                    String outSenin12 = task.getResult().getString("senin12");
                    String outSenin13 = task.getResult().getString("senin13");
                    String outSenin14 = task.getResult().getString("senin14");
                    String outSenin15 = task.getResult().getString("senin15");
                    String outSenin16 = task.getResult().getString("senin16");
                    String outSenin17 = task.getResult().getString("senin17");
                    String outSenin18 = task.getResult().getString("senin18");
                    String outSenin19 = task.getResult().getString("senin19");
                    String outSenin20 = task.getResult().getString("senin20");


                    if (!outSenin7.isEmpty()) {
                        sen7.setClickable(false);

                    }
                    if (outSenin7.equals(nm)) {
                        sen7.setClickable(true);
                        sen7.setChecked(true);
                        Ssen7 = new String("1");
                    }
                    if (outSenin7.isEmpty()) {
                        sen7.setClickable(true);
                    }




                    if (!outSenin8.isEmpty()) {
                        sen8.setClickable(false);
                    }
                    if (outSenin8.equals(nm)) {
                        sen8.setClickable(true);
                        sen8.setChecked(true);
                        Ssen8 = new String("1");
                    }
                    if (outSenin8.isEmpty()) {
                        sen8.setClickable(true);
                    }





                    if (!outSenin9.isEmpty()) {
                        sen9.setClickable(false);
                    }
                    if (outSenin9.equals(nm)) {
                        sen9.setClickable(true);
                        sen9.setChecked(true);
                        Ssen9 = new String("1");
                    }
                    if (outSenin9.isEmpty()) {
                        sen9.setClickable(true);
                    }


                    if (!outSenin10.isEmpty()) {
                        sen10.setClickable(false);
                    }
                    if (outSenin10.equals(nm)) {
                        sen10.setClickable(true);
                        sen10.setChecked(true);
                        Ssen10 = new String("1");
                    }
                    if (outSenin10.isEmpty()) {
                        sen10.setClickable(true);
                    }




                    if (!outSenin11.isEmpty()) {
                        sen11.setClickable(false);
                    }
                    if (outSenin11.equals(nm)) {
                        sen11.setClickable(true);
                        sen11.setChecked(true);
                        Ssen11 = new String("1");
                    }
                    if (outSenin11.isEmpty()) {
                        sen11.setClickable(true);
                    }




                    if (!outSenin12.isEmpty()) {
                        sen12.setClickable(false);
                    }
                    if (outSenin12.equals(nm)) {
                        sen12.setClickable(true);
                        sen12.setChecked(true);
                        Ssen12 = new String("1");
                    }
                    if (outSenin12.isEmpty()) {
                        sen12.setClickable(true);
                    }




                    if (!outSenin13.isEmpty()) {
                        sen13.setClickable(false);
                    }
                    if (outSenin13.equals(nm)) {
                        sen13.setClickable(true);
                        sen13.setChecked(true);
                        Ssen13 = new String("1");
                    }
                    if (outSenin13.isEmpty()) {
                        sen13.setClickable(true);
                    }




                    if (!outSenin14.isEmpty()) {
                        sen14.setClickable(false);
                    }
                    if (outSenin14.equals(nm)) {
                        sen14.setClickable(true);
                        sen14.setChecked(true);
                        Ssen14 = new String("1");
                    }
                    if (outSenin14.isEmpty()) {
                        sen14.setClickable(true);
                    }




                    if (!outSenin15.isEmpty()) {
                        sen15.setClickable(false);
                    }
                    if (outSenin15.equals(nm)) {
                        sen15.setClickable(true);
                        sen15.setChecked(true);
                        Ssen15 = new String("1");
                    }
                    if (outSenin15.isEmpty()) {
                        sen15.setClickable(true);
                    }





                    if (!outSenin16.isEmpty()) {
                        sen16.setClickable(false);
                    }
                    if (outSenin16.equals(nm)) {
                        sen16.setClickable(true);
                        sen16.setChecked(true);
                        Ssen16 = new String("1");
                    }
                    if (outSenin16.isEmpty()) {
                        sen16.setClickable(true);
                    }





                    if (!outSenin17.isEmpty()) {
                        sen17.setClickable(false);
                    }
                    if (outSenin17.equals(nm)) {
                        sen17.setClickable(true);
                        sen17.setChecked(true);
                        Ssen17 = new String("1");
                    }
                    if (outSenin17.isEmpty()) {
                        sen17.setClickable(true);
                    }





                    if (!outSenin18.isEmpty()) {
                        sen18.setClickable(false);
                    }
                    if (outSenin18.equals(nm)) {
                        sen18.setClickable(true);
                        sen18.setChecked(true);
                        Ssen18 = new String("1");
                    }
                    if (outSenin18.isEmpty()) {
                        sen18.setClickable(true);
                    }





                    if (!outSenin19.isEmpty()) {
                        sen19.setClickable(false);
                    }
                    if (outSenin19.equals(nm)) {
                        sen19.setClickable(true);
                        sen19.setChecked(true);
                        Ssen19 = new String("1");
                    }
                    if (outSenin19.isEmpty()) {
                        sen19.setClickable(true);
                    }





                    if (!outSenin20.isEmpty()) {
                        sen20.setClickable(false);
                    }
                    if (outSenin20.equals(nm)) {
                        sen20.setClickable(true);
                        sen20.setChecked(true);
                        Ssen20 = new String("1");
                    }
                    if (outSenin20.isEmpty()) {
                        sen20.setClickable(true);
                    }

                }
            }
        });

        DocumentReference df2 = fStore.collection("Jadwal").document("selasa");
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outSelasa7 = task.getResult().getString("selasa7");
                String outSelasa8 = task.getResult().getString("selasa8");
                String outSelasa9 = task.getResult().getString("selasa9");
                String outSelasa10 = task.getResult().getString("selasa10");
                String outSelasa11 = task.getResult().getString("selasa11");
                String outSelasa12 = task.getResult().getString("selasa12");
                String outSelasa13 = task.getResult().getString("selasa13");
                String outSelasa14 = task.getResult().getString("selasa14");
                String outSelasa15 = task.getResult().getString("selasa15");
                String outSelasa16 = task.getResult().getString("selasa16");
                String outSelasa17 = task.getResult().getString("selasa17");
                String outSelasa18 = task.getResult().getString("selasa18");
                String outSelasa19 = task.getResult().getString("selasa19");
                String outSelasa20 = task.getResult().getString("selasa20");

                if (!outSelasa7.isEmpty()) {
                    sel7.setClickable(false);
                }
                if (outSelasa7.equals(nm)) {
                    sel7.setClickable(true);
                    sel7.setChecked(true);
                    Ssel7 = new String("1");
                }
                if (outSelasa7.isEmpty()) {
                    sel7.setClickable(true);
                }





                if (!outSelasa8.isEmpty()) {
                    sel8.setClickable(false);
                }
                if (outSelasa8.equals(nm)) {
                    sel8.setClickable(true);
                    sel8.setChecked(true);
                    Ssel8 = new String("1");
                }
                if (outSelasa8.isEmpty()) {
                    sel8.setClickable(true);
                }





                if (!outSelasa9.isEmpty()) {
                    sel9.setClickable(false);
                }
                if (outSelasa9.equals(nm)) {
                    sel9.setClickable(true);
                    sel9.setChecked(true);
                    Ssel9 = new String("1");
                }
                if (outSelasa9.isEmpty()) {
                    sel9.setClickable(true);
                }





                if (!outSelasa10.isEmpty()) {
                    sel10.setClickable(false);
                }
                if (outSelasa10.equals(nm)) {
                    sel10.setClickable(true);
                    sel10.setChecked(true);
                    Ssel10 = new String("1");
                }
                if (outSelasa10.isEmpty()) {
                    sel10.setClickable(true);
                }





                if (!outSelasa11.isEmpty()) {
                    sel11.setClickable(false);
                }
                if (outSelasa11.equals(nm)) {
                    sel11.setClickable(true);
                    sel11.setChecked(true);
                    Ssel11 = new String("1");
                }
                if (outSelasa11.isEmpty()) {
                    sel11.setClickable(true);
                }





                if (!outSelasa12.isEmpty()) {
                    sel12.setClickable(false);
                }
                if (outSelasa12.equals(nm)) {
                    sel12.setClickable(true);
                    sel12.setChecked(true);
                    Ssel12 = new String("1");
                }
                if (outSelasa12.isEmpty()) {
                    sel12.setClickable(true);
                }





                if (!outSelasa13.isEmpty()) {
                    sel13.setClickable(false);
                }
                if (outSelasa13.equals(nm)) {
                    sel13.setClickable(true);
                    sel13.setChecked(true);
                    Ssel13 = new String("1");
                }
                if (outSelasa13.isEmpty()) {
                    sel13.setClickable(true);
                }





                if (!outSelasa14.isEmpty()) {
                    sel14.setClickable(false);
                }
                if (outSelasa14.equals(nm)) {
                    sel14.setClickable(true);
                    sel14.setChecked(true);
                    Ssel14 = new String("1");
                }
                if (outSelasa14.isEmpty()) {
                    sel14.setClickable(true);
                }





                if (!outSelasa15.isEmpty()) {
                    sel15.setClickable(false);
                }
                if (outSelasa15.equals(nm)) {
                    sel15.setClickable(true);
                    sel15.setChecked(true);
                    Ssel15 = new String("1");
                }
                if (outSelasa15.isEmpty()) {
                    sel15.setClickable(true);
                }




                if (!outSelasa16.isEmpty()) {
                    sel16.setClickable(false);
                }
                if (outSelasa16.equals(nm)) {
                    sel16.setClickable(true);
                    sel16.setChecked(true);
                    Ssel16 = new String("1");
                }
                if (outSelasa16.isEmpty()) {
                    sel16.setClickable(true);
                }





                if (!outSelasa17.isEmpty()) {
                    sel17.setClickable(false);
                }
                if (outSelasa17.equals(nm)) {
                    sel17.setClickable(true);
                    sel17.setChecked(true);
                    Ssel17 = new String("1");
                }
                if (outSelasa17.isEmpty()) {
                    sel17.setClickable(true);
                }





                if (!outSelasa18.isEmpty()) {
                    sel18.setClickable(false);
                }
                if (outSelasa18.equals(nm)) {
                    sel18.setClickable(true);
                    sel18.setChecked(true);
                    Ssel18 = new String("1");
                }
                if (outSelasa18.isEmpty()) {
                    sel18.setClickable(true);
                }





                if (!outSelasa19.isEmpty()) {
                    sel19.setClickable(false);
                }
                if (outSelasa19.equals(nm)) {
                    sel19.setClickable(true);
                    sel19.setChecked(true);
                    Ssel19 = new String("1");
                }
                if (outSelasa19.isEmpty()) {
                    sel19.setClickable(true);
                }





                if (!outSelasa20.isEmpty()) {
                    sel20.setClickable(false);
                }
                if (outSelasa20.equals(nm)) {
                    sel20.setClickable(true);
                    sel20.setChecked(true);
                    Ssel20 = new String("1");
                }
                if (outSelasa20.isEmpty()) {
                    sel20.setClickable(true);
                }


            }
        });

        DocumentReference df3 = fStore.collection("Jadwal").document("rabu");
        df3.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outRabu7 = task.getResult().getString("rabu7");
                String outRabu8 = task.getResult().getString("rabu8");
                String outRabu9 = task.getResult().getString("rabu9");
                String outRabu10 = task.getResult().getString("rabu10");
                String outRabu11 = task.getResult().getString("rabu11");
                String outRabu12 = task.getResult().getString("rabu12");
                String outRabu13 = task.getResult().getString("rabu13");
                String outRabu14 = task.getResult().getString("rabu14");
                String outRabu15 = task.getResult().getString("rabu15");
                String outRabu16 = task.getResult().getString("rabu16");
                String outRabu17 = task.getResult().getString("rabu17");
                String outRabu18 = task.getResult().getString("rabu18");
                String outRabu19 = task.getResult().getString("rabu19");
                String outRabu20 = task.getResult().getString("rabu20");

                if (!outRabu7.isEmpty()) {
                    rab7.setClickable(false);
                }
                if (outRabu7.equals(nm)) {
                    rab7.setClickable(true);
                    rab7.setChecked(true);
                    Srab7 = new String("1");
                }
                if (outRabu7.isEmpty()) {
                    rab7.setClickable(true);
                }





                if (!outRabu8.isEmpty()) {
                    rab8.setClickable(false);
                }
                if (outRabu8.equals(nm)) {
                    rab8.setClickable(true);
                    rab8.setChecked(true);
                    Srab8 = new String("1");
                }
                if (outRabu8.isEmpty()) {
                    rab8.setClickable(true);
                }





                if (!outRabu9.isEmpty()) {
                    rab9.setClickable(false);
                }
                if (outRabu9.equals(nm)) {
                    rab9.setClickable(true);
                    rab9.setChecked(true);
                    Srab9 = new String("1");
                }
                if (outRabu9.isEmpty()) {
                    rab9.setClickable(true);
                }





                if (!outRabu10.isEmpty()) {
                    rab10.setClickable(false);
                }
                if (outRabu10.equals(nm)) {
                    rab10.setClickable(true);
                    rab10.setChecked(true);
                    Srab10 = new String("1");
                }
                if (outRabu10.isEmpty()) {
                    rab10.setClickable(true);
                }





                if (!outRabu11.isEmpty()) {
                    rab11.setClickable(false);
                }
                if (outRabu11.equals(nm)) {
                    rab11.setClickable(true);
                    rab11.setChecked(true);
                    Srab11 = new String("1");
                }
                if (outRabu11.isEmpty()) {
                    rab11.setClickable(true);
                }





                if (!outRabu12.isEmpty()) {
                    rab12.setClickable(false);
                }
                if (outRabu12.equals(nm)) {
                    rab12.setClickable(true);
                    rab12.setChecked(true);
                    Srab12 = new String("1");
                }
                if (outRabu12.isEmpty()) {
                    rab12.setClickable(true);
                }





                if (!outRabu13.isEmpty()) {
                    rab13.setClickable(false);
                }
                if (outRabu13.equals(nm)) {
                    rab13.setClickable(true);
                    rab13.setChecked(true);
                    Srab13 = new String("1");
                }
                if (outRabu13.isEmpty()) {
                    rab13.setClickable(true);
                }





                if (!outRabu14.isEmpty()) {
                    rab14.setClickable(false);
                }
                if (outRabu14.equals(nm)) {
                    rab14.setClickable(true);
                    rab14.setChecked(true);
                    Srab14 = new String("1");
                }
                if (outRabu14.isEmpty()) {
                    rab14.setClickable(true);
                }





                if (!outRabu15.isEmpty()) {
                    rab15.setClickable(false);
                }
                if (outRabu15.equals(nm)) {
                    rab15.setClickable(true);
                    rab15.setChecked(true);
                    Srab15 = new String("1");
                }
                if (outRabu15.isEmpty()) {
                    rab15.setClickable(true);
                }





                if (!outRabu16.isEmpty()) {
                    rab16.setClickable(false);
                }
                if (outRabu16.equals(nm)) {
                    rab16.setClickable(true);
                    rab16.setChecked(true);
                    Srab16 = new String("1");
                }
                if (outRabu16.isEmpty()) {
                    rab16.setClickable(true);
                }





                if (!outRabu17.isEmpty()) {
                    rab17.setClickable(false);
                }
                if (outRabu17.equals(nm)) {
                    rab17.setClickable(true);
                    rab17.setChecked(true);
                    Srab17 = new String("1");
                }
                if (outRabu17.isEmpty()) {
                    rab17.setClickable(true);
                }





                if (!outRabu18.isEmpty()) {
                    rab18.setClickable(false);
                }
                if (outRabu18.equals(nm)) {
                    rab18.setClickable(true);
                    rab18.setChecked(true);
                    Srab18 = new String("1");
                }
                if (outRabu18.isEmpty()) {
                    rab18.setClickable(true);
                }





                if (!outRabu19.isEmpty()) {
                    rab19.setClickable(false);
                }
                if (outRabu19.equals(nm)) {
                    rab19.setClickable(true);
                    rab19.setChecked(true);
                    Srab19 = new String("1");
                }
                if (outRabu19.isEmpty()) {
                    rab19.setClickable(true);
                }



 

                if (!outRabu20.isEmpty()) {
                    rab20.setClickable(false);
                }
                if (outRabu20.equals(nm)) {
                    rab20.setClickable(true);
                    rab20.setChecked(true);
                    Srab20 = new String("1");
                }
                if (outRabu20.isEmpty()) {
                    rab10.setClickable(true);
                }
            }
        });

        DocumentReference df4 = fStore.collection("Jadwal").document("kamis");
        df4.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outKamis7 = task.getResult().getString("kamis7");
                String outKamis8 = task.getResult().getString("kamis8");
                String outKamis9 = task.getResult().getString("kamis9");
                String outKamis10 = task.getResult().getString("kamis10");
                String outKamis11 = task.getResult().getString("kamis11");
                String outKamis12 = task.getResult().getString("kamis12");
                String outKamis13 = task.getResult().getString("kamis13");
                String outKamis14 = task.getResult().getString("kamis14");
                String outKamis15 = task.getResult().getString("kamis15");
                String outKamis16 = task.getResult().getString("kamis16");
                String outKamis17 = task.getResult().getString("kamis17");
                String outKamis18 = task.getResult().getString("kamis18");
                String outKamis19 = task.getResult().getString("kamis19");
                String outKamis20 = task.getResult().getString("kamis20");

                if (!outKamis7.isEmpty()) {
                    kam7.setClickable(false);
                }
                if (outKamis7.equals(nm)) {
                    kam7.setClickable(true);
                    kam7.setChecked(true);
                    Skam7 = new String("1");
                }
                if (outKamis7.isEmpty()) {
                    kam7.setClickable(true);
                }


                if (!outKamis8.isEmpty()) {
                    kam8.setClickable(false);
                }
                if (outKamis8.equals(nm)) {
                    kam8.setClickable(true);
                    kam8.setChecked(true);
                    Skam8 = new String("1");
                }
                if (outKamis8.isEmpty()) {
                    kam8.setClickable(true);
                }





                if (!outKamis9.isEmpty()) {
                    kam9.setClickable(false);
                }
                if (outKamis9.equals(nm)) {
                    kam9.setClickable(true);
                    kam9.setChecked(true);
                    Skam9 = new String("1");
                }
                if (outKamis9.isEmpty()) {
                    kam9.setClickable(true);
                }





                if (!outKamis10.isEmpty()) {
                    kam10.setClickable(false);
                }
                if (outKamis10.equals(nm)) {
                    kam10.setClickable(true);
                    kam10.setChecked(true);
                    Skam10 = new String("1");
                }
                if (outKamis10.isEmpty()) {
                    kam10.setClickable(true);
                }





                if (!outKamis11.isEmpty()) {
                    kam11.setClickable(false);
                }
                if (outKamis11.equals(nm)) {
                    kam11.setClickable(true);
                    kam11.setChecked(true);
                    Skam11 = new String("1");
                }
                if (outKamis11.isEmpty()) {
                    kam11.setClickable(true);
                }





                if (!outKamis12.isEmpty()) {
                    kam12.setClickable(false);
                }
                if (outKamis12.equals(nm)) {
                    kam12.setClickable(true);
                    kam12.setChecked(true);
                    Skam12 = new String("1");
                }
                if (outKamis12.isEmpty()) {
                    kam12.setClickable(true);
                }





                if (!outKamis13.isEmpty()) {
                    kam13.setClickable(false);
                }
                if (outKamis13.equals(nm)) {
                    kam13.setClickable(true);
                    kam13.setChecked(true);
                    Skam13 = new String("1");
                }
                if (outKamis13.isEmpty()) {
                    kam13.setClickable(true);
                }





                if (!outKamis14.isEmpty()) {
                    kam14.setClickable(false);
                }
                if (outKamis14.equals(nm)) {
                    kam14.setClickable(true);
                    kam14.setChecked(true);
                    Skam14 = new String("1");
                }
                if (outKamis14.isEmpty()) {
                    kam14.setClickable(true);
                }





                if (!outKamis15.isEmpty()) {
                    kam15.setClickable(false);
                }
                if (outKamis15.equals(nm)) {
                    kam15.setClickable(true);
                    kam15.setChecked(true);
                    Skam15 = new String("1");
                }
                if (outKamis15.isEmpty()) {
                    kam15.setClickable(true);
                }





                if (!outKamis16.isEmpty()) {
                    kam16.setClickable(false);
                }
                if (outKamis16.equals(nm)) {
                    kam16.setClickable(true);
                    kam16.setChecked(true);
                    Skam16 = new String("1");
                }
                if (outKamis16.isEmpty()) {
                    kam16.setClickable(true);
                }





                if (!outKamis17.isEmpty()) {
                    kam17.setClickable(false);
                }
                if (outKamis17.equals(nm)) {
                    kam17.setClickable(true);
                    kam17.setChecked(true);
                    Skam17 = new String("1");
                }
                if (outKamis17.isEmpty()) {
                    kam17.setClickable(true);
                }





                if (!outKamis18.isEmpty()) {
                    kam18.setClickable(false);
                }
                if (outKamis18.equals(nm)) {
                    kam18.setClickable(true);
                    kam18.setChecked(true);
                    Skam18 = new String("1");
                }
                if (outKamis18.isEmpty()) {
                    kam10.setClickable(true);
                }





                if (!outKamis19.isEmpty()) {
                    kam19.setClickable(false);
                }
                if (outKamis19.equals(nm)) {
                    kam19.setClickable(true);
                    kam19.setChecked(true);
                    Skam19 = new String("1");
                }
                if (outKamis19.isEmpty()) {
                    kam19.setClickable(true);
                }





                if (!outKamis20.isEmpty()) {
                    kam20.setClickable(false);
                }
                if (outKamis20.equals(nm)) {
                    kam20.setClickable(true);
                    kam20.setChecked(true);
                    Skam20 = new String("1");
                }
                if (outKamis20.isEmpty()) {
                    kam20.setClickable(true);
                }


            }
        });

        DocumentReference df5 = fStore.collection("Jadwal").document("jumat");
        df5.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outJumat7 = task.getResult().getString("jumat7");
                String outJumat8 = task.getResult().getString("jumat8");
                String outJumat9 = task.getResult().getString("jumat9");
                String outJumat10 = task.getResult().getString("jumat10");
                String outJumat11 = task.getResult().getString("jumat11");
                String outJumat12 = task.getResult().getString("jumat12");
                String outJumat13 = task.getResult().getString("jumat13");
                String outJumat14 = task.getResult().getString("jumat14");
                String outJumat15 = task.getResult().getString("jumat15");
                String outJumat16 = task.getResult().getString("jumat16");
                String outJumat17 = task.getResult().getString("jumat17");
                String outJumat18 = task.getResult().getString("jumat18");
                String outJumat19 = task.getResult().getString("jumat19");
                String outJumat20 = task.getResult().getString("jumat20");

                if (!outJumat7.isEmpty()) {
                    jum7.setClickable(false);
                }
                if (outJumat7.equals(nm)) {
                    jum7.setClickable(true);
                    jum7.setChecked(true);
                    Sjum7 = new String("1");
                }
                if (outJumat7.isEmpty()) {
                    jum7.setClickable(true);
                }





                if (!outJumat8.isEmpty()) {
                    jum8.setClickable(false);
                }
                if (outJumat8.equals(nm)) {
                    jum8.setClickable(true);
                    jum8.setChecked(true);
                    Sjum8 = new String("1");
                }
                if (outJumat8.isEmpty()) {
                    jum8.setClickable(true);
                }





                if (!outJumat9.isEmpty()) {
                    jum9.setClickable(false);
                }
                if (outJumat9.equals(nm)) {
                    jum9.setClickable(true);
                    jum9.setChecked(true);
                    Sjum9 = new String("1");
                }
                if (outJumat9.isEmpty()) {
                    jum9.setClickable(true);
                }





                if (!outJumat10.isEmpty()) {
                    jum10.setClickable(false);
                }
                if (outJumat10.equals(nm)) {
                    jum10.setClickable(true);
                    jum10.setChecked(true);
                    Sjum10 = new String("1");
                }
                if (outJumat10.isEmpty()) {
                    jum10.setClickable(true);
                }





                if (!outJumat11.isEmpty()) {
                    jum11.setClickable(false);
                }
                if (outJumat11.equals(nm)) {
                    jum11.setClickable(true);
                    jum11.setChecked(true);
                    Sjum11 = new String("1");
                }
                if (outJumat11.isEmpty()) {
                    jum11.setClickable(true);
                }





                if (!outJumat12.isEmpty()) {
                    jum12.setClickable(false);
                }
                if (outJumat12.equals(nm)) {
                    jum12.setClickable(true);
                    jum12.setChecked(true);
                    Sjum12 = new String("1");
                }
                if (outJumat12.isEmpty()) {
                    jum12.setClickable(true);
                }





                if (!outJumat13.isEmpty()) {
                    jum13.setClickable(false);
                }
                if (outJumat13.equals(nm)) {
                    jum13.setClickable(true);
                    jum13.setChecked(true);
                    Sjum13 = new String("1");
                }
                if (outJumat13.isEmpty()) {
                    jum13.setClickable(true);
                }





                if (!outJumat14.isEmpty()) {
                    jum14.setClickable(false);
                }
                if (outJumat14.equals(nm)) {
                    jum14.setClickable(true);
                    jum14.setChecked(true);
                    Sjum14 = new String("1");
                }
                if (outJumat14.isEmpty()) {
                    jum14.setClickable(true);
                }




                if (!outJumat15.isEmpty()) {
                    jum15.setClickable(false);
                }
                if (outJumat15.equals(nm)) {
                    jum15.setClickable(true);
                    jum15.setChecked(true);
                    Sjum15 = new String("1");
                }
                if (outJumat15.isEmpty()) {
                    jum15.setClickable(true);
                }





                if (!outJumat16.isEmpty()) {
                    jum16.setClickable(false);
                }
                if (outJumat16.equals(nm)) {
                    jum16.setClickable(true);
                    jum16.setChecked(true);
                    Sjum16 = new String("1");
                }
                if (outJumat16.isEmpty()) {
                    jum16.setClickable(true);
                }





                if (!outJumat17.isEmpty()) {
                    jum10.setClickable(false);
                }
                if (outJumat17.equals(nm)) {
                    jum17.setClickable(true);
                    jum17.setChecked(true);
                    Sjum17 = new String("1");
                }
                if (outJumat17.isEmpty()) {
                    jum17.setClickable(true);
                }





                if (!outJumat18.isEmpty()) {
                    jum18.setClickable(false);
                }
                if (outJumat18.equals(nm)) {
                    jum18.setClickable(true);
                    jum18.setChecked(true);
                    Sjum18 = new String("1");
                }
                if (outJumat18.isEmpty()) {
                    jum18.setClickable(true);
                }





                if (!outJumat19.isEmpty()) {
                    jum19.setClickable(false);
                }
                if (outJumat19.equals(nm)) {
                    jum19.setClickable(true);
                    jum19.setChecked(true);
                    Sjum19 = new String("1");
                }
                if (outJumat19.isEmpty()) {
                    jum19.setClickable(true);
                }





                if (!outJumat20.isEmpty()) {
                    jum20.setClickable(false);
                }
                if (outJumat20.equals(nm)) {
                    jum20.setClickable(true);
                    jum20.setChecked(true);
                    Sjum20 = new String("1");
                }
                if (outJumat20.isEmpty()) {
                    jum20.setClickable(true);
                }

            }
        });

        DocumentReference df6 = fStore.collection("Jadwal").document("sabtu");
        df6.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outSabtu7 = task.getResult().getString("sabtu7");
                String outSabtu8 = task.getResult().getString("sabtu8");
                String outSabtu9 = task.getResult().getString("sabtu9");
                String outSabtu10 = task.getResult().getString("sabtu10");
                String outSabtu11 = task.getResult().getString("sabtu11");
                String outSabtu12 = task.getResult().getString("sabtu12");
                String outSabtu13 = task.getResult().getString("sabtu13");
                String outSabtu14 = task.getResult().getString("sabtu14");
                String outSabtu15 = task.getResult().getString("sabtu15");
                String outSabtu16 = task.getResult().getString("sabtu16");
                String outSabtu17 = task.getResult().getString("sabtu17");
                String outSabtu18 = task.getResult().getString("sabtu18");
                String outSabtu19 = task.getResult().getString("sabtu19");
                String outSabtu20 = task.getResult().getString("sabtu20");

                if (!outSabtu7.isEmpty()) {
                    sab7.setClickable(false);
                }
                if (outSabtu7.equals(nm)) {
                    sab7.setClickable(true);
                    sab7.setChecked(true);
                    Ssab7 = new String("1");
                }
                if (outSabtu7.isEmpty()) {
                    sab7.setClickable(true);
                }





                if (!outSabtu8.isEmpty()) {
                    sab8.setClickable(false);
                }
                if (outSabtu8.equals(nm)) {
                    sab8.setClickable(true);
                    sab8.setChecked(true);
                    Ssab8 = new String("1");
                }
                if (outSabtu8.isEmpty()) {
                    sab8.setClickable(true);
                }





                if (!outSabtu9.isEmpty()) {
                    sab9.setClickable(false);
                }
                if (outSabtu9.equals(nm)) {
                    sab9.setClickable(true);
                    sab9.setChecked(true);
                    Ssab9 = new String("1");
                }
                if (outSabtu9.isEmpty()) {
                    sab9.setClickable(true);
                }





                if (!outSabtu10.isEmpty()) {
                    sab10.setClickable(false);
                }
                if (outSabtu10.equals(nm)) {
                    sab10.setClickable(true);
                    sab10.setChecked(true);
                    Ssab10 = new String("1");
                }
                if (outSabtu10.isEmpty()) {
                    sab10.setClickable(true);
                }





                if (!outSabtu11.isEmpty()) {
                    sab11.setClickable(false);
                }
                if (outSabtu11.equals(nm)) {
                    sab11.setClickable(true);
                    sab11.setChecked(true);
                    Ssab11 = new String("1");
                }
                if (outSabtu11.isEmpty()) {
                    sab11.setClickable(true);
                }





                if (!outSabtu12.isEmpty()) {
                    sab12.setClickable(false);
                }
                if (outSabtu12.equals(nm)) {
                    sab12.setClickable(true);
                    sab12.setChecked(true);
                    Ssab12 = new String("1");
                }
                if (outSabtu12.isEmpty()) {
                    sab12.setClickable(true);
                }





                if (!outSabtu13.isEmpty()) {
                    sab13.setClickable(false);
                }
                if (outSabtu13.equals(nm)) {
                    sab13.setClickable(true);
                    sab13.setChecked(true);
                    Ssab13 = new String("1");
                }
                if (outSabtu13.isEmpty()) {
                    sab13.setClickable(true);
                }





                if (!outSabtu14.isEmpty()) {
                    sab14.setClickable(false);
                }
                if (outSabtu14.equals(nm)) {
                    sab14.setClickable(true);
                    sab14.setChecked(true);
                    Ssab14 = new String("1");
                }
                if (outSabtu14.isEmpty()) {
                    sab14.setClickable(true);
                }





                if (!outSabtu15.isEmpty()) {
                    sab15.setClickable(false);
                }
                if (outSabtu15.equals(nm)) {
                    sab15.setClickable(true);
                    sab15.setChecked(true);
                    Ssab15 = new String("1");
                }
                if (outSabtu15.isEmpty()) {
                    sab15.setClickable(true);
                }





                if (!outSabtu16.isEmpty()) {
                    sab16.setClickable(false);
                }
                if (outSabtu16.equals(nm)) {
                    sab16.setClickable(true);
                    sab16.setChecked(true);
                    Ssab16 = new String("1");
                }
                if (outSabtu16.isEmpty()) {
                    sab16.setClickable(true);
                }





                if (!outSabtu17.isEmpty()) {
                    sab17.setClickable(false);
                }
                if (outSabtu17.equals(nm)) {
                    sab17.setClickable(true);
                    sab17.setChecked(true);
                    Ssab17 = new String("1");
                }
                if (outSabtu17.isEmpty()) {
                    sab17.setClickable(true);
                }





                if (!outSabtu18.isEmpty()) {
                    sab18.setClickable(false);
                }
                if (outSabtu18.equals(nm)) {
                    sab18.setClickable(true);
                    sab18.setChecked(true);
                    Ssab18 = new String("1");
                }
                if (outSabtu18.isEmpty()) {
                    sab18.setClickable(true);
                }





                if (!outSabtu19.isEmpty()) {
                    sab19.setClickable(false);
                }
                if (outSabtu19.equals(nm)) {
                    sab19.setClickable(true);
                    sab19.setChecked(true);
                    Ssab19 = new String("1");
                }
                if (outSabtu19.isEmpty()) {
                    sab19.setClickable(true);
                }





                if (!outSabtu20.isEmpty()) {
                    sab20.setClickable(false);
                }
                if (outSabtu20.equals(nm)) {
                    sab20.setClickable(true);
                    sab20.setChecked(true);
                    Ssab20 = new String("1");
                }
                if (outSabtu20.isEmpty()) {
                    sab20.setClickable(true);
                }

            }
        });

        DocumentReference df7 = fStore.collection("Jadwal").document("minggu");
        df7.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String outMinggu7 = task.getResult().getString("minggu7");
                String outMinggu8 = task.getResult().getString("minggu8");
                String outMinggu9 = task.getResult().getString("minggu9");
                String outMinggu10 = task.getResult().getString("minggu10");
                String outMinggu11 = task.getResult().getString("minggu11");
                String outMinggu12 = task.getResult().getString("minggu12");
                String outMinggu13 = task.getResult().getString("minggu13");
                String outMinggu14 = task.getResult().getString("minggu14");
                String outMinggu15 = task.getResult().getString("minggu15");
                String outMinggu16 = task.getResult().getString("minggu16");
                String outMinggu17 = task.getResult().getString("minggu17");
                String outMinggu18 = task.getResult().getString("minggu18");
                String outMinggu19 = task.getResult().getString("minggu19");
                String outMinggu20 = task.getResult().getString("minggu20");

                if (!outMinggu7.isEmpty()) {
                    ming7.setClickable(false);
                }
                if (outMinggu7.equals(nm)) {
                    ming7.setClickable(true);
                    ming7.setChecked(true);
                    Sming7 = new String("1");
                }
                if (outMinggu7.isEmpty()) {
                    ming7.setClickable(true);
                }




                if (!outMinggu8.isEmpty()) {
                    ming8.setClickable(false);
                }
                if (outMinggu8.equals(nm)) {
                    ming8.setClickable(true);
                    ming8.setChecked(true);
                    Sming8 = new String("1");
                }
                if (outMinggu8.isEmpty()) {
                    ming8.setClickable(true);
                }





                if (!outMinggu9.isEmpty()) {
                    ming9.setClickable(false);
                }
                if (outMinggu9.equals(nm)) {
                    ming9.setClickable(true);
                    ming9.setChecked(true);
                    Sming9 = new String("1");
                }
                if (outMinggu9.isEmpty()) {
                    ming9.setClickable(true);
                }





                if (!outMinggu10.isEmpty()) {
                    ming10.setClickable(false);
                }
                if (outMinggu10.equals(nm)) {
                    ming10.setClickable(true);
                    ming10.setChecked(true);
                    Sming10 = new String("1");
                }
                if (outMinggu10.isEmpty()) {
                    ming10.setClickable(true);
                }





                if (!outMinggu11.isEmpty()) {
                    ming11.setClickable(false);
                }
                if (outMinggu11.equals(nm)) {
                    ming11.setClickable(true);
                    ming11.setChecked(true);
                    Sming11 = new String("1");
                }
                if (outMinggu11.isEmpty()) {
                    ming11.setClickable(true);
                }





                if (!outMinggu12.isEmpty()) {
                    ming12.setClickable(false);
                }
                if (outMinggu12.equals(nm)) {
                    ming12.setClickable(true);
                    ming12.setChecked(true);
                    Sming12 = new String("1");
                }
                if (outMinggu12.isEmpty()) {
                    ming12.setClickable(true);
                }





                if (!outMinggu13.isEmpty()) {
                    ming13.setClickable(false);
                }
                if (outMinggu13.equals(nm)) {
                    ming13.setClickable(true);
                    ming13.setChecked(true);
                    Sming13 = new String("1");
                }
                if (outMinggu13.isEmpty()) {
                    ming13.setClickable(true);
                }





                if (!outMinggu14.isEmpty()) {
                    ming14.setClickable(false);
                }
                if (outMinggu14.equals(nm)) {
                    ming14.setClickable(true);
                    ming14.setChecked(true);
                    Sming14 = new String("1");
                }
                if (outMinggu14.isEmpty()) {
                    ming14.setClickable(true);
                }





                if (!outMinggu15.isEmpty()) {
                    ming15.setClickable(false);
                }
                if (outMinggu15.equals(nm)) {
                    ming15.setClickable(true);
                    ming15.setChecked(true);
                    Sming15 = new String("1");
                }
                if (outMinggu15.isEmpty()) {
                    ming15.setClickable(true);
                }





                if (!outMinggu16.isEmpty()) {
                    ming16.setClickable(false);
                }
                if (outMinggu16.equals(nm)) {
                    ming16.setClickable(true);
                    ming16.setChecked(true);
                    Sming16 = new String("1");
                }
                if (outMinggu16.isEmpty()) {
                    ming16.setClickable(true);
                }





                if (!outMinggu17.isEmpty()) {
                    ming17.setClickable(false);
                }
                if (outMinggu17.equals(nm)) {
                    ming17.setClickable(true);
                    ming17.setChecked(true);
                    Sming17 = new String("1");
                }
                if (outMinggu17.isEmpty()) {
                    ming17.setClickable(true);
                }





                if (!outMinggu18.isEmpty()) {
                    ming18.setClickable(false);
                }
                if (outMinggu18.equals(nm)) {
                    ming18.setClickable(true);
                    ming18.setChecked(true);
                    Sming18 = new String("1");
                }
                if (outMinggu18.isEmpty()) {
                    ming18.setClickable(true);
                }





                if (!outMinggu19.isEmpty()) {
                    ming19.setClickable(false);
                }
                if (outMinggu19.equals(nm)) {
                    ming19.setClickable(true);
                    ming19.setChecked(true);
                    Sming19 = new String("1");
                }
                if (outMinggu19.isEmpty()) {
                    ming19.setClickable(true);
                }





                if (!outMinggu20.isEmpty()) {
                    ming20.setClickable(false);
                }
                if (outMinggu20.equals(nm)) {
                    ming20.setClickable(true);
                    ming20.setChecked(true);
                    Sming20 = new String("1");
                }
                if (outMinggu20.isEmpty()) {
                    ming20.setClickable(true);
                }
            }
        });


    }
}