package com.example.allfriendsstudio.model;

import com.example.allfriendsstudio.model.dataClass.ResponseData;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface FriendsAPI {

    @GET("/loginUser?login_id=maneet@gmail.com&password=qwertyuiop")
    Single<ResponseData> getFriendsListAndProfile();

}
