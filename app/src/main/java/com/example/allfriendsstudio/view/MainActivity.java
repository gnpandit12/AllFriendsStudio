package com.example.allfriendsstudio.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.allfriendsstudio.R;
import com.example.allfriendsstudio.databinding.ActivityMainBinding;
import com.example.allfriendsstudio.model.pojoClass.UserProfile;
import com.example.allfriendsstudio.viewModel.MainActivityViewModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "main_activity";
    private ActivityMainBinding mainBinding;
    private TextView userNameTV, userEmailTV, userContactNumberTV, userBioTV, lastSeenTV,
            firstNameTV, lastNameTV;
    private CircleImageView profilePicImageView;
    private MainActivityViewModel mainActivityViewModel;
    private List<UserProfile> userProfileDataList;
    private Button friendsListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        profilePicImageView = mainBinding.profileImage;
        userNameTV = mainBinding.userNameTextView;
        userEmailTV = mainBinding.userEmailTextView;
        userContactNumberTV = mainBinding.userContactTextView;
        userBioTV = mainBinding.userBioTextView;
        lastSeenTV = mainBinding.userLastSeenTextView;
        firstNameTV = mainBinding.userFirstNameTextView;
        lastNameTV = mainBinding.userLastNameTextView;
        friendsListButton = mainBinding.friendsListButton;
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getFriendsListAndUserProfile();
        friendsListButton.setOnClickListener(this);
        observeViewModel();
    }

    private void observeViewModel() {
        mainActivityViewModel.responseDataMutableLiveData.observe(
                this,
                responseData -> {
                    Log.d(TAG, "onChanged: ");
                    if (responseData != null) {
                        Log.d(TAG, "Successful!");
                        userProfileDataList = responseData.getUserProfile();
                        UserProfile userProfileData = userProfileDataList.get(0);

                        if (userProfileData.getUserName() != null) {
                            userNameTV.setText(userProfileData.getUserName());
                        } else {
                            Log.d(TAG, "UserName Null");
                        }

                        if (userProfileData.getUserBio() != null) {
                            userBioTV.setText(userProfileData.getUserBio().toString());
                        } else {
                            Log.d(TAG, "User Bio Null");
                        }

                        if (userProfileData.getUserContactNo() != null) {
                            userContactNumberTV.setText(userProfileData.getUserContactNo());
                        } else {
                            Log.d(TAG, "User Contact Number Null");
                        }

                        if (userProfileData.getUserMail() != null) {
                            userEmailTV.setText(userProfileData.getUserMail());
                        } else {
                            Log.d(TAG, "User Email Null");
                        }

                        if (userProfileData.getLastSeen() != null) {
                            lastSeenTV.setText(userProfileData.getLastSeen().toString());
                        } else {
                            Log.d(TAG, "Last Seen Null");
                        }

                        if (userProfileData.getFname() != null) {
                            firstNameTV.setText(userProfileData.getFname());
                        } else {
                            Log.d(TAG, "First Name Null");
                        }

                        if (userProfileData.getLname() != null) {
                            lastNameTV.setText(userProfileData.getLname());
                        } else {
                            Log.d(TAG, "Last Name Null");
                        }

                        if (userProfileData.getProfilePic() != null) {
                            Glide.with(this)
                                    .load(userProfileData.getProfilePic())
                                    .listener(new RequestListener<Drawable>() {
                                        @Override
                                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                                            Log.d(TAG, "onLoadFailed: " + e.toString());
                                            return false;
                                        }

                                        @Override
                                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                                            Log.d(TAG, "onResourceReady: ");
                                            return false;
                                        }
                                    })
                                    .into(profilePicImageView);
                        } else {
                            Log.d(TAG, "Profile Picture Null");
                        }


                    } else {
                        Log.d(TAG, "Unsuccessful!");
                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        if (v == friendsListButton) {
            startActivity(new Intent(this, FriendsListActivity.class));
        }
    }

}