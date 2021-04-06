package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Text;

public class weekly_schedule_member extends AppCompatActivity {

    String uid, nm;
    TextView namaJadwal;
    ImageView ab;
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
        setContentView(R.layout.activity_weekly_schedule_member);

//        Bundle b = getIntent().getExtras();
//        nm = b.getString("nama");

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        ab = (ImageView) findViewById(R.id.ab_wsmember);
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

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        DocumentReference df = fStore.collection("Jadwal").document("senin");
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()) {
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

                    outSen7.setText(outSenin7);
                    outSen8.setText(outSenin8);
                    outSen9.setText(outSenin9);
                    outSen10.setText(outSenin10);
                    outSen11.setText(outSenin11);
                    outSen12.setText(outSenin12);
                    outSen13.setText(outSenin13);
                    outSen14.setText(outSenin14);
                    outSen15.setText(outSenin15);
                    outSen16.setText(outSenin16);
                    outSen17.setText(outSenin17);
                    outSen18.setText(outSenin18);
                    outSen19.setText(outSenin19);
                    outSen20.setText(outSenin20);
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

                outSel7.setText(outSelasa7);
                outSel8.setText(outSelasa8);
                outSel9.setText(outSelasa9);
                outSel10.setText(outSelasa10);
                outSel11.setText(outSelasa11);
                outSel12.setText(outSelasa12);
                outSel13.setText(outSelasa13);
                outSel14.setText(outSelasa14);
                outSel15.setText(outSelasa15);
                outSel16.setText(outSelasa16);
                outSel17.setText(outSelasa17);
                outSel18.setText(outSelasa18);
                outSel19.setText(outSelasa19);
                outSel20.setText(outSelasa20);

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

                outRab7.setText(outRabu7);
                outRab8.setText(outRabu8);
                outRab9.setText(outRabu9);
                outRab10.setText(outRabu10);
                outRab11.setText(outRabu11);
                outRab12.setText(outRabu12);
                outRab13.setText(outRabu13);
                outRab14.setText(outRabu14);
                outRab15.setText(outRabu15);
                outRab16.setText(outRabu16);
                outRab17.setText(outRabu17);
                outRab18.setText(outRabu18);
                outRab19.setText(outRabu19);
                outRab20.setText(outRabu20);


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

                outKam7.setText(outKamis7);
                outKam8.setText(outKamis8);
                outKam9.setText(outKamis9);
                outKam10.setText(outKamis10);
                outKam11.setText(outKamis11);
                outKam12.setText(outKamis12);
                outKam13.setText(outKamis13);
                outKam14.setText(outKamis14);
                outKam15.setText(outKamis15);
                outKam16.setText(outKamis16);
                outKam17.setText(outKamis17);
                outKam18.setText(outKamis18);
                outKam19.setText(outKamis19);
                outKam20.setText(outKamis20);
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

                outJum7.setText(outJumat7);
                outJum8.setText(outJumat8);
                outJum9.setText(outJumat9);
                outJum10.setText(outJumat10);
                outJum11.setText(outJumat11);
                outJum12.setText(outJumat12);
                outJum13.setText(outJumat13);
                outJum14.setText(outJumat14);
                outJum15.setText(outJumat15);
                outJum16.setText(outJumat16);
                outJum17.setText(outJumat17);
                outJum18.setText(outJumat18);
                outJum19.setText(outJumat19);
                outJum20.setText(outJumat20);
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

                outSab7.setText(outSabtu7);
                outSab8.setText(outSabtu8);
                outSab9.setText(outSabtu9);
                outSab10.setText(outSabtu10);
                outSab11.setText(outSabtu11);
                outSab12.setText(outSabtu12);
                outSab13.setText(outSabtu13);
                outSab14.setText(outSabtu14);
                outSab15.setText(outSabtu15);
                outSab16.setText(outSabtu16);
                outSab17.setText(outSabtu17);
                outSab18.setText(outSabtu18);
                outSab19.setText(outSabtu19);
                outSab20.setText(outSabtu20);
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

                outMing7.setText(outMinggu7);
                outMing8.setText(outMinggu8);
                outMing9.setText(outMinggu9);
                outMing10.setText(outMinggu10);
                outMing11.setText(outMinggu11);
                outMing12.setText(outMinggu12);
                outMing13.setText(outMinggu13);
                outMing14.setText(outMinggu14);
                outMing15.setText(outMinggu15);
                outMing16.setText(outMinggu16);
                outMing17.setText(outMinggu17);
                outMing18.setText(outMinggu18);
                outMing19.setText(outMinggu19);
                outMing20.setText(outMinggu20);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(weekly_schedule_member.this, MainActivity.class);
        startActivity(intent);
    }
}








































