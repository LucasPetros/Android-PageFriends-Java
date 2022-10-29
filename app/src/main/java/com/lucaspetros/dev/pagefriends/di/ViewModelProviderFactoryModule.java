package com.lucaspetros.dev.pagefriends.di;

import android.app.Application;

import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelProviderFactoryModule {

    @Provides
    @Singleton
    FriendsViewModelProviderFactory providesFriendsViewModelFactory(Application application, FriendsBusiness friendsBusiness){
     return new FriendsViewModelProviderFactory(application, friendsBusiness);
    }


}
