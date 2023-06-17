package com.example.mymusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mymusic.Activity.Play_nhac_activity;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import Model.Yeuthich;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchBaiHatAdapter extends RecyclerView.Adapter<SearchBaiHatAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Yeuthich> mangbaihat;

    public SearchBaiHatAdapter(Context context, ArrayList<Yeuthich> mangBaiHat) {
        this.context = context ;
        this.mangbaihat = mangBaiHat;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dong_search, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Yeuthich baihat = mangbaihat.get(position);
        holder.txtTenbaihat.setText(baihat.getTenbaihat());
        holder.txtCasi.setText(baihat.getCasi());
        Picasso.get().load(baihat.getHinhbaihat()).into(holder.imgbaihat);
    }

    @Override
    public int getItemCount() {
        return mangbaihat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView txtTenbaihat, txtCasi;
        private ImageView imgbaihat, imgluotthich;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTenbaihat = itemView.findViewById(R.id.textviewsearchtenbaihat);
            txtCasi = itemView.findViewById(R.id.textviewsearchcasibaihat);
            imgluotthich = itemView.findViewById(R.id.imageviewSearchluotthich);
            imgbaihat = itemView.findViewById(R.id.imageviewSearchbaihat);

            itemView.setOnClickListener(this);
            imgluotthich.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Yeuthich baihat = mangbaihat.get(position);
                if (view.getId() == itemView.getId()) {
                    Intent intent = new Intent(context, Play_nhac_activity.class);
                    intent.putExtra("cakhuc", baihat);
                    context.startActivity(intent);
                } else if (view.getId() == imgluotthich.getId()) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    imgluotthich.setEnabled(false);
                    updateLuotThich(baihat.getIdbaihat());
                }
            }
        }

        private void updateLuotThich(String idBaiHat) {
            Dataservice dataservice = APIService.getService();
            Call<String> callback = dataservice.Updateluotthich("1", idBaiHat);
            callback.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    String ketqua = response.body();
                    if (ketqua != null && ketqua.equals("Success")) {

                    } else {

                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                   
                }
            });
        }


    }
}
