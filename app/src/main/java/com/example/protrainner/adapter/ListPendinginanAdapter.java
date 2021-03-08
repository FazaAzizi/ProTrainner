package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Pemanasan;
import com.example.protrainner.model.Pendinginan;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListPendinginanAdapter extends FirestoreRecyclerAdapter<Pendinginan, ListPendinginanAdapter.ListPendinginanHolder> {

    public ListPendinginanAdapter(@NonNull FirestoreRecyclerOptions<Pendinginan> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListPendinginanAdapter.ListPendinginanHolder listPendinginanHolder, int i, @NonNull Pendinginan listPendinginan) {
        listPendinginanHolder.tvPendinginanNo.setText(listPendinginan.getNoPendinginan());
        listPendinginanHolder.tvPendinginanJp.setText(listPendinginan.getJenisPendinginan());
        listPendinginanHolder.tvPendinginanReps.setText(listPendinginan.getRepsPendinginan());
        listPendinginanHolder.tvPendinginanDurasi.setText(listPendinginan.getDurasiPendinginan());
    }

    @NonNull
    @Override
    public ListPendinginanAdapter.ListPendinginanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pendinginan
                , parent, false);
        return new ListPendinginanAdapter.ListPendinginanHolder(v);
    }

    class ListPendinginanHolder extends RecyclerView.ViewHolder{
        TextView tvPendinginanNo,tvPendinginanJp,tvPendinginanReps,tvPendinginanDurasi;

        public ListPendinginanHolder( View itemView) {
            super(itemView);
            tvPendinginanNo = itemView.findViewById(R.id.pendinginan_out_no);
            tvPendinginanJp= itemView.findViewById(R.id.pendinginan_out_jp);
            tvPendinginanReps = itemView.findViewById(R.id.pendinginan_out_reps);
            tvPendinginanDurasi = itemView.findViewById(R.id.pendinginan_out_durasi);

        }

    }
}
