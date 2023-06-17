package com.example.mymusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

public class YeuthichAdapter extends RecyclerView.Adapter<YeuthichAdapter.ViewHolder> {

    Context context ;
    ArrayList<Yeuthich> yeuthichArrayList;

    public YeuthichAdapter(Context context, ArrayList<Yeuthich> yeuthichArrayList) {
        this.context = context;
        this.yeuthichArrayList = yeuthichArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_yeuthich,parent,false);

        return new YeuthichAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Yeuthich yeuthich = yeuthichArrayList.get(position);
        holder.txtcasi.setText(yeuthich.getCasi());
        holder.txtten.setText(yeuthich.getTenbaihat());
        Picasso.get().load(yeuthich.getHinhbaihat()).into(holder.imghinh);
    }

    @Override
    public int getItemCount() {
        return yeuthichArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtten , txtcasi ;
        ImageView imghinh ;
        ImageButton imgluotthich;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtten = itemView.findViewById(R.id.textviewtenbaihat);
            txtcasi = itemView.findViewById(R.id.textviewtencasi);
            imghinh = itemView.findViewById(R.id.imageviewbaihatyeuthich);
            imgluotthich = itemView.findViewById(R.id.btimgviewyeuthich);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, Play_nhac_activity.class);
                    intent.putExtra("cakhuc",yeuthichArrayList.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgluotthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imgluotthich.setImageResource(R.drawable.iconloved);
                    Dataservice dataservice = APIService.getService();
                    Call<String> callback = dataservice.Updateluotthich("1",yeuthichArrayList.get(getPosition()).getIdbaihat());
                    callback.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String ketqua = response.body();
                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imgluotthich.setEnabled(false);
                }
            });
        }
    }
}
