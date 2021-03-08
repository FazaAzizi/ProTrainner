package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.FTL;
import com.example.protrainner.model.Inti;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListIntiAdapter extends FirestoreRecyclerAdapter<Inti, ListIntiAdapter.ListIntiHolder> {
    public ListIntiAdapter(@NonNull FirestoreRecyclerOptions<Inti> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListIntiHolder listIntiHolder, int i, @NonNull Inti listInti) {
        listIntiHolder.tvIntiNo.setText(listInti.getNoInti());
        listIntiHolder.tvIntiJp.setText(listInti.getJenisInti());
        listIntiHolder.tvIntiLoad.setText(listInti.getLoadInti());
        listIntiHolder.tvIntiReps.setText(listInti.getRepsInti());
        listIntiHolder.tvIntiDurasi.setText(listInti.getDurasiInti());
        listIntiHolder.tvIntiSet.setText(listInti.getSetInti());
    }

    @NonNull
    @Override
    public ListIntiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_inti
                , parent, false);
        return new ListIntiHolder(v);
    }

    class ListIntiHolder extends RecyclerView.ViewHolder{
        TextView tvIntiNo,tvIntiJp,tvIntiLoad,tvIntiReps,tvIntiDurasi,tvIntiSet;

        public ListIntiHolder( View itemView) {
            super(itemView);
            tvIntiNo = (TextView) itemView.findViewById(R.id.inti_out_no);
            tvIntiJp= (TextView)itemView.findViewById(R.id.inti_out_jp);
            tvIntiLoad = (TextView)itemView.findViewById(R.id.inti_out_load);
            tvIntiReps = (TextView)itemView.findViewById(R.id.inti_out_reps);
            tvIntiDurasi = (TextView)itemView.findViewById(R.id.inti_out_durasi);
            tvIntiSet =(TextView) itemView.findViewById(R.id.inti_out_set);

        }

    }
}
