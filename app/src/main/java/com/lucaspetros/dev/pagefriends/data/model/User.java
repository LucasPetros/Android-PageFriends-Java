package com.lucaspetros.dev.pagefriends.data.model;


import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class User {
    public int id;
    public String email;
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;
    public String avatar;

    @Inject
    public User() {
    }
}
