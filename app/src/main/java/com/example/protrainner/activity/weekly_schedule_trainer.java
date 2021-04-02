package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Nonnull;

public class weekly_schedule_trainer extends AppCompatActivity {

    String uid, nmJdw;
    Button btnInputJadwalLatihan;
    TextView namaJadwal;
    TextView outSen7, outSel7, outRab7, outKam7, outJum7, outSab7, outMing7
            ,outSen8, outSel8, outRab8, outKam8, outJum8, outSab8, outMing8
            ,outSen9, outSel9, outRab9, outKam9, outJum9, outSab9, outMing9
            ,outSen10, outSel10, outRab10, outKam10, outJum10, outSab10, outMing10
            ,outSen11, outSel11, outRab11, outKam11, outJum11, outSab11, outMing11
            ,outSen12, outSel12, outRab12, outKam12, outJum12, outSab12, outMing12
            ,outSen13, outSel13, outRab13, outKam13, outJum13, outSab13, outMing13
            ,outSen14, outSel14, outRab14, outKam14, outJum14, outSab14, outMing14
            ,outSen15, outSel15, outRab15, outKam15, outJum15, outSab15, outMing15
            ,outSen16, outSel16, outRab16, outKam16, outJum16, outSab16, outMing16
            ,outSen17, outSel17, outRab17, outKam17, outJum17, outSab17, outMing17
            ,outSen18, outSel18, outRab18, outKam18, outJum18, outSab18, outMing18
            ,outSen19, outSel19, outRab19, outKam19, outJum19, outSab19, outMing19
            ,outSen20, outSel20, outRab20, outKam20, outJum20, outSab20, outMing20;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekly_schedule_trainer);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        namaJadwal = findViewById(R.id.senin7);
        namaJadwal = findViewById(R.id.senin8);
        namaJadwal = findViewById(R.id.senin9);
        namaJadwal = findViewById(R.id.senin10);
        namaJadwal = findViewById(R.id.senin12);
        namaJadwal = findViewById(R.id.senin13);
        namaJadwal = findViewById(R.id.senin14);
        namaJadwal = findViewById(R.id.senin15);
        namaJadwal = findViewById(R.id.senin16);
        namaJadwal = findViewById(R.id.senin17);
        namaJadwal = findViewById(R.id.senin18);
        namaJadwal = findViewById(R.id.senin19);
        namaJadwal = findViewById(R.id.senin20);

        namaJadwal = findViewById(R.id.selasa7);
        namaJadwal = findViewById(R.id.selasa8);
        namaJadwal = findViewById(R.id.selasa9);
        namaJadwal = findViewById(R.id.selasa10);
        namaJadwal = findViewById(R.id.selasa11);
        namaJadwal = findViewById(R.id.selasa12);
        namaJadwal = findViewById(R.id.selasa13);
        namaJadwal = findViewById(R.id.selasa14);
        namaJadwal = findViewById(R.id.selasa15);
        namaJadwal = findViewById(R.id.selasa16);
        namaJadwal = findViewById(R.id.selasa17);
        namaJadwal = findViewById(R.id.selasa18);
        namaJadwal = findViewById(R.id.selasa19);
        namaJadwal = findViewById(R.id.selasa20);

        namaJadwal = findViewById(R.id.rabu7);
        namaJadwal = findViewById(R.id.rabu8);
        namaJadwal = findViewById(R.id.rabu9);
        namaJadwal = findViewById(R.id.rabu10);
        namaJadwal = findViewById(R.id.rabu11);
        namaJadwal = findViewById(R.id.rabu12);
        namaJadwal = findViewById(R.id.rabu13);
        namaJadwal = findViewById(R.id.rabu14);
        namaJadwal = findViewById(R.id.rabu15);
        namaJadwal = findViewById(R.id.rabu16);
        namaJadwal = findViewById(R.id.rabu17);
        namaJadwal = findViewById(R.id.rabu18);
        namaJadwal = findViewById(R.id.rabu19);
        namaJadwal = findViewById(R.id.rabu20);

        namaJadwal = findViewById(R.id.kamis7);
        namaJadwal = findViewById(R.id.kamis8);
        namaJadwal = findViewById(R.id.kamis9);
        namaJadwal = findViewById(R.id.kamis10);
        namaJadwal = findViewById(R.id.kamis11);
        namaJadwal = findViewById(R.id.kamis12);
        namaJadwal = findViewById(R.id.kamis13);
        namaJadwal = findViewById(R.id.kamis14);
        namaJadwal = findViewById(R.id.kamis15);
        namaJadwal = findViewById(R.id.kamis16);
        namaJadwal = findViewById(R.id.kamis17);
        namaJadwal = findViewById(R.id.kamis18);
        namaJadwal = findViewById(R.id.kamis19);
        namaJadwal = findViewById(R.id.kamis20);

        namaJadwal = findViewById(R.id.jumat7);
        namaJadwal = findViewById(R.id.jumat8);
        namaJadwal = findViewById(R.id.jumat9);
        namaJadwal = findViewById(R.id.jumat10);
        namaJadwal = findViewById(R.id.jumat11);
        namaJadwal = findViewById(R.id.jumat12);
        namaJadwal = findViewById(R.id.jumat13);
        namaJadwal = findViewById(R.id.jumat14);
        namaJadwal = findViewById(R.id.jumat15);
        namaJadwal = findViewById(R.id.jumat16);
        namaJadwal = findViewById(R.id.jumat17);
        namaJadwal = findViewById(R.id.jumat18);
        namaJadwal = findViewById(R.id.jumat19);
        namaJadwal = findViewById(R.id.jumat20);

        namaJadwal = findViewById(R.id.sabtu7);
        namaJadwal = findViewById(R.id.sabtu8);
        namaJadwal = findViewById(R.id.sabtu9);
        namaJadwal = findViewById(R.id.sabtu10);
        namaJadwal = findViewById(R.id.sabtu11);
        namaJadwal = findViewById(R.id.sabtu12);
        namaJadwal = findViewById(R.id.sabtu13);
        namaJadwal = findViewById(R.id.sabtu14);
        namaJadwal = findViewById(R.id.sabtu15);
        namaJadwal = findViewById(R.id.sabtu16);
        namaJadwal = findViewById(R.id.sabtu17);
        namaJadwal = findViewById(R.id.sabtu18);
        namaJadwal = findViewById(R.id.sabtu19);
        namaJadwal = findViewById(R.id.sabtu20);

        namaJadwal = findViewById(R.id.minggu7);
        namaJadwal = findViewById(R.id.minggu8);
        namaJadwal = findViewById(R.id.minggu9);
        namaJadwal = findViewById(R.id.minggu10);
        namaJadwal = findViewById(R.id.minggu11);
        namaJadwal = findViewById(R.id.minggu12);
        namaJadwal = findViewById(R.id.minggu13);
        namaJadwal = findViewById(R.id.minggu14);
        namaJadwal = findViewById(R.id.minggu15);
        namaJadwal = findViewById(R.id.minggu16);
        namaJadwal = findViewById(R.id.minggu17);
        namaJadwal = findViewById(R.id.minggu18);
        namaJadwal = findViewById(R.id.minggu19);
        namaJadwal = findViewById(R.id.minggu20);


        outSen7 = findViewById(R.id.senin7);
        outSen8 = findViewById(R.id.senin8);
        outSen9 = findViewById(R.id.senin9);
        outSen10 = findViewById(R.id.senin10);
        outSen11 = findViewById(R.id.senin11);
        outSen12 = findViewById(R.id.senin12);
        outSen13 = findViewById(R.id.senin13);
        outSen14 = findViewById(R.id.senin14);
        outSen15 = findViewById(R.id.senin15);
        outSen16 = findViewById(R.id.senin16);
        outSen17 = findViewById(R.id.senin17);
        outSen18 = findViewById(R.id.senin18);
        outSen19 = findViewById(R.id.senin19);
        outSen20 = findViewById(R.id.senin20);

        outSel7 = findViewById(R.id.selasa7);
        outSel8 = findViewById(R.id.selasa8);
        outSel9 = findViewById(R.id.selasa9);
        outSel10 = findViewById(R.id.selasa10);
        outSel11 = findViewById(R.id.selasa11);
        outSel12 = findViewById(R.id.selasa12);
        outSel13 = findViewById(R.id.selasa13);
        outSel14 = findViewById(R.id.selasa14);
        outSel15 = findViewById(R.id.selasa15);
        outSel16 = findViewById(R.id.selasa16);
        outSel17 = findViewById(R.id.selasa17);
        outSel18 = findViewById(R.id.selasa18);
        outSel19 = findViewById(R.id.selasa19);
        outSel20 = findViewById(R.id.selasa20);

        outRab7 = findViewById(R.id.rabu7);
        outRab8 = findViewById(R.id.rabu8);
        outRab9 = findViewById(R.id.rabu9);
        outRab10 = findViewById(R.id.rabu10);
        outRab11 = findViewById(R.id.rabu11);
        outRab12 = findViewById(R.id.rabu12);
        outRab13 = findViewById(R.id.rabu13);
        outRab14 = findViewById(R.id.rabu14);
        outRab15 = findViewById(R.id.rabu15);
        outRab16 = findViewById(R.id.rabu16);
        outRab17 = findViewById(R.id.rabu17);
        outRab18 = findViewById(R.id.rabu18);
        outRab19 = findViewById(R.id.rabu19);
        outRab20 = findViewById(R.id.rabu20);
        outKam7 = findViewById(R.id.kamis7);
        outKam8 = findViewById(R.id.kamis8);
        outKam9 = findViewById(R.id.kamis9);
        outKam10 = findViewById(R.id.kamis10);
        outKam11 = findViewById(R.id.kamis11);
        outKam12 = findViewById(R.id.kamis12);
        outKam13 = findViewById(R.id.kamis13);
        outKam14 = findViewById(R.id.kamis14);
        outKam15 = findViewById(R.id.kamis15);
        outKam16 = findViewById(R.id.kamis16);
        outKam17 = findViewById(R.id.kamis17);
        outKam18 = findViewById(R.id.kamis18);
        outKam19 = findViewById(R.id.kamis19);
        outKam20 = findViewById(R.id.kamis20);

        outJum7 = findViewById(R.id.jumat7);
        outJum8 = findViewById(R.id.jumat8);
        outJum9 = findViewById(R.id.jumat9);
        outJum10 = findViewById(R.id.jumat10);
        outJum11 = findViewById(R.id.jumat11);
        outJum12 = findViewById(R.id.jumat12);
        outJum13 = findViewById(R.id.jumat13);
        outJum14 = findViewById(R.id.jumat14);
        outJum15 = findViewById(R.id.jumat15);
        outJum16 = findViewById(R.id.jumat16);
        outJum17 = findViewById(R.id.jumat17);
        outJum18 = findViewById(R.id.jumat18);
        outJum19 = findViewById(R.id.jumat19);
        outJum20 = findViewById(R.id.jumat20);

        outSab7 = findViewById(R.id.sabtu7);
        outSab8 = findViewById(R.id.sabtu8);
        outSab9 = findViewById(R.id.sabtu9);
        outSab10 = findViewById(R.id.sabtu10);
        outSab11 = findViewById(R.id.sabtu11);
        outSab12 = findViewById(R.id.sabtu12);
        outSab13 = findViewById(R.id.sabtu13);
        outSab14 = findViewById(R.id.sabtu14);
        outSab15 = findViewById(R.id.sabtu15);
        outSab16 = findViewById(R.id.sabtu16);
        outSab17 = findViewById(R.id.sabtu17);
        outSab18 = findViewById(R.id.sabtu18);
        outSab19 = findViewById(R.id.sabtu19);
        outSab20 = findViewById(R.id.sabtu20);

        outMing7 = findViewById(R.id.minggu7);
        outMing8 = findViewById(R.id.minggu8);
        outMing9 = findViewById(R.id.minggu9);
        outMing10 = findViewById(R.id.minggu10);
        outMing11 = findViewById(R.id.minggu11);
        outMing12 = findViewById(R.id.minggu12);
        outMing13 = findViewById(R.id.minggu13);
        outMing14 = findViewById(R.id.minggu14);
        outMing15 = findViewById(R.id.minggu15);
        outMing16 = findViewById(R.id.minggu16);
        outMing17 = findViewById(R.id.minggu17);
        outMing18 = findViewById(R.id.minggu18);
        outMing19 = findViewById(R.id.minggu19);
        outMing20 = findViewById(R.id.minggu20);

        btnInputJadwalLatihan = (Button) findViewById(R.id.inp_jadwal_latihan);

        /*
        FirebaseUser user = mAuth.getCurrentUser();
        DocumentReference df = fStore.collection("Akun").document(user.getUid()).
                collection("Jadwal").document(user.getUid());
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()){
                    String nJdw1 = task.getResult().getString("namajadwal");

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

                    nmJdw = nJdw1;
                    namaJadwal.setText(nJdw1);

                    if (outSenin7.equals("1")){
                        outSen7.setText(nJdw1);
                    }
                    if (outSenin8.equals("1")){
                        outSen8.setText(nmJdw);
                    }
                    if (outSenin9.equals("1")){
                        outSen9.setText(nmJdw);
                    }
                    if (outSenin10.equals("1")){
                        outSen10.setText(nmJdw);
                    }
                    if (outSenin11.equals("1")){
                        outSen11.setText(nmJdw);
                    }
                    if (outSenin12.equals("1")){
                        outSen12.setText(nmJdw);
                    }
                    if (outSenin13.equals("1")){
                        outSen13.setText(nmJdw);
                    }
                    if (outSenin14.equals("1")){
                        outSen14.setText(nmJdw);
                    }
                    if (outSenin15.equals("1")){
                        outSen15.setText(nmJdw);
                    }
                    if (outSenin16.equals("1")){
                        outSen16.setText(nmJdw);
                    }
                    if (outSenin17.equals("1")){
                        outSen17.setText(nmJdw);
                    }
                    if (outSenin18.equals("1")){
                        outSen18.setText(nmJdw);
                    }
                    if (outSenin19.equals("1")){
                        outSen19.setText(nmJdw);
                    }
                    if (outSenin20.equals("1")){
                        outSen20.setText(nmJdw);
                    }



                    if (outSelasa7.equals("1")){
                        outSel7.setText(nmJdw);
                    }
                    if (outSelasa8.equals("1")){
                        outSel8.setText(nmJdw);
                    }
                    if (outSelasa9.equals("1")){
                        outSel9.setText(nmJdw);
                    }
                    if (outSelasa10.equals("1")){
                        outSel10.setText(nmJdw);
                    }
                    if (outSelasa11.equals("1")){
                        outSel11.setText(nmJdw);
                    }
                    if (outSelasa12.equals("1")){
                        outSel12.setText(nmJdw);
                    }
                    if (outSelasa13.equals("1")){
                        outSel13.setText(nmJdw);
                    }
                    if (outSelasa14.equals("1")){
                        outSel14.setText(nmJdw);
                    }
                    if (outSelasa15.equals("1")){
                        outSel15.setText(nmJdw);
                    }
                    if (outSelasa16.equals("1")){
                        outSel16.setText(nmJdw);
                    }
                    if (outSelasa17.equals("1")){
                        outSel17.setText(nmJdw);
                    }
                    if (outSelasa18.equals("1")){
                        outSel18.setText(nmJdw);
                    }
                    if (outSelasa19.equals("1")){
                        outSel19.setText(nmJdw);
                    }
                    if (outSelasa20.equals("1")){
                        outSel20.setText(nmJdw);
                    }



                    if (outRabu7.equals("1")){
                        outRab7.setText(nmJdw);
                    }
                    if (outRabu8.equals("1")){
                        outRab8.setText(nmJdw);
                    }
                    if (outRabu9.equals("1")){
                        outRab9.setText(nmJdw);
                    }
                    if (outRabu10.equals("1")){
                        outRab10.setText(nmJdw);
                    }
                    if (outRabu11.equals("1")){
                        outRab11.setText(nmJdw);
                    }
                    if (outRabu12.equals("1")){
                        outRab12.setText(nmJdw);
                    }
                    if (outRabu13.equals("1")){
                        outRab13.setText(nmJdw);
                    }
                    if (outRabu14.equals("1")){
                        outRab14.setText(nmJdw);
                    }
                    if (outRabu15.equals("1")){
                        outRab15.setText(nmJdw);
                    }
                    if (outRabu16.equals("1")){
                        outRab16.setText(nmJdw);
                    }
                    if (outRabu17.equals("1")){
                        outRab17.setText(nmJdw);
                    }
                    if (outRabu18.equals("1")){
                        outRab18.setText(nmJdw);
                    }
                    if (outRabu19.equals("1")){
                        outRab19.setText(nmJdw);
                    }
                    if (outRabu20.equals("1")){
                        outRab20.setText(nmJdw);
                    }



                    if (outKamis7.equals("1")){
                        outKam7.setText(nmJdw);
                    }
                    if (outKamis8.equals("1")){
                        outKam8.setText(nmJdw);
                    }
                    if (outKamis9.equals("1")){
                        outKam9.setText(nmJdw);
                    }
                    if (outKamis10.equals("1")){
                        outKam10.setText(nmJdw);
                    }
                    if (outKamis11.equals("1")){
                        outKam11.setText(nmJdw);
                    }
                    if (outKamis12.equals("1")){
                        outKam12.setText(nmJdw);
                    }
                    if (outKamis13.equals("1")){
                        outKam13.setText(nmJdw);
                    }
                    if (outKamis14.equals("1")){
                        outKam14.setText(nmJdw);
                    }
                    if (outKamis15.equals("1")){
                        outKam15.setText(nmJdw);
                    }
                    if (outKamis16.equals("1")){
                        outKam16.setText(nmJdw);
                    }
                    if (outKamis17.equals("1")){
                        outKam17.setText(nmJdw);
                    }
                    if (outKamis18.equals("1")){
                        outKam18.setText(nmJdw);
                    }
                    if (outKamis19.equals("1")){
                        outKam19.setText(nmJdw);
                    }
                    if (outKamis20.equals("1")){
                        outKam20.setText(nmJdw);
                    }



                    if (outJumat7.equals("1")){
                        outJum7.setText(nmJdw);
                    }
                    if (outJumat8.equals("1")){
                        outJum9.setText(nmJdw);
                    }
                    if (outJumat9.equals("1")){
                        outJum9.setText(nmJdw);
                    }
                    if (outJumat10.equals("1")){
                        outJum10.setText(nmJdw);
                    }
                    if (outJumat11.equals("1")){
                        outJum11.setText(nmJdw);
                    }
                    if (outJumat12.equals("1")){
                        outJum12.setText(nmJdw);
                    }
                    if (outJumat13.equals("1")){
                        outJum13.setText(nmJdw);
                    }
                    if (outJumat14.equals("1")){
                        outJum14.setText(nmJdw);
                    }
                    if (outJumat15.equals("1")){
                        outJum15.setText(nmJdw);
                    }
                    if (outJumat16.equals("1")){
                        outJum16.setText(nmJdw);
                    }
                    if (outJumat17.equals("1")){
                        outJum17.setText(nmJdw);
                    }
                    if (outJumat18.equals("1")){
                        outJum18.setText(nmJdw);
                    }
                    if (outJumat19.equals("1")){
                        outJum19.setText(nmJdw);
                    }
                    if (outJumat20.equals("1")){
                        outJum20.setText(nmJdw);
                    }




                    if (outSabtu7.equals("1")){
                        outSab7.setText(nmJdw);
                    }
                    if (outSabtu8.equals("1")){
                        outSab8.setText(nmJdw);
                    }
                    if (outSabtu9.equals("1")){
                        outSab9.setText(nmJdw);
                    }
                    if (outSabtu10.equals("1")){
                        outSab10.setText(nmJdw);
                    }
                    if (outSabtu11.equals("1")){
                        outSab11.setText(nmJdw);
                    }
                    if (outSabtu12.equals("1")){
                        outSab12.setText(nmJdw);
                    }
                    if (outSabtu13.equals("1")){
                        outSab13.setText(nmJdw);
                    }
                    if (outSabtu14.equals("1")){
                        outSab14.setText(nmJdw);
                    }
                    if (outSabtu15.equals("1")){
                        outSab15.setText(nmJdw);
                    }
                    if (outSabtu16.equals("1")){
                        outSab16.setText(nmJdw);
                    }
                    if (outSabtu17.equals("1")){
                        outSab17.setText(nmJdw);
                    }
                    if (outSabtu18.equals("1")){
                        outSab18.setText(nmJdw);
                    }
                    if (outSabtu19.equals("1")){
                        outSab19.setText(nmJdw);
                    }
                    if (outSabtu20.equals("1")){
                        outSab20.setText(nmJdw);
                    }



                    if (outMinggu7.equals("1")){
                        outMing7.setText(nmJdw);
                    }
                    if (outMinggu8.equals("1")){
                        outMing8.setText(nmJdw);
                    }
                    if (outMinggu9.equals("1")){
                        outMing9.setText(nmJdw);
                    }
                    if (outMinggu10.equals("1")){
                        outMing10.setText(nmJdw);
                    }
                    if (outMinggu11.equals("1")){
                        outMing11.setText(nmJdw);
                    }
                    if (outMinggu12.equals("1")){
                        outMing12.setText(nmJdw);
                    }
                    if (outMinggu13.equals("1")){
                        outMing13.setText(nmJdw);
                    }
                    if (outMinggu14.equals("1")){
                        outMing14.setText(nmJdw);
                    }
                    if (outMinggu15.equals("1")){
                        outMing15.setText(nmJdw);
                    }
                    if (outMinggu16.equals("1")){
                        outMing16.setText(nmJdw);
                    }
                    if (outMinggu17.equals("1")){
                        outMing17.setText(nmJdw);
                    }
                    if (outMinggu18.equals("1")){
                        outMing18.setText(nmJdw);
                    }
                    if (outMinggu19.equals("1")){
                        outMing19.setText(nmJdw);
                    }
                    if (outMinggu20.equals("1")){
                        outMing20.setText(nmJdw);
                    }


                }

            }
        });

        */
        btnInputJadwalLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(weekly_schedule_trainer.this, input_weekly_schedule.class);
                startActivity(i);
            }
        });

    }
}