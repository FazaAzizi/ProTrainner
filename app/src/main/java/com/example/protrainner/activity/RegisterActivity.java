package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.example.protrainner.model.Akun;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity{

    EditText inpt_email, inpt_name, inpt_pass, inpt_conf_pass;
    Button button;
    TextView textView,textView2;
    TextInputLayout lyttext1,lyttext2;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    CheckBox cb1,cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        lyttext1 = findViewById(R.id.passlyt1);
        lyttext2 = findViewById(R.id.passlyt2);
        inpt_email= findViewById(R.id.input_email);
        inpt_name= findViewById(R.id.input_name);
        inpt_pass= findViewById(R.id.input_pass);
        inpt_conf_pass= findViewById(R.id.input_conf_pass);
        button= findViewById(R.id.button_acc);
        textView= findViewById(R.id.have_acc);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    cb2.setChecked(false);
                }
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()){
                    cb1.setChecked(false);
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(myIntent);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!(cb1.isChecked()||cb2.isChecked())){
                    Toast.makeText(RegisterActivity.this,"Pilih jenis daftar",Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = inpt_email.getText().toString();
                String name = inpt_name.getText().toString();
                String pass = inpt_pass.getText().toString();
                String conf_pass = inpt_conf_pass.getText().toString();
                final String[] member = new String[1];

                if(email.isEmpty()){
                    inpt_email.setError("Please enter your email");
                }
                else if(name.isEmpty()){
                    inpt_name.setError("Please enter your full name");
                }
                else if(pass.isEmpty()){
                    inpt_pass.setError("Please enter your password");
                }
                else if(pass.length()<7){
                    inpt_pass.setError("Password must be 7 character");
                }
                else if(conf_pass.isEmpty()){
                    inpt_conf_pass.setError("Please enter your confirmation password");
                }
                else if(!conf_pass.equals(pass)){
                    inpt_conf_pass.setError("Password not match!");
                }
                else if(!(email.isEmpty() && name.isEmpty() && pass.isEmpty() && conf_pass.isEmpty() )){
                    mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this,"Daftar member gagal! Coba lagi",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                FirebaseUser user = mAuth.getCurrentUser();
                                DocumentReference df = fStore.collection("Akun").document(user.getUid());
                                Map<String,Object> userinfo = new HashMap<>();
                                userinfo.put("fullname",name);
                                userinfo.put("email",email);
                                if(cb1.isChecked()){
                                    userinfo.put("isMember","1");
                                    userinfo.put("isConnected","0");
                                    userinfo.put("isWaiting","0");
                                    userinfo.put("nameConnected","");
                                    userinfo.put("nameWaiting","");
                                }
                                if(cb2.isChecked()){
                                    userinfo.put("isMember","0");
                                }
                                df.set(userinfo);
                                if(cb1.isChecked()){
                                    Intent inthome =new Intent(RegisterActivity.this, FormMemberActivity.class);
                                    startActivity(inthome);
                                }
                                if(cb2.isChecked()){
                                    Intent inthome =new Intent(RegisterActivity.this, FormTrainerActivity.class);
                                    startActivity(inthome);
                                }

                                Toast.makeText(RegisterActivity.this,"Create Account Succesfull",Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }

            }
        });
    }



}