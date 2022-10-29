package com.lucaspetros.dev.pagefriends.data.remote;



import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;
import com.lucaspetros.dev.pagefriends.data.model.response.UserResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users?page={id}")
    Observable<FriendsResponse> getListFriendsByPage(@Path("id") int id);

    @GET("user/{id}")
    Observable<UserResponse> getUserById(@Path("id") int id);
}
