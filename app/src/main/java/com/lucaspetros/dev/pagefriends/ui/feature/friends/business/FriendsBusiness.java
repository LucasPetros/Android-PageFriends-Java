package com.lucaspetros.dev.pagefriends.ui.feature.friends.business;

import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;
import com.lucaspetros.dev.pagefriends.data.repository.FriendsRepository;

import javax.inject.Inject;

public class FriendsBusiness {

    @Inject
    FriendsRepository friendsRepository;


    public FriendsBusiness(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }
}
