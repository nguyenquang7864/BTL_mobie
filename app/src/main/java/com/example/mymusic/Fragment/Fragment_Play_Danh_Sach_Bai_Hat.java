package com.example.mymusic.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.Activity.Play_nhac_activity;
import com.example.mymusic.Adapter.PlayNhacAdapter;
import com.example.mymusic.R;

public class Fragment_Play_Danh_Sach_Bai_Hat extends Fragment {
    View view ;
    RecyclerView recyclerViewplaynhac ;

    PlayNhacAdapter playNhacAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_danh_sach_cac_bai_hat,container,false);
        recyclerViewplaynhac = view.findViewById(R.id.recycerviewplaybaihat);
        if(Play_nhac_activity.mangbaihat.size()>0) {
            playNhacAdapter = new PlayNhacAdapter(getActivity(), Play_nhac_activity.mangbaihat);
            recyclerViewplaynhac.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewplaynhac.setAdapter(playNhacAdapter);
        }
        return view;
    }
}
