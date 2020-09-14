package com.example.allfriendsstudio.model.dataClass;

import java.util.List;
import java.io.Serializable;

public class ResponseData implements Serializable {
    private String resp;
    private int count;
    private List<FriendsData> friends;
    private List<UserProfileData> userProfile;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<FriendsData> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendsData> friends) {
        this.friends = friends;
    }

    public List<UserProfileData> getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(List<UserProfileData> userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return
                "ResponseData{" +
                        "resp = '" + resp + '\'' +
                        ",count = '" + count + '\'' +
                        ",friends = '" + friends + '\'' +
                        ",userProfile = '" + userProfile + '\'' +
                        "}";
    }
}