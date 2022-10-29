package com.lucaspetros.dev.pagefriends.di;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        ApiModule.class,
        AppModule.class,
        BusinessModule.class,
        ViewModelProviderFactoryModule.class
})

public interface AppComponent {


}
