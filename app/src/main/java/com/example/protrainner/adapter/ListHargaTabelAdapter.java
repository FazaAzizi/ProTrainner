package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Harga;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListHargaTabelAdapter extends FirestoreRecyclerAdapter<Harga, ListHargaTabelAdapter.ListHargaTabelHolder> {
    public ListHargaTabelAdapter(@NonNull FirestoreRecyclerOptions<Harga> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListHargaTabelAdapter.ListHargaTabelHolder listHargaTabelHolder, int i, @NonNull Harga listHarga) {
        listHargaTabelHolder.tvPlnP.setText(listHarga.getNoPaket());
        listHargaTabelHolder.tvPldL.setText(listHarga.getDurasiLatihan());
        listHargaTabelHolder.tvPlharga.setText(listHarga.getHarga());
    }

    @NonNull
    @Override
    public ListHargaTabelAdapter.ListHargaTabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_harga_tabel
                , parent, false);
        return new ListHargaTabelAdapter.ListHargaTabelHolder(v);
    }

    class ListHargaTabelHolder extends RecyclerView.ViewHolder{
        TextView tvPlnP,tvPldL,tvPlharga;

        public ListHargaTabelHolder( View itemView) {
            super(itemView);
            tvPlnP = (TextView) itemView.findViewById(R.id.tv_table_noPaket);
            tvPldL= (TextView)itemView.findViewById(R.id.tv_table_durasi);
            tvPlharga = (TextView)itemView.findViewById(R.id.tv_table_harga);
        }

    }

}
