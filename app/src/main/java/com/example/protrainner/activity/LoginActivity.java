package com.example.protrainner.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {


    FloatingActionButton google;
    float v=0;

    EditText inp_email;
    TextInputLayout lyttext;
    EditText inp_password;
    TextView forgetpass, textView;
    Button button;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        inp_email =findViewById(R.id.email);
        inp_password =findViewById(R.id.pass);
        lyttext =findViewById(R.id.passlyt);
        forgetpass = findViewById(R.id.forgetpass);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.create_acc_member);


        textView.setTranslationX(800);
        textView.setAlpha(v);
        textView.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();


        inp_email.setTranslationX(800);
        lyttext.setTranslationX(800);
        forgetpass.setTranslationX(800);
        button.setTranslationX(800);
        //google.setTranslationX(800);

        inp_email.setAlpha(v);
        lyttext.setAlpha(v);
        forgetpass.setAlpha(v);
        button.setAlpha(v);
        //google.setAlpha(v);

        //google.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        inp_email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        lyttext.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        forgetpass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        button.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(myIntent);
            }
        });

        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(myIntent);
            }
        });

//        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser mFirebaseUser = mAuth.getCurrentUser();
//                if(mFirebaseUser !=null){
////                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
//                }
//            }
//        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inp_email.getText().toString();
                String pass = inp_password.getText().toString();

                if(email.isEmpty()){
                    inp_email.setError("Please enter your email");
                }
                else if(pass.isEmpty()){
                    inp_password.setError("Please enter your password");
                }

                else if(!(email.isEmpty() &&  pass.isEmpty() )){
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login Succesfull",Toast.LENGTH_SHORT).show();
                                checkIfMember(mAuth.getCurrentUser().getUid());
                            }
                        }
                    });



//                    mAuth.signInWithEmailAndPassword(email,pass).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
//                        @Override
//                        public void onSuccess(AuthResult authResult) {
//                            Toast.makeText(LoginActivity.this,"Login Succesfull",Toast.LENGTH_SHORT).show();
//                            checkIfMember(authResult.getUser().getUid());
//
//                        }
//                    }).addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                        }
//                    });

                    //mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(!task.isSuccessful()){
//                                Toast.makeText(getActivity(),"Login error! coba lagi",Toast.LENGTH_SHORT).show();
//                            }
//                            else {
//                                Toast.makeText(getActivity(),"Login Succesfull",Toast.LENGTH_SHORT).show();
//                                checkIfMember(task.getUser().getUid());
//                                Intent inthome =new Intent(getActivity(),MainActivity.class);
//                                startActivity(inthome);
//                            }
//                        }
//                    });
                }
            }
        });
    }

    public void onBackPressed() {
        //do nothing
    }



    private void checkIfMember(String uid) {
        DocumentReference df = fStore.collection("Akun").document(uid);
        df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Log.d("TAG","onSucces : "+ documentSnapshot.getData());
                if(documentSnapshot.getString("isMember").equals("0")){
                    Intent inthome =new Intent(LoginActivity.this, HomeTrainerActivity.class);
                    startActivity(inthome);
                }
                if(documentSnapshot.getString("isMember").equals("1")){
                    Intent inthome =new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(inthome);
                }
            }
        });
    }



}