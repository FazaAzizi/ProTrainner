package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Data;
import com.example.protrainner.model.Pengukuran;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListPengukuranAdapter extends FirestoreRecyclerAdapter<Pengukuran, ListPengukuranAdapter.ListPengukuranHolder> {
    private ListPengukuranAdapter.OnItemClickListener listener;

    public ListPengukuranAdapter(@NonNull FirestoreRecyclerOptions<Pengukuran> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListPengukuranAdapter.ListPengukuranHolder listPengukuranHolder, int i, @NonNull Pengukuran listPengukuran) {
        listPengukuranHolder.tvTgl.setText(listPengukuran.getTanggal());
    }

    @NonNull
    @Override
    public ListPengukuranAdapter.ListPengukuranHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pengukuran
                , parent, false);
        return new ListPengukuranAdapter.ListPengukuranHolder(v);
    }

    class ListPengukuranHolder extends RecyclerView.ViewHolder{
        TextView tvTgl;


        public ListPengukuranHolder( View itemView) {
            super(itemView);
            tvTgl = itemView.findViewById(R.id.list_pengukuran_tv);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemClick(getSnapshots().getSnapshot(position), position);
                    }
                }
            });
        }

    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot dS, int position);
    }
    public void setOnItemClickListener(ListPengukuranAdapter.OnItemClickListener listener){
        this.listener=listener;
    }
}
