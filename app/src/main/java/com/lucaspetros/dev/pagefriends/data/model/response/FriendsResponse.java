package com.lucaspetros.dev.pagefriends.data.model.response;



import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.lucaspetros.dev.pagefriends.data.model.User;

public class FriendsResponse implements Serializable {

    public int page;
    @SerializedName("total_pages")
    public int totalPages;

    @SerializedName("data")
    public List<User> friends;

}
