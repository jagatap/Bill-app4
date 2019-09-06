package com.example.billapplication;

import java.util.ArrayList;

public class UserResponse {
    private String status;
    private String message;

    private String userToken;
    //private UserDetails userDetails;
    private ArrayList<String> role;
    //private ArrayList<TilesVisible> tilesVisible;

    public String getStatus() {
        return status;
    }

    public UserResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public UserResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUserToken() {
        return userToken;
    }

    public UserResponse setUserToken(String userToken) {
        this.userToken = userToken;
        return this;
    }

//    public UserDetails getUserDetails() {
//        return userDetails;
//    }
//
//    public UserResponse setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//        return this;
//    }

    public ArrayList<String> getRole() {
        return role;
    }

    public UserResponse setRole(ArrayList<String> role) {
        this.role = role;
        return this;
    }

//    public ArrayList<TilesVisible> getTilesVisible() {
//        return tilesVisible;
//    }
//
//    public UserResponse setTilesVisible(ArrayList<TilesVisible> tilesVisible) {
//        this.tilesVisible = tilesVisible;
//        return this;
//    }
}
