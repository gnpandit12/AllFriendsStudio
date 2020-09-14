package com.example.allfriendsstudio.model.di;


import com.example.allfriendsstudio.model.FriendsService;
import com.example.allfriendsstudio.viewModel.FriendsListViewModel;
import com.example.allfriendsstudio.viewModel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApiModule.class)
public
interface ApiComponent {

    void inject(FriendsService friendsService);

    void inject(MainActivityViewModel mainActivityViewModel);

    void inject(FriendsListViewModel friendsListViewModel);


}
