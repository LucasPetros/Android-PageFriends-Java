package com.lucaspetros.dev.pagefriends;

import android.app.Application;
import android.content.Context;

import com.lucaspetros.dev.pagefriends.di.ApiModule;
import com.lucaspetros.dev.pagefriends.di.AppComponent;
import com.lucaspetros.dev.pagefriends.di.AppModule;
import com.lucaspetros.dev.pagefriends.di.BusinessModule;
import com.lucaspetros.dev.pagefriends.di.DaggerAppComponent;

public class App extends Application {
    private static App instance;
    private static AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiModule(new ApiModule(this))
                .businessModule(new BusinessModule())
                .build();

    }

    public static App getInstance(){
        if(instance == null){
            instance = new App();
        }
        return instance;
    }

    public static Context getContext(){
        if(instance == null){
            instance = new App();
        }
        return instance.getApplicationContext();
    }
}
