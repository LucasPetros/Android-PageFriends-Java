package com.lucaspetros.dev.pagefriends.data.model.response.dto;


import com.lucaspetros.dev.pagefriends.data.model.User;
import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;

import java.util.List;

public class FriendsDTO {

    private int totalPages;
    private List<User> listFriends;


    public FriendsDTO(FriendsResponse friendsResponse) {
        this.totalPages = friendsResponse.totalPages;
        this.listFriends = friendsResponse.listFriends;
    }

    public List<User> getFriends() {
        return listFriends;
    }

    public int getTotalPages() {
        return totalPages;
    }


}
