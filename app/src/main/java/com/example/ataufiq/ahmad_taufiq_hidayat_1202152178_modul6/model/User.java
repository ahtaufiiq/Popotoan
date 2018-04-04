package com.example.ataufiq.ahmad_taufiq_hidayat_1202152178_modul6.model;

public class User {

    String tokenId;
    String userId;
    String username;
    String email;

    public User() {
    }

    public User(String tokenId,String userId, String username, String email) {
        this.tokenId=tokenId;
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}
