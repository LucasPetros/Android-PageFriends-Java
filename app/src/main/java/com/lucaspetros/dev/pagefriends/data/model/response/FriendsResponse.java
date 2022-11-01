package com.lucaspetros.dev.pagefriends.data.model.response;


import com.google.gson.annotations.SerializedName;
import com.lucaspetros.dev.pagefriends.data.model.Support;
import com.lucaspetros.dev.pagefriends.data.model.User;

import java.io.Serializable;
import java.util.List;

public class FriendsResponse implements Serializable {

    public int page;
    @SerializedName("per_page")
    public int perPage;
    public int total;
    @SerializedName("total_pages")
    public int totalPages;
    @SerializedName("data")
    public List<User> listFriends;
    public Support support;

}
