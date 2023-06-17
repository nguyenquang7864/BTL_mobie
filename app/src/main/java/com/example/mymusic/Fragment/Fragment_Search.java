package com.example.mymusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.Adapter.SearchBaiHatAdapter;
import com.example.mymusic.R;
import com.example.mymusic.Service.APIService;
import com.example.mymusic.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import Model.Yeuthich;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Search extends Fragment {
    private View view;
    private Toolbar toolbar;
    private RecyclerView recyclerViewSearchBaiHat;
    private TextView txtKhongCoDuLieu;
    private SearchBaiHatAdapter searchBaiHatAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);
        toolbar = view.findViewById(R.id.toolbarsearchbaihat);
        recyclerViewSearchBaiHat = view.findViewById(R.id.recycleviewsearchbaihat);
        txtKhongCoDuLieu = view.findViewById(R.id.textviewkhongcodulieubaihat);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);



        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menu_search);
        if (menuItem != null) {
            SearchView searchView = (SearchView) menuItem.getActionView();
            if (searchView != null) {
                searchView.setMaxWidth(Integer.MAX_VALUE);

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        searchBaiHat(query);
                        return true;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        return false;
                    }
                });
            }
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void searchBaiHat(String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Yeuthich>> callback = dataservice.GetSearchBaihat(query);
        callback.enqueue(new Callback<List<Yeuthich>>() {
            @Override
            public void onResponse(Call<List<Yeuthich>> call, Response<List<Yeuthich>> response) {
                ArrayList<Yeuthich> mangBaiHat = (ArrayList<Yeuthich>) response.body();

                if (mangBaiHat != null && mangBaiHat.size() > 0) {
                    searchBaiHatAdapter = new SearchBaiHatAdapter(getActivity(),mangBaiHat);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());

                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    recyclerViewSearchBaiHat.setLayoutManager(layoutManager);


                    recyclerViewSearchBaiHat.setAdapter(searchBaiHatAdapter);
                    txtKhongCoDuLieu.setVisibility(View.GONE);
                    recyclerViewSearchBaiHat.setVisibility(View.VISIBLE);


                } else {

                    recyclerViewSearchBaiHat.setVisibility(View.GONE);
                    txtKhongCoDuLieu.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onFailure(Call<List<Yeuthich>> call, Throwable t) {
                // Xử lý lỗi khi gọi API thất bại
            }
        });
    }
}
