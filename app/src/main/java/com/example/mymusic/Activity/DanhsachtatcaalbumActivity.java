package com.example.mymusic.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.mymusic.Adapter.AlbumAdapter;
import com.example.mymusic.Adapter.AllAlbumAdapter;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import Model.Album;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhsachtatcaalbumActivity extends AppCompatActivity {

    RecyclerView recyclerViewallalbum;
    Toolbar toolbarallalbum;
    AllAlbumAdapter allAlbumAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsachtatcaalbum);
        init_();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> callback = dataservice.GetAllAlbum();
        callback.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> mangalbum = (ArrayList<Album>) response.body();
                allAlbumAdapter = new AllAlbumAdapter(DanhsachtatcaalbumActivity.this,mangalbum);
                recyclerViewallalbum.setLayoutManager(new GridLayoutManager(DanhsachtatcaalbumActivity.this,2));
                recyclerViewallalbum.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
    }

    private void init_() {
        recyclerViewallalbum = findViewById(R.id.recyclerviewallalbum);
        toolbarallalbum = findViewById(R.id.toolbarallalbum);
        setSupportActionBar(toolbarallalbum);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("TẤT CẢ CÁC ALBUM");
    }
}