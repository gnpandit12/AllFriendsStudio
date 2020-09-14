package com.example.allfriendsstudio.model;


import com.example.allfriendsstudio.model.di.ApiComponent;
import com.example.allfriendsstudio.model.di.ApiModule;
import com.example.allfriendsstudio.model.di.DaggerApiComponent;
import com.example.allfriendsstudio.model.pojoClass.ResponseData;

import javax.inject.Inject;

import io.reactivex.Single;

public class FriendsService {

    @Inject
    FriendsAPI friendsAPI;
    private ApiComponent component;

    public FriendsService() {
        component = DaggerApiComponent.builder()
                .apiModule(new ApiModule()).build();
        component.inject(this);
    }

    public Single<ResponseData> getResponse() {
        return friendsAPI.getFriendsListAndProfile();
    }

}
