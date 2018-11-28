package com.kodilla.good.patterns.challenges.onlineshop.model;

public class User {
    private Long id;
    private String username;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
