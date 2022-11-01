package com.lucaspetros.dev.pagefriends.ui.feature.friends.business;

import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;
import com.lucaspetros.dev.pagefriends.data.model.response.dto.FriendsDTO;
import com.lucaspetros.dev.pagefriends.data.repository.FriendsRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class FriendsBusiness {

    @Inject
    FriendsRepository friendsRepository;

    FriendsResponse friendsResponse;


    public FriendsBusiness(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }

    public Observable<FriendsDTO> getListFriends(String pageId) {

        return Observable.defer(() -> friendsRepository.getListFriendsByPage(pageId)
                .map(friendsResponse2 -> {
                    this.friendsResponse = friendsResponse2;
                    return new FriendsDTO(friendsResponse);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()));
    }

}
