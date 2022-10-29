package com.lucaspetros.dev.pagefriends;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static App instance;


    @Override
    public void onCreate() {
        super.onCreate();

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
