
package com.example.allfriendsstudio.model.pojoClass;
import com.google.gson.annotations.SerializedName;

public class Friend {

    @SerializedName("fname")
    private Object mFname;
    @SerializedName("last_seen")
    private Object mLastSeen;
    @SerializedName("lname")
    private Object mLname;
    @SerializedName("profile_pic")
    private String mProfilePic;
    @SerializedName("user_bio")
    private Object mUserBio;
    @SerializedName("user_contact_no")
    private String mUserContactNo;
    @SerializedName("user_mail")
    private String mUserMail;
    @SerializedName("user_name")
    private String mUserName;

    public Object getFname() {
        return mFname;
    }

    public Object getLastSeen() {
        return mLastSeen;
    }

    public Object getLname() {
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

    public String getUserMail() {
        return mUserMail;
    }

    public String getUserName() {
        return mUserName;
    }

    public static class Builder {

        private Object mFname;
        private Object mLastSeen;
        private Object mLname;
        private String mProfilePic;
        private Object mUserBio;
        private String mUserContactNo;
        private String mUserMail;
        private String mUserName;

        public Friend.Builder withFname(Object fname) {
            mFname = fname;
            return this;
        }

        public Friend.Builder withLastSeen(Object lastSeen) {
            mLastSeen = lastSeen;
            return this;
        }

        public Friend.Builder withLname(Object lname) {
            mLname = lname;
            return this;
        }

        public Friend.Builder withProfilePic(String profilePic) {
            mProfilePic = profilePic;
            return this;
        }

        public Friend.Builder withUserBio(Object userBio) {
            mUserBio = userBio;
            return this;
        }

        public Friend.Builder withUserContactNo(String userContactNo) {
            mUserContactNo = userContactNo;
            return this;
        }

        public Friend.Builder withUserMail(String userMail) {
            mUserMail = userMail;
            return this;
        }

        public Friend.Builder withUserName(String userName) {
            mUserName = userName;
            return this;
        }

        public Friend build() {
            Friend friend = new Friend();
            friend.mFname = mFname;
            friend.mLastSeen = mLastSeen;
            friend.mLname = mLname;
            friend.mProfilePic = mProfilePic;
            friend.mUserBio = mUserBio;
            friend.mUserContactNo = mUserContactNo;
            friend.mUserMail = mUserMail;
            friend.mUserName = mUserName;
            return friend;
        }

    }

}
