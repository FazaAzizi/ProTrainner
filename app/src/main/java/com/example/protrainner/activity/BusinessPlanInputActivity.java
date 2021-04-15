package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.protrainner.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class BusinessPlanInputActivity extends AppCompatActivity {

    String id, nama;
    TextView tv1;
    ImageView ab,an;
    EditText etno,etmn,etpn,etg,etp,etspw,etb,eted,etnp,etr,etpsp;
    Button konfirmasi;
    String no,mn,pn,g,p,spw,bn,ed,np,r,psp;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_plan_input);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");
        id = b.getString("id");

        //tv1.setText(nama);
        etno = (EditText)findViewById(R.id.bp_no);
        etmn = (EditText)findViewById(R.id.bp_mn);
        etpn=(EditText)findViewById(R.id.bp_pn);
        etg= (EditText)findViewById(R.id.bp_g);
        etp= (EditText)findViewById(R.id.bp_p);
        etspw= (EditText)findViewById(R.id.bp_spw);
        etb= (EditText)findViewById(R.id.bp_b);
        eted= (EditText)findViewById(R.id.bp_ed);
        etnp= (EditText)findViewById(R.id.bp_np);
        etr= (EditText)findViewById(R.id.bp_renewal);
        etpsp= (EditText)findViewById(R.id.bp_psp);


        ab = findViewById(R.id.ab_bpinput);
        konfirmasi = findViewById(R.id.konfirmasi_bp);

        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no = etno.getText().toString();
                mn = etmn.getText().toString();
                pn= etpn.getText().toString();
                g= etg.getText().toString();
                p= etp.getText().toString();
                spw= etspw.getText().toString();
                bn= etb.getText().toString();
                ed= eted.getText().toString();
                np= etnp.getText().toString();
                r= etr.getText().toString();
                psp= etpsp.getText().toString();


                DocumentReference df = fStore.collection("Akun").document(id).
                        collection("BP").document(no);
                Map<String,Object> userinfo = new HashMap<>();
                userinfo.put("no", no);
                userinfo.put("membername", mn);
                userinfo.put("phonenumber", pn);
                userinfo.put("goal", g);
                userinfo.put("ppackage",p);
                userinfo.put("sessionperweek",spw);
                userinfo.put("balance",bn);
                userinfo.put("expireddate",ed);
                userinfo.put("newpackage",np);
                userinfo.put("renewal",r);
                userinfo.put("packagesaleprice",psp);
                df.set(userinfo);

                Bundle c = new Bundle();
                c.putString("id",id);
                c.putString("nama",nama);
                Intent inthome =new Intent(BusinessPlanInputActivity.this, BusinessPlanActivity.class);
                inthome.putExtras(c);
                startActivity(inthome);
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Bundle c = new Bundle();
        c.putString("nama",nama);
        c.putString("id",id);
        Intent intent = new Intent(BusinessPlanInputActivity.this, BusinessPlanActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}