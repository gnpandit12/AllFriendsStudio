
package com.example.allfriendsstudio.model.pojoClass;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("friends")
    private List<Friend> mFriends;
    @SerializedName("resp")
    private String mResp;
    @SerializedName("userProfile")
    private List<UserProfile> mUserProfile;

    public Long getCount() {
        return mCount;
    }

    public List<Friend> getFriends() {
        return mFriends;
    }

    public String getResp() {
        return mResp;
    }

    public List<UserProfile> getUserProfile() {
        return mUserProfile;
    }

    public static class Builder {

        private Long mCount;
        private List<Friend> mFriends;
        private String mResp;
        private List<UserProfile> mUserProfile;

        public ResponseData.Builder withCount(Long count) {
            mCount = count;
            return this;
        }

        public ResponseData.Builder withFriends(List<Friend> friends) {
            mFriends = friends;
            return this;
        }

        public ResponseData.Builder withResp(String resp) {
            mResp = resp;
            return this;
        }

        public ResponseData.Builder withUserProfile(List<UserProfile> userProfile) {
            mUserProfile = userProfile;
            return this;
        }

        public ResponseData build() {
            ResponseData responseData = new ResponseData();
            responseData.mCount = mCount;
            responseData.mFriends = mFriends;
            responseData.mResp = mResp;
            responseData.mUserProfile = mUserProfile;
            return responseData;
        }

    }

}
