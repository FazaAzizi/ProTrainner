package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.BP;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListBPAdapter extends FirestoreRecyclerAdapter<BP, ListBPAdapter.ListBPHolder> {
    public ListBPAdapter(@NonNull FirestoreRecyclerOptions<BP> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListBPAdapter.ListBPHolder listBPHolder, int i, @NonNull BP listBP) {
        listBPHolder.tvno.setText(listBP.getNo());
        listBPHolder.tvmn.setText(listBP.getMembername());
        listBPHolder.tvpn.setText(listBP.getPhonenumber());
        listBPHolder.tvg.setText(listBP.getGoal());
        listBPHolder.tvp.setText(listBP.getPpackage());
        listBPHolder.tvspw.setText(listBP.getSessionperweek());
        listBPHolder.tvb.setText(listBP.getBalance());
        listBPHolder.tved.setText(listBP.getExpireddate());
        listBPHolder.tvnp.setText(listBP.getNewpackage());
        listBPHolder.tvr.setText(listBP.getRenewal());
        listBPHolder.tvpsp.setText(listBP.getPackagesaleprice());
    }

    @NonNull
    @Override
    public ListBPAdapter.ListBPHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_businessplan
                , parent, false);
        return new ListBPAdapter.ListBPHolder(v);
    }

    class ListBPHolder extends RecyclerView.ViewHolder{
        TextView tvno,tvmn,tvpn,tvg,tvp,tvspw,tvb,tved,tvnp,tvr,tvpsp;

        public ListBPHolder( View itemView) {
            super(itemView);
            tvno= (TextView) itemView.findViewById(R.id.tb_bp_no);
            tvmn= (TextView) itemView.findViewById(R.id.tb_bp_mn);
            tvpn= (TextView) itemView.findViewById(R.id.tb_bp_pn);
            tvg= (TextView) itemView.findViewById(R.id.tb_bp_g);
            tvp= (TextView) itemView.findViewById(R.id.tb_bp_p);
            tvspw= (TextView) itemView.findViewById(R.id.tb_bp_spw);
            tvb= (TextView) itemView.findViewById(R.id.tb_bp_b);
            tved= (TextView) itemView.findViewById(R.id.tb_bp_ed);
            tvnp= (TextView) itemView.findViewById(R.id.tb_bp_np);
            tvr= (TextView) itemView.findViewById(R.id.tb_bp_r);
            tvpsp= (TextView) itemView.findViewById(R.id.tb_bp_psp);
        }
    }
}
