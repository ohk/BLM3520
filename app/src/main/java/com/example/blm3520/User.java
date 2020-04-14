package com.example.blm3520;

public class User {
    String username;
    String password;
    int imageId;

    public User(String username, String password, int imageId) {
        this.username = username;
        this.password = password;
        this.imageId = imageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
