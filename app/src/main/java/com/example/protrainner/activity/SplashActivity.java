package com.example.protrainner.activity;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.protrainner.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SplashActivity extends AppCompatActivity {


    TextView textView1,textView2;
    ImageView imageView;
    String cek,id,day,ubah;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        cek = new String("2");
        ubah = new String("1");

        textView2 = findViewById(R.id.jdl2);

        imageView = findViewById(R.id.gmbrdepan);

        //textView2.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade));
        //imageView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.fade));

        Window window = getWindow();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);

        Thread thread = new Thread(){

            public void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    if (cek.equals("0")){
                        Intent inthome =new Intent(SplashActivity.this, HomeTrainerActivity.class);
                        startActivity(inthome);
                    }
                    if (cek.equals("1")){
                        Bundle b = new Bundle();
                        b.putString("id",id);
                        Intent inthome =new Intent(SplashActivity.this, MainActivity.class);
                        inthome.putExtras(b);
                        startActivity(inthome);
                    }
                    if (cek.equals("2")){
                        Intent i = new Intent(SplashActivity.this, WelcomeActivity.class);
                        startActivity(i);
                    }
//                    else{
//                        Intent i = new Intent(SplashActivity.this, LoginActivity.class);
//                        startActivity(i);
//                    }
//                    if(day.equals("Rabu")||day.equals("Wednesday")){
//                        DocumentReference df1 = fStore.collection("Jadwal").document("cek");
//                        df1.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                            @Override
//                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                                ubah = task.getResult().getString("ubah");
//                                if(ubah.equals("0")){
//                                    DocumentReference df = fStore.collection("Jadwal").document("senin");
//                                    Map<String, Object> userinfo = new HashMap<>();
//                                    userinfo.put("senin7", "");
//                                    userinfo.put("senin8", "");
//                                    userinfo.put("senin9", "");
//                                    userinfo.put("senin10", "");
//                                    userinfo.put("senin11", "");
//                                    userinfo.put("senin12", "");
//                                    userinfo.put("senin13", "");
//                                    userinfo.put("senin14", "");
//                                    userinfo.put("senin15", "");
//                                    userinfo.put("senin16", "");
//                                    userinfo.put("senin17", "");
//                                    userinfo.put("senin18", "");
//                                    userinfo.put("senin19", "");
//                                    userinfo.put("senin20", "");
//                                    df.update(userinfo);
//                                    ubah = new String("1");
//                                    Map<String, Object> ubahcek = new HashMap<>();
//                                    ubahcek.put("ubah",ubah);
//                                    df1.update(ubahcek);
//                                }
//                            }
//                        });
//
//                    }
//                    if(day.equals("Kamis")||day.equals("Thursday")){
//                        DocumentReference df1 = fStore.collection("Jadwal").document("cek");
//                        Map<String, Object> ubahcek = new HashMap<>();
//                        ubahcek.put("ubah","0");
//                        df1.update(ubahcek);
//                    }
                    finish();
                }
            }
        };
        thread.start();

    }




    @Override
    protected void onStart() {
        super.onStart();
//        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
//        Date d = new Date();
//        day = sdf.format(d);
//        Log.d("TAG","onSucces : "+ day);


        if (FirebaseAuth.getInstance().getCurrentUser()!=null){
            DocumentReference df = FirebaseFirestore.getInstance().collection("Akun").document(FirebaseAuth.getInstance().getCurrentUser().getUid());
            df.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {

                @Override
                public void onSuccess(DocumentSnapshot documentSnapshot) {
                    if(documentSnapshot.getString("isMember").equals("0")){
                        cek = new String("0");

                    }
                    if(documentSnapshot.getString("isMember").equals("1")){
                        cek = new String("1");
                        id = documentSnapshot.getId();

                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    FirebaseAuth.getInstance().signOut();
                    cek = new String("2");

                }
            });
        }
        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            cek = new String("2");
        }
    }
}
