package com.example.protrainner.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.protrainner.R;

public class FtlTrainerActivity extends AppCompatActivity {

    String id, nama;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftl_trainer);

        tv1 = findViewById(R.id.ftl_out_nama);

        Bundle b = getIntent().getExtras();
        nama = b.getString("nama");
        id = b.getString("id");

        tv1.setText(nama);
    }
}