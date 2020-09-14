
package com.example.allfriendsstudio.model.pojoClass;

import com.google.gson.annotations.SerializedName;


public class UserProfile {

    @SerializedName("fname")
    private String mFname;
    @SerializedName("last_seen")
    private Object mLastSeen;
    @SerializedName("lname")
    private String mLname;
    @SerializedName("profile_pic")
    private String mProfilePic;
    @SerializedName("user_bio")
    private Object mUserBio;
    @SerializedName("user_contact_no")
    private String mUserContactNo;
    @SerializedName("user_faceimg_path")
    private Object mUserFaceimgPath;
    @SerializedName("user_mail")
    private String mUserMail;
    @SerializedName("user_name")
    private String mUserName;

    public String getFname() {
        return mFname;
    }

    public Object getLastSeen() {
        return mLastSeen;
    }

    public String getLname() {
        return mLname;
    }

    public String getProfilePic() {
        return mProfilePic;
    }

    public Object getUserBio() {
        return mUserBio;
    }

    public String getUserContactNo() {
        return mUserContactNo;
    }

    public Object getUserFaceimgPath() {
        return mUserFaceimgPath;
    }

    public String getUserMail() {
        return mUserMail;
    }

    public String getUserName() {
        return mUserName;
    }

    public static class Builder {

        private String mFname;
        private Object mLastSeen;
        private String mLname;
        private String mProfilePic;
        private Object mUserBio;
        private String mUserContactNo;
        private Object mUserFaceimgPath;
        private String mUserMail;
        private String mUserName;

        public UserProfile.Builder withFname(String fname) {
            mFname = fname;
            return this;
        }

        public UserProfile.Builder withLastSeen(Object lastSeen) {
            mLastSeen = lastSeen;
            return this;
        }

        public UserProfile.Builder withLname(String lname) {
            mLname = lname;
            return this;
        }

        public UserProfile.Builder withProfilePic(String profilePic) {
            mProfilePic = profilePic;
            return this;
        }

        public UserProfile.Builder withUserBio(Object userBio) {
            mUserBio = userBio;
            return this;
        }

        public UserProfile.Builder withUserContactNo(String userContactNo) {
            mUserContactNo = userContactNo;
            return this;
        }

        public UserProfile.Builder withUserFaceimgPath(Object userFaceimgPath) {
            mUserFaceimgPath = userFaceimgPath;
            return this;
        }

        public UserProfile.Builder withUserMail(String userMail) {
            mUserMail = userMail;
            return this;
        }

        public UserProfile.Builder withUserName(String userName) {
            mUserName = userName;
            return this;
        }

        public UserProfile build() {
            UserProfile userProfile = new UserProfile();
            userProfile.mFname = mFname;
            userProfile.mLastSeen = mLastSeen;
            userProfile.mLname = mLname;
            userProfile.mProfilePic = mProfilePic;
            userProfile.mUserBio = mUserBio;
            userProfile.mUserContactNo = mUserContactNo;
            userProfile.mUserFaceimgPath = mUserFaceimgPath;
            userProfile.mUserMail = mUserMail;
            userProfile.mUserName = mUserName;
            return userProfile;
        }

    }

}
