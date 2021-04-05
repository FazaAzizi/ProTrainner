package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText etEmail;
    ImageView ab;
    Button acc;
    TextView tvAkun;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        mAuth = FirebaseAuth.getInstance();

        etEmail = (EditText)findViewById(R.id.input_email_fp);
        acc = (Button)findViewById(R.id.button_acc_fp);
        tvAkun = (TextView)findViewById(R.id.have_acc_fp);
        ab = (ImageView)findViewById(R.id.ab_forgotpassword);

        acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String eml = etEmail.getText().toString().trim();
                if (eml.isEmpty()){
                    Toast.makeText(ForgotPasswordActivity.this,"Please enter your email",Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.sendPasswordResetEmail(eml).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ForgotPasswordActivity.this,"Password reset email sent",Toast.LENGTH_SHORT).show();
                                finish();
                                Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(ForgotPasswordActivity.this,"Error in sending password reset!",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        tvAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgotPasswordActivity.this,LoginActivity.class);
                startActivity(intent);
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
        super.onBackPressed();
        Intent intent = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}