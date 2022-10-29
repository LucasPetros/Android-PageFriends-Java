package com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;

public class FriendsViewModel extends AndroidViewModel {
    public final FriendsBusiness friendsBusiness;

    public FriendsViewModel(@NonNull Application application, FriendsBusiness friendsBusiness) {
        super(application);
        this.friendsBusiness = friendsBusiness;
    }
}
