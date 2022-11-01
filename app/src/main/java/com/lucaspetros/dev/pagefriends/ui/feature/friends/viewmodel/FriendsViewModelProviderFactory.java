package com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;

import java.lang.reflect.InvocationTargetException;

import javax.inject.Inject;

public class FriendsViewModelProviderFactory implements ViewModelProvider.Factory {

    @Inject
    FriendsBusiness friendsBusiness;

    Application application;

    public FriendsViewModelProviderFactory(Application application, FriendsBusiness friendsBusiness) {
        this.friendsBusiness = friendsBusiness;
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return modelClass.getConstructor(Application.class, FriendsBusiness.class).newInstance(application, friendsBusiness);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
