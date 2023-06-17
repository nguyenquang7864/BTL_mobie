package com.example.mymusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.R;

import java.util.ArrayList;

import Model.Yeuthich;

public class PlayNhacAdapter extends  RecyclerView.Adapter<PlayNhacAdapter.ViewHolder> {

    Context context;
    ArrayList<Yeuthich> mangbaihat;

    public PlayNhacAdapter(Context context, ArrayList<Yeuthich> mangbaihat) {
        this.context = context;
        this.mangbaihat = mangbaihat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_playbaihat,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Yeuthich baihat = mangbaihat.get(position);
        holder.txtcasi.setText((baihat.getCasi()));
        holder.txtindex.setText(position + 1 + "");
        holder.txttenbaihat.setText((baihat.getTenbaihat()));
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtindex , txttenbaihat , txtcasi ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtcasi = itemView.findViewById(R.id.textviewplaynhactencasi);
            txtindex = itemView.findViewById(R.id.textviewplaynhacindex);
            txttenbaihat = itemView.findViewById(R.id.textviewplaynhactenbaihat);


        }
    }
}
