package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.protrainner.R;
import com.example.protrainner.fragment.settingMemberFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditDataParQMemberActivity extends AppCompatActivity {

    Button accperubahan;
    CheckBox ya1, td1, ya2, td2, ya3, td3, ya4, td4, ya5, td5, ya6, td6, ya7, td7;
    ImageView ab;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_par_q_member);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userId =mAuth.getCurrentUser().getUid();

        accperubahan = findViewById(R.id.konfirmasi);

        ya1 = findViewById(R.id.y1);
        td1 = findViewById(R.id.t1);
        ya2 = findViewById(R.id.y2);
        td2 = findViewById(R.id.t2);
        ya3 = findViewById(R.id.y3);
        td3 = findViewById(R.id.t3);
        ya4 = findViewById(R.id.y4);
        td4 = findViewById(R.id.t4);
        ya5 = findViewById(R.id.y5);
        td5 = findViewById(R.id.t5);
        ya6 = findViewById(R.id.y6);
        td6 = findViewById(R.id.t6);
        ya7 = findViewById(R.id.y7);
        td7 = findViewById(R.id.t7);
        ab = (ImageView)findViewById(R.id.ab_editdataparq);


        checkbutton();
        DocumentReference df2 = fStore.collection("Akun").document(userId).collection("Data").document(userId);
        df2.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.getResult().exists()){
                    String batuk = task.getResult().getString("batuk");
                    String cacat = task.getResult().getString("cacat");
                    String cedera = task.getResult().getString("cedera");
                    String dada = task.getResult().getString("dada");
                    String rokok = task.getResult().getString("rokok");
                    String sendi = task.getResult().getString("sendi");
                    String tidur = task.getResult().getString("tidur");

                    if(batuk.equals("1")){
                        ya1.setChecked(true);
                        td1.setChecked(false);
                    }
                    if(batuk.equals("0")){
                        ya1.setChecked(false);
                        td1.setChecked(true);
                    }
                    if(sendi.equals("1")){
                        ya2.setChecked(true);
                        td2.setChecked(false);
                    }
                    if(sendi.equals("0")){
                        ya2.setChecked(false);
                        td2.setChecked(true);
                    }
                    if(dada.equals("1")){
                        ya3.setChecked(true);
                        td3.setChecked(false);
                    }
                    if(dada.equals("0")){
                        ya3.setChecked(false);
                        td3.setChecked(true);
                    }
                    if(cedera.equals("1")){
                        ya4.setChecked(true);
                        td4.setChecked(false);
                    }
                    if(cedera.equals("0")){
                        ya4.setChecked(false);
                        td4.setChecked(true);
                    }
                    if(cacat.equals("1")){
                        ya5.setChecked(true);
                        td5.setChecked(false);
                    }
                    if(cacat.equals("0")){
                        ya5.setChecked(false);
                        td5.setChecked(true);
                    }
                    if(rokok.equals("1")){
                        ya6.setChecked(true);
                        td6.setChecked(false);
                    }
                    if(rokok.equals("0")){
                        ya6.setChecked(false);
                        td6.setChecked(true);
                    }
                    if(tidur.equals("1")){
                        ya7.setChecked(true);
                        td7.setChecked(false);
                    }
                    if(tidur.equals("0")){
                        ya7.setChecked(false);
                        td7.setChecked(true);
                    }
                }
            }
        });

        accperubahan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference df1 = fStore.collection("Akun").document(userId)
                        .collection("Data").document(userId);
                Map<String,Object> userinfo1 = new HashMap<>();
                if (ya1.isChecked()){
                    userinfo1.put("dada","1");
                }
                if (td1.isChecked()){
                    userinfo1.put("dada","0");
                }
                if (ya2.isChecked()){
                    userinfo1.put("batuk","1");
                }
                if (td2.isChecked()){
                    userinfo1.put("batuk","0");
                }
                if (ya3.isChecked()){
                    userinfo1.put("sendi","1");
                }
                if (td3.isChecked()){
                    userinfo1.put("sendi","0");
                }
                if (ya4.isChecked()){
                    userinfo1.put("cedera","1");
                }
                if (td4.isChecked()){
                    userinfo1.put("cedera","0");
                }
                if (ya5.isChecked()){
                    userinfo1.put("cacat","1");
                }
                if (td5.isChecked()){
                    userinfo1.put("cacat","0");
                }
                if (ya6.isChecked()){
                    userinfo1.put("rokok","1");
                }
                if (td6.isChecked()){
                    userinfo1.put("rokok","0");
                }
                if (ya7.isChecked()){
                    userinfo1.put("tidur","1");
                }
                if (td7.isChecked()){
                    userinfo1.put("tidur","0");
                }
                df1.update(userinfo1);
                Intent inthome =new Intent(EditDataParQMemberActivity.this, MainActivity.class);
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

    private void checkbutton(){
        ya1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td1.setChecked(false);
                }
            }
        });

        td1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya1.setChecked(false);
                }
            }
        });
        ya2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td2.setChecked(false);
                }
            }
        });

        td2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya2.setChecked(false);
                }
            }
        });
        ya3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td3.setChecked(false);
                }
            }
        });

        td3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya3.setChecked(false);
                }
            }
        });
        ya4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td4.setChecked(false);
                }
            }
        });

        td4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya4.setChecked(false);
                }
            }
        });
        ya5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td5.setChecked(false);
                }
            }
        });


        td5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya5.setChecked(false);
                }
            }
        });
        ya6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td6.setChecked(false);
                }
            }
        });


        td6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya6.setChecked(false);
                }
            }
        });
        ya7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    td7.setChecked(false);
                }
            }
        });

        td7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    ya7.setChecked(false);
                }
            }
        });

    }

    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(EditDataParQMemberActivity.this, MainActivity.class);
        startActivity(intent);
    }
}