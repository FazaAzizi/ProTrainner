package com.example.protrainner.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.protrainner.PermintaanActivity;
import com.example.protrainner.activity.EditDataMemberActivity;
import com.example.protrainner.R;
import com.example.protrainner.activity.EditDataParQMemberActivity;
import com.example.protrainner.activity.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class settingMemberFragment extends Fragment {
    Button logout,editDataDiri,editDataParQ;
    CardView cv1,cv2,cv3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_member, container, false);


//        editDataDiri = (Button) view.findViewById(R.id.btn_edit_data_diri);
//        editDataParQ = (Button) view.findViewById(R.id.btn_edit_data_parq);
        cv1 = (CardView)view.findViewById(R.id.cardView2);
        cv2 = (CardView)view.findViewById(R.id.cardView3);
        cv3 = (CardView)view.findViewById(R.id.cardView4);
        logout = (Button) view.findViewById(R.id.logout);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditDataMemberActivity.class);
                startActivity(i);
            }
        });
        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EditDataParQMemberActivity.class);
                startActivity(i);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), PermintaanActivity.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });





        return view;



    }
}
