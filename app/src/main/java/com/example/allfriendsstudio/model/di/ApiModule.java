package com.example.allfriendsstudio.model.di;

import com.example.allfriendsstudio.model.FriendsAPI;
import com.example.allfriendsstudio.model.FriendsService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    private String BASE_URL = "http://15.207.210.147";

    @Provides
    FriendsAPI provideCountriesAPI() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(FriendsAPI.class);
    }

    @Provides
    FriendsService provideCountriesService() {
        return new FriendsService();
    }


}
