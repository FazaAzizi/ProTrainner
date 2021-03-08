package com.example.protrainner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.protrainner.R;
import com.example.protrainner.model.FTL;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class ListFtlAdapter extends FirestoreRecyclerAdapter<FTL, ListFtlAdapter.ListFtlHolder> {
    private OnItemClickListener listener;

    public ListFtlAdapter(@NonNull FirestoreRecyclerOptions<FTL> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListFtlHolder listFtlHolder, int i, @NonNull FTL listFtl) {
        listFtlHolder.tvSesi.setText(listFtl.getNoSesi());
    }

    @NonNull
    @Override
    public ListFtlHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ftl
                , parent, false);
        return new ListFtlHolder(v);
    }

    class ListFtlHolder extends RecyclerView.ViewHolder{
        TextView tvSesi;

        public ListFtlHolder( View itemView) {
            super(itemView);
            tvSesi = itemView.findViewById(R.id.list_ftl_tv);

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
