package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Akun;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListTrainerPriceAdapter extends FirestoreRecyclerAdapter<Akun, ListTrainerPriceAdapter.ListTrainerHolderPrice> {
    private ListTrainerPriceAdapter.OnItemClickListener listener;

    public ListTrainerPriceAdapter(@NonNull FirestoreRecyclerOptions<Akun> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListTrainerPriceAdapter.ListTrainerHolderPrice listTrainerHolderPrice, int i, @NonNull Akun listTrainer) {
        listTrainerHolderPrice.tvNama.setText(listTrainer.getFullname());
    }

    @NonNull
    @Override
    public ListTrainerPriceAdapter.ListTrainerHolderPrice onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_member_pricelist
                , parent, false);
        return new ListTrainerPriceAdapter.ListTrainerHolderPrice(v);
    }

    class ListTrainerHolderPrice extends RecyclerView.ViewHolder{
        TextView tvNama,tvP;

        public ListTrainerHolderPrice( View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.listnama);
            tvP = itemView.findViewById(R.id.list_pengalaman);

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
    public void setOnItemClickListener(ListTrainerPriceAdapter.OnItemClickListener listener){
        this.listener=listener;
    }

}
