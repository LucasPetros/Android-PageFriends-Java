package com.lucaspetros.dev.pagefriends.data.model.response;


import com.google.gson.annotations.SerializedName;
import com.lucaspetros.dev.pagefriends.data.model.User;


public class UserResponse {
    @SerializedName("data")
    public User user;
}
