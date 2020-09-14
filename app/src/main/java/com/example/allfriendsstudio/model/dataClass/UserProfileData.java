package com.example.allfriendsstudio.model.dataClass;

import java.io.Serializable;

public class UserProfileData implements Serializable {
    private String userName;
    private String userMail;
    private String userContactNo;
    private Object userBio;
    private String fname;
    private Object lastSeen;
    private String profilePic;
    private String lname;
    private Object userFaceimgPath;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
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

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Object getUserFaceimgPath() {
        return userFaceimgPath;
    }

    public void setUserFaceimgPath(Object userFaceimgPath) {
        this.userFaceimgPath = userFaceimgPath;
    }

    @Override
    public String toString() {
        return
                "UserProfileData{" +
                        "user_name = '" + userName + '\'' +
                        ",user_mail = '" + userMail + '\'' +
                        ",user_contact_no = '" + userContactNo + '\'' +
                        ",user_bio = '" + userBio + '\'' +
                        ",fname = '" + fname + '\'' +
                        ",last_seen = '" + lastSeen + '\'' +
                        ",profile_pic = '" + profilePic + '\'' +
                        ",lname = '" + lname + '\'' +
                        ",user_faceimg_path = '" + userFaceimgPath + '\'' +
                        "}";
    }
}