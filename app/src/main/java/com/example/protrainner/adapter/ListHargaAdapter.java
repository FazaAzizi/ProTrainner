package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Harga;
import com.example.protrainner.model.Inti;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class ListHargaAdapter extends FirestoreRecyclerAdapter<Harga, ListHargaAdapter.ListHargaHolder> {
    public ListHargaAdapter(@NonNull FirestoreRecyclerOptions<Harga> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListHargaAdapter.ListHargaHolder listHargaHolder, int i, @NonNull Harga listHarga) {
        listHargaHolder.tvPlnP.setText(listHarga.getNoPaket());
        listHargaHolder.tvPldL.setText(listHarga.getDurasiLatihan());
        listHargaHolder.tvPlharga.setText(listHarga.getHarga());
    }

    @NonNull
    @Override
    public ListHargaAdapter.ListHargaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_harga
                , parent, false);
        return new ListHargaAdapter.ListHargaHolder(v);
    }

    class ListHargaHolder extends RecyclerView.ViewHolder{
        TextView tvPlnP,tvPldL,tvPlharga;

        public ListHargaHolder( View itemView) {
            super(itemView);
            tvPlnP = (TextView) itemView.findViewById(R.id.harga_out_nP);
            tvPldL= (TextView)itemView.findViewById(R.id.harga_out_dL);
            tvPlharga = (TextView)itemView.findViewById(R.id.harga_out_harga);

        }

    }

}
