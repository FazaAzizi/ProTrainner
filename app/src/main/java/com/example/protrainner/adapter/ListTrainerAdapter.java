package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.Akun;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListTrainerAdapter extends FirestoreRecyclerAdapter<Akun, ListTrainerAdapter.ListTrainerHolder> {
    private OnItemClickListener listener;

    public ListTrainerAdapter(@NonNull FirestoreRecyclerOptions<Akun> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListTrainerHolder listTrainerHolder, int i, @NonNull Akun listTrainer) {
            listTrainerHolder.tvNama.setText(listTrainer.getFullname());
    }

    @NonNull
    @Override
    public ListTrainerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_trainer
        , parent, false);
        return new ListTrainerHolder(v);
    }

    class ListTrainerHolder extends RecyclerView.ViewHolder{
        TextView tvNama,tvPengalaman;


        public ListTrainerHolder( View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.listnamatrainer);
//            tvPengalaman = itemView.findViewById()

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
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

}
