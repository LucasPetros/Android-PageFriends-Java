package com.lucaspetros.dev.pagefriends.di;

import com.lucaspetros.dev.pagefriends.data.repository.FriendsRepository;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class BusinessModule {

    @Provides
    @Singleton
    FriendsBusiness providesFriendsBussines(FriendsRepository friendsRepository){
        return new FriendsBusiness(friendsRepository);
    }
}
