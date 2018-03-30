package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.R;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model.Comment;
import com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model.Post;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    Context context;
    List<Comment> commentList;


    public CommentAdapter(Context context, List<Comment> commentList) {
        this.context = context;
        this.commentList = commentList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mUsername;
        TextView mComment;
        public ViewHolder(View itemView) {
            super(itemView);

            mUsername=itemView.findViewById(R.id.tv_username);
            mComment=itemView.findViewById(R.id.tv_comment);
        }
    }

    @NonNull
    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_comment,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.ViewHolder holder, int position) {
        final Comment comment= commentList.get(position);

        holder.mUsername.setText(comment.getUsername());
        holder.mComment.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

}
