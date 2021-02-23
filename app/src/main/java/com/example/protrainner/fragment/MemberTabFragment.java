package com.example.protrainner.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.protrainner.R;

public class MemberTabFragment extends Fragment {

    EditText email, password;
    TextView forgetpass;
    Button button;
    float v=0;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.member_tab_frag, container, false);

        email = root.findViewById(R.id.email);
        password = root.findViewById(R.id.pass);
        forgetpass = root.findViewById(R.id.forgetpass);
        button = root.findViewById(R.id.button);


        email.setTranslationY(800);
        password.setTranslationY(800);
        forgetpass.setTranslationY(800);
        button.setTranslationY(800);

        email.setAlpha(v);
        password.setAlpha(v);
        forgetpass.setAlpha(v);
        button.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        forgetpass.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        button.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();


        return root;
    }
}
