package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model;

public class Post {
    private String username;
    private String titlePost;
    private String post;

    public Post(String username, String titlePost, String post) {
        this.username = username;
        this.titlePost = titlePost;
        this.post = post;
    }

    public String getUsername() {
        return username;
    }

    public String getTitlePost() {
        return titlePost;
    }

    public String getPost() {
        return post;
    }
}
