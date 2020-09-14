package com.example.allfriendsstudio.model.dataClass;

import java.io.Serializable;

public class FriendsData implements Serializable {
    private String userName;
    private String userMail;
    private String userContactNo;
    private Object userBio;
    private Object fname;
    private Object lastSeen;
    private String profilePic;
    private Object lname;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserContactNo() {
        return userContactNo;
    }

    public void setUserContactNo(String userContactNo) {
        this.userContactNo = userContactNo;
    }

    public Object getUserBio() {
        return userBio;
    }

    public void setUserBio(Object userBio) {
        this.userBio = userBio;
    }

    public Object getFname() {
        return fname;
    }

    public void setFname(Object fname) {
        this.fname = fname;
    }

    public Object getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Object lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Object getLname() {
        return lname;
    }

    public void setLname(Object lname) {
        this.lname = lname;
    }

    @Override
    public String toString() {
        return
                "FriendsData{" +
                        "user_name = '" + userName + '\'' +
                        ",user_mail = '" + userMail + '\'' +
                        ",user_contact_no = '" + userContactNo + '\'' +
                        ",user_bio = '" + userBio + '\'' +
                        ",fname = '" + fname + '\'' +
                        ",last_seen = '" + lastSeen + '\'' +
                        ",profile_pic = '" + profilePic + '\'' +
                        ",lname = '" + lname + '\'' +
                        "}";
    }
}