package com.example.mymusic.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.Adapter.YeuthichAdapter;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import Model.Yeuthich;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Yeuthich extends Fragment {
    View view;
    YeuthichAdapter yeuthichAdapter;
    RecyclerView recyclerViewYeuthich ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_yeuthich,container,false);
        recyclerViewYeuthich = view.findViewById(R.id.recycleyeuthich);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Yeuthich>> callback = dataservice.GetYeuthich();
        callback.enqueue(new Callback<List<Yeuthich>>() {
            @Override
            public void onResponse(Call<List<Yeuthich>> call, Response<List<Yeuthich>> response) {

                ArrayList<Yeuthich> baihatyeuthichArrayList = (ArrayList<Yeuthich>)  response.body();
                yeuthichAdapter = new YeuthichAdapter(getActivity(),baihatyeuthichArrayList);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerViewYeuthich.setLayoutManager(linearLayoutManager);
                recyclerViewYeuthich.setAdapter(yeuthichAdapter);

            }

            @Override
            public void onFailure(Call<List<Yeuthich>> call, Throwable t) {

            }
        });
    }
}
