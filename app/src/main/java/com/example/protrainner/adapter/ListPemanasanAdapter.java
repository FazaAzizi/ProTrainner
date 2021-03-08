package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Inti;
import com.example.protrainner.model.Pemanasan;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListPemanasanAdapter extends FirestoreRecyclerAdapter<Pemanasan, ListPemanasanAdapter.ListPemanasanHolder> {
    public ListPemanasanAdapter(@NonNull FirestoreRecyclerOptions<Pemanasan> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListPemanasanAdapter.ListPemanasanHolder listPemanasanHolder, int i, @NonNull Pemanasan listPemanasan) {
        listPemanasanHolder.tvPemanasanNo.setText(listPemanasan.getNoPemanasan());
        listPemanasanHolder.tvPemanasanJp.setText(listPemanasan.getJenisPemanasan());
        listPemanasanHolder.tvPemanasanReps.setText(listPemanasan.getRepsPemanasan());
        listPemanasanHolder.tvPemanasanDurasi.setText(listPemanasan.getDurasiPemanasan());
    }

    @NonNull
    @Override
    public ListPemanasanAdapter.ListPemanasanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pemanasan
                , parent, false);
        return new ListPemanasanAdapter.ListPemanasanHolder(v);
    }

    class ListPemanasanHolder extends RecyclerView.ViewHolder{
        TextView tvPemanasanNo,tvPemanasanJp,tvPemanasanReps,tvPemanasanDurasi;

        public ListPemanasanHolder( View itemView) {
            super(itemView);
            tvPemanasanNo = itemView.findViewById(R.id.pemanasan_out_no);
            tvPemanasanJp= itemView.findViewById(R.id.pemanasan_out_jp);
            tvPemanasanReps = itemView.findViewById(R.id.pemanasan_out_reps);
            tvPemanasanDurasi = itemView.findViewById(R.id.pemanasan_out_durasi);

        }

    }

}
