package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.homeScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.R;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.adapter.PostAdapter;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model.Post;

import java.util.ArrayList;


public class FragmentMyPost extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Post> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_post, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(),2));
        listItems = new ArrayList<>() ;

        listItems.add(new Post("Andi","Persija Jakarta","Juara lagi lah"));
        listItems.add(new Post("Andi","Persija Jakarta","Juara lagi lah"));
        listItems.add(new Post("Andi","Persija Jakarta","Juara lagi lah"));
        listItems.add(new Post("Andi","Persija Jakarta","Juara lagi lah"));
        listItems.add(new Post("Andi","Persija Jakarta","Juara lagi lah"));

        adapter= new PostAdapter(view.getContext(),listItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
