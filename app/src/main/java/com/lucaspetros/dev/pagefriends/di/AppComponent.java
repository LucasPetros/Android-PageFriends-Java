package com.lucaspetros.dev.pagefriends.di;

import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.presentation.MainActivity;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModelProviderFactory;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        AppModule.class,
        RepositoryModule.class,
        BusinessModule.class,
        ViewModelProviderFactoryModule.class
})

public interface AppComponent {

    void inject(FriendsViewModelProviderFactory friendsViewModel);

    void inject(FriendsBusiness friendsBusiness);

    void inject(MainActivity mainActivity);


}
