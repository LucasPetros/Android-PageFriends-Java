package com.lucaspetros.dev.pagefriends.ui.feature.friends.presentation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.lucaspetros.dev.pagefriends.App;
import com.lucaspetros.dev.pagefriends.R;
import com.lucaspetros.dev.pagefriends.di.AppComponent;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.presentation.fragments.MyFriendsFragment;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModel;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel.FriendsViewModelProviderFactory;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    FriendsViewModelProviderFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppComponent appComponent = App.getInstance().getAppComponent();
        appComponent.inject(this);
        appComponent.inject(factory);

        FriendsViewModel mViewModel= new ViewModelProvider(this,factory).get(FriendsViewModel.class);
        replaceFragment(new MyFriendsFragment());
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.my_frame_container, fragment).commit();
    }
}