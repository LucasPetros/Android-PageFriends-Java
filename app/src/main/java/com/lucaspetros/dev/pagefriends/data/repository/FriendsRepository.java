package com.lucaspetros.dev.pagefriends.data.repository;

import com.lucaspetros.dev.pagefriends.data.model.User;
import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;
import com.lucaspetros.dev.pagefriends.data.remote.ApiService;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class FriendsRepository {

    @Inject
    ApiService apiService;


    public FriendsRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<FriendsResponse> getListFriendsByPage(String pageId){
        return apiService.getListFriendsByPage(pageId);
    }



}
