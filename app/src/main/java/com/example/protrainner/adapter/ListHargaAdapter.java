package com.example.protrainner.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Akun;
import com.example.protrainner.model.Harga;
import com.example.protrainner.model.Inti;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListHargaAdapter extends FirestoreRecyclerAdapter<Harga, ListHargaAdapter.ListHargaHolder> {
    private ListHargaAdapter.OnItemClickListener listener;

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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null){

                    }
                }
            });

        }

    }

//    public static class OnItemClickListener {
//        public void onItemClick(DocumentSnapshot dS, int position){
//            Akun akun = dS.toObject(Akun.class);
//            String id = dS.getId();
//            String isConnected = akun.getIsConnected();
//            Bundle b = new Bundle();
//            b.putString("UID",id);
//
//
//        }
//    }
//    public void setOnItemClickListener(ListHargaAdapter.OnItemClickListener listener){
//        this.listener=listener;
//    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot dS, int position);
    }
    public void setOnItemClickListener(ListHargaAdapter.OnItemClickListener listener){
        this.listener=listener;
    }

}
