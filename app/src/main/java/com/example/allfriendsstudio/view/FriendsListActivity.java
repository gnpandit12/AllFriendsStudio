package com.example.allfriendsstudio.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.allfriendsstudio.R;
import com.example.allfriendsstudio.databinding.ActivityFriendsListBinding;
import com.example.allfriendsstudio.model.adapter.FriendsListAdapter;
import com.example.allfriendsstudio.model.dataClass.FriendsData;
import com.example.allfriendsstudio.model.dataClass.ResponseData;
import com.example.allfriendsstudio.viewModel.FriendsListViewModel;

import java.util.List;
import java.util.concurrent.BlockingDeque;

public class FriendsListActivity extends AppCompatActivity {

    public static final String TAG = "friends_activity";
    private ActivityFriendsListBinding friendsListBinding;
    private FriendsListViewModel friendsListViewModel;
    private RecyclerView friendsListRecyclerView;
    private FriendsListAdapter friendsListAdapter;
    private ProgressBar loadingProgressBar;
    private EditText searchUserNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        friendsListBinding = DataBindingUtil.setContentView(this, R.layout.activity_friends_list);
        friendsListRecyclerView = friendsListBinding.friendsListRecyclerView;
        loadingProgressBar = friendsListBinding.loadingProgressBar;
        searchUserNameEditText = friendsListBinding.searchUsernameEditText;
        loadingProgressBar.setVisibility(View.GONE);
        friendsListRecyclerView.setHasFixedSize(true);
        friendsListViewModel = ViewModelProviders.of(this).get(FriendsListViewModel.class);
        friendsListViewModel.getFriendsList();
        observeViewModel();

    }

    private void observeViewModel() {

        //Loading.....
        friendsListViewModel.responseLoadingMutableLiveData
                .observe(this,
                        aBoolean -> {
                            Log.d(TAG, "onChanged: ");
                            if (aBoolean) {
                                loadingProgressBar.setVisibility(View.VISIBLE);
                            } else {
                                loadingProgressBar.setVisibility(View.GONE);
                            }
                        });


        // Response......
        friendsListViewModel.responseDataMutableLiveData
                .observe(
                        this,
                        responseData -> {
                            Log.d(TAG, "onChanged: ");
                            if (responseData != null) {
                                friendsListAdapter = new FriendsListAdapter(this, responseData.getFriends());
                                friendsListRecyclerView.setAdapter(friendsListAdapter);
                                friendsListAdapter.notifyDataSetChanged();
                            } else {
                                loadingProgressBar.setVisibility(View.GONE);
                            }
                        }
                );

        // Error....
        friendsListViewModel.responseErrorMutableLiveData
                .observe(
                        this,
                        aBoolean -> {
                            if (aBoolean) {
                                loadingProgressBar.setVisibility(View.GONE);
                            } else {
                                loadingProgressBar.setVisibility(View.GONE);
                            }
                        }
                );
    }
}