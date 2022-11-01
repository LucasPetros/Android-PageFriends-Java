package com.lucaspetros.dev.pagefriends.data.remote;


import com.lucaspetros.dev.pagefriends.data.model.response.FriendsResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users?")
    Observable<FriendsResponse> getListFriendsByPage(@Query("page") String id);

    /*@GET("user/{id}")
    Observable<UserResponse> getUserById(@Path("id") int id);*/
}
