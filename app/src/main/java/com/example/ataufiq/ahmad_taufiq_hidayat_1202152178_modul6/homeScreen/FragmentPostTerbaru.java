package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.homeScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.MainActivity;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.R;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.adapter.PostAdapter;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FragmentPostTerbaru extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private ArrayList<Post> listPosts;
    //our database reference object
    DatabaseReference databaseFood;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_terbaru, container, false);

        databaseFood = FirebaseDatabase.getInstance().getReference(MainActivity.table1);

        recyclerView = view.findViewById(R.id.recyclerView);

        listPosts = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart(); //attaching value event listener
        databaseFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                listPosts.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    Post post = postSnapshot.getValue(Post.class);

                    listPosts.add(post);
                }
                recyclerView.setHasFixedSize(true);

                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

                PostAdapter postList = new PostAdapter(getContext(), listPosts);

                recyclerView.setAdapter(postList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}