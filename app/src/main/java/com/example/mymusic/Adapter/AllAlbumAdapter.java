package com.example.mymusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.Activity.DanhsachbaihatActivity;
import com.example.mymusic.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.Album;

public class AllAlbumAdapter extends  RecyclerView.Adapter<AllAlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> albumArrayList;

    public AllAlbumAdapter(Context context, ArrayList<Album> albumArrayList) {
        this.context = context;
        this.albumArrayList = albumArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_allalbum,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Album album = albumArrayList.get(position);
        Picasso.get().load(album.getHinhalbum()).into(holder.imgallalbum);
        holder.txttenallalbum.setText(album.getTenalbum());

    }

    @Override
    public int getItemCount() {
        return albumArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imgallalbum;
        TextView txttenallalbum;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgallalbum = itemView.findViewById(R.id.imageviewalldalbum);
            txttenallalbum = itemView.findViewById(R.id.textviewdanhsachcacalbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                    intent.putExtra("album",albumArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
