package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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

public class MemberPengukuranDetailActivity extends AppCompatActivity {

    TextView tvnama,tvbb,tvtb,tvbf,tvbmi,tvvf,tvba,tvll,tvld,tvlgang,tvlgul,tvlp,tvlb;
    String id,nama,tanggal,bb,tb,bf,bmi,vf,ba,ll,ld,lgang,lgul,lp,lb;
    FirebaseAuth mAuth;
    AlertDialog.Builder dialogBuilder;
    AlertDialog dial;
    FirebaseFirestore fStore = FirebaseFirestore.getInstance();
    ImageView ab,ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_pengukuran_detail2);
        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        tvnama = (TextView)findViewById(R.id.tv_memberpengukurandetail_nama);
        tvbb =(TextView) findViewById(R.id.tv_out_bb);
        tvtb =(TextView) findViewById(R.id.tv_out_tb);

        ab = findViewById(R.id.ab_memberpengukurandetail);
        Bundle b = getIntent().getExtras();
        tanggal = b.getString("tgl");
        nama = b.getString("nama");
        id = b.getString("id");

        ad = (ImageView) findViewById(R.id.popup_detailmember);

        DocumentReference df1 = fStore.collection("Akun").document(id);
        df1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                String name = task.getResult().getString("namalengkap");
                tvnama.setText(name);
            }
        });

        DocumentReference df = fStore.collection("Akun").document(id).collection("Pengukuran").document(tanggal);
        df.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    bb = task.getResult().getString("bb");
                    tb = task.getResult().getString("tb");
                    bf = task.getResult().getString("bf");
                    bmi = task.getResult().getString("bmi");
                    vf = task.getResult().getString("vf");
                    ba = task.getResult().getString("ba");
                    ll = task.getResult().getString("ll");
                    ld = task.getResult().getString("ld");
                    lgang = task.getResult().getString("lgang");
                    lgul = task.getResult().getString("lgul");
                    lp = task.getResult().getString("lp");
                    lb = task.getResult().getString("lb");

                    //tvnama.setText(nama);
                    tvbb.setText(bb);
                    tvtb.setText(tb);
                }
            }
        });
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createContactDialog();
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public  void  createContactDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.pop_up_du,null);

        tvbf = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_bf);
        tvbmi = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_bmi);
        tvvf = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_vf);
        tvba = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_ba);
        tvll = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_ll);
        tvld = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_ld);
        tvlgang = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_lgang);
        tvlgul = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_lgul);
        tvlp = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_lp);
        tvlb = (TextView) contactPopupView.findViewById(R.id.tv_out_pd_lb);

        tvbf.setText(bf);
        tvbmi.setText(bmi);
        tvvf.setText(vf);
        tvba.setText(ba);
        tvll.setText(ll);
        tvld.setText(ld);
        tvlgang.setText(lgang);
        tvlgul.setText(lgul);
        tvlp.setText(lp);
        tvlb.setText(lb);

        dialogBuilder.setView(contactPopupView);
        dial = dialogBuilder.create();
        dial.show();
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",id);
        Intent intent = new Intent(MemberPengukuranDetailActivity.this, MemberPengukuranActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}