package com.lucaspetros.dev.pagefriends.data.model;



import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;

import java.util.List;

public class FriendsDTO {

    private final int page;
    private final int totalPages;
    private final List<User> friends;

    public FriendsDTO(FriendsResponse friendsResponse) {
        this.page = friendsResponse.page;
        this.totalPages = friendsResponse.totalPages;
        this.friends = friendsResponse.friends;
    }

    public List<User> getFriends() {
        return friends;
    }

    public int getPage() {
        return page;
    }


    public int getTotalPages() {
        return totalPages;
    }


}
