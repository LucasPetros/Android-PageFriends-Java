package com.lucaspetros.dev.pagefriends.ui.feature.friends.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.lucaspetros.dev.pagefriends.data.model.User;
import com.lucaspetros.dev.pagefriends.ui.feature.friends.business.FriendsBusiness;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class FriendsViewModel extends AndroidViewModel {
    private static final List<User> myFriends = new ArrayList<>();
    private final List<User> userFilter = new ArrayList<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    public FriendsBusiness friendsBusiness;
    public MutableLiveData<List<User>> listAllFriendsDTOMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Throwable> error = new MutableLiveData<>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<>();


    public FriendsViewModel(Application application, FriendsBusiness friendsBusiness) {
        super(application);
        this.friendsBusiness = friendsBusiness;
    }

    public void getAllFriends(int pages) {
        myFriends.clear();
        for (int i = 1; i <= pages; i++) {
            compositeDisposable.add(
                    friendsBusiness.getListFriends(Integer.toString(i)).subscribe(
                            response -> {
                                setMyListFriends(response.getFriends());
                                listAllFriendsDTOMutableLiveData.postValue(getMyListFriends());
                            },
                            throwable -> error.postValue(throwable),
                            () -> loading.postValue(false)
                    )
            );
        }
    }


    public void getQntPages() {
        myFriends.clear();
        loading.postValue(true);
        compositeDisposable.add(
                friendsBusiness.getListFriends("1").subscribe(
                        response -> getAllFriends(response.getTotalPages()),
                        throwable -> error.postValue(throwable),
                        () -> loading.postValue(false)
                )
        );
    }

    public void getFriendsFilter(String search) {
        userFilter.clear();
        for (User user :
                getMyListFriends()) {
            String fullName = user.firstName + " " + user.lastName;
            if (fullName.toLowerCase().contains(search.toLowerCase())) {
                userFilter.add(user);
            }

        }
        if (userFilter.size() == 0 && search.equals("")) {
            listAllFriendsDTOMutableLiveData.postValue(getMyListFriends());
        } else {
            listAllFriendsDTOMutableLiveData.postValue(userFilter);
        }

    }


    public List<User> getMyListFriends() {
        return myFriends;
    }

    public static void setMyListFriends(List<User> myFriends) {
        FriendsViewModel.myFriends.addAll(myFriends);
    }

    public void clearObservable() {
        myFriends.clear();
        compositeDisposable.clear();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
        myFriends.clear();
    }
}
