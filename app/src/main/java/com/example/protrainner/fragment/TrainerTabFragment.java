package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.protrainner.R;
import com.example.protrainner.activity.RegisterMemberActivity;
import com.example.protrainner.activity.RegisterTrainerActivity;

public class TrainerTabFragment extends Fragment {

    EditText email, name,password,confpass;
    TextView textView;
    Button button;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.trainer_tab_fag, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.pass);
        confpass = root.findViewById(R.id.conf_pass);
        name = root.findViewById(R.id.name);
        button = root.findViewById(R.id.button);

        textView = root.findViewById(R.id.create_acc_trainer);

        textView.setTranslationX(800);
        textView.setAlpha(v);
        textView.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(800).start();

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), RegisterTrainerActivity.class);
                startActivity(myIntent);
            }
        });


        email.setTranslationX(800);
        name.setTranslationX(800);
        password.setTranslationX(800);
        confpass.setTranslationX(800);
        button.setTranslationX(800);

        email.setAlpha(v);
        name.setAlpha(v);
        password.setAlpha(v);
        confpass.setAlpha(v);
        button.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(200).start();
        name.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        confpass.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        button.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return root;
    }
}
