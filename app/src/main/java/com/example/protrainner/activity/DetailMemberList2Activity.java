package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.protrainner.R;

public class DetailMemberList2Activity extends AppCompatActivity {

    ImageView ab;
    public String nama,id;
    CardView cvFTL,cvDataUkur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_member_list2);

        ab = findViewById(R.id.ab_memberlist2);
        cvFTL = findViewById(R.id.cv_ftl_dml);
        cvDataUkur = findViewById(R.id.cv_du_dml);

        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");
        id = b.getString("id");


//        btFtl.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle c = new Bundle();
//                c.putString("nama",nm);
//                c.putString("id",uid);
//                Intent intent = new Intent(DetailMemberListActivity.this, FtlTrainer1Activity.class);
//                intent.putExtras(c);
//                startActivity(intent);
//            }
//        });

        cvFTL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle c = new Bundle();
                c.putString("nama",nama);
                c.putString("id",id);
                Intent intent = new Intent(DetailMemberList2Activity.this, OutFtlActivity.class);
                intent.putExtras(c);
                startActivity(intent);
            }
        });

        cvDataUkur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        c.putString("UID",id);
        Intent intent = new Intent(DetailMemberList2Activity.this, DetailMemberListActivity.class);
        intent.putExtras(c);
        startActivity(intent);
    }
}