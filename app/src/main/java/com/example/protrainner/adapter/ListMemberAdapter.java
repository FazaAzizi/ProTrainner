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

public class ListMemberAdapter extends FirestoreRecyclerAdapter<Akun, ListMemberAdapter.ListMemberHolder> {
    private ListMemberAdapter.OnItemClickListener listener;

    public ListMemberAdapter(@NonNull FirestoreRecyclerOptions<Akun> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ListMemberAdapter.ListMemberHolder listMemberHolder, int i, @NonNull Akun listMember) {
        listMemberHolder.tvNama.setText(listMember.getFullname());
        listMemberHolder.tvGndr.setText(listMember.getJeniskelamin());
    }

    @NonNull
    @Override
    public ListMemberAdapter.ListMemberHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_member
                , parent, false);
        return new ListMemberAdapter.ListMemberHolder(v);
    }

    class ListMemberHolder extends RecyclerView.ViewHolder{
        TextView tvNama,tvGndr;

        public ListMemberHolder( View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.listnamamember);
            tvGndr = itemView.findViewById(R.id.tv_listmember_pengalaman);


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
    public void setOnItemClickListener(ListMemberAdapter.OnItemClickListener listener){
        this.listener=listener;
    }


}
