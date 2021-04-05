package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Data;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListDataTrainerAdapter extends FirestoreRecyclerAdapter<Data, ListDataTrainerAdapter.ListDataTrainerHolder> {
    private ListDataTrainerAdapter.OnItemClickListener listener;

    public ListDataTrainerAdapter(@NonNull FirestoreRecyclerOptions<Data> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListDataTrainerAdapter.ListDataTrainerHolder listDataTrainerHolder, int i, @NonNull Data listData) {
        listDataTrainerHolder.tvNama.setText(listData.getNamalengkap());
        listDataTrainerHolder.tvPengalaman.setText(listData.getPengalaman());
    }

    @NonNull
    @Override
    public ListDataTrainerAdapter.ListDataTrainerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_trainer
                , parent, false);
        return new ListDataTrainerAdapter.ListDataTrainerHolder(v);
    }

    class ListDataTrainerHolder extends RecyclerView.ViewHolder{
        TextView tvNama,tvPengalaman;


        public ListDataTrainerHolder( View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.listnamatrainer);
            tvPengalaman = itemView.findViewById(R.id.tv_listtrainer_pengalaman);

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
    public void setOnItemClickListener(ListDataTrainerAdapter.OnItemClickListener listener){
        this.listener=listener;
    }
}
