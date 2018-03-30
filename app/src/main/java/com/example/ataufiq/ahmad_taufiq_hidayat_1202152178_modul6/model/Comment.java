package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model;

public class Comment {

    String id;
    String username;
    String comment;

    public Comment() {
    }

    public Comment(String id,String username, String comment) {
        this.id=id;
        this.username = username;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getComment() {
        return comment;
    }
}
