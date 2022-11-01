package com.lucaspetros.dev.pagefriends.di;

import com.lucaspetros.dev.pagefriends.data.remote.ApiService;
import com.lucaspetros.dev.pagefriends.data.repository.FriendsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    FriendsRepository provideFriendsRepository(ApiService apiService){
        return new FriendsRepository(apiService);
    }
}
