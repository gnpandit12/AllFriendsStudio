package com.example.allfriendsstudio.model.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.allfriendsstudio.R;
import com.example.allfriendsstudio.model.dataClass.FriendsData;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.FriendsListViewHolder> {

    public static final String TAG = "adapter";
    private Context mContext;
    private List<FriendsData> mFriendsDataList;

    public FriendsListAdapter(Context context, List<FriendsData> friendsDataList) {
        this.mContext = context;
        this.mFriendsDataList = friendsDataList;
        Log.d(TAG, "FriendsListAdapter: ");
    }

    @NonNull
    @Override
    public FriendsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_friends_list_view, parent, false);
        return new FriendsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendsListViewHolder holder, int position) {
        FriendsData friendsData = mFriendsDataList.get(position);

        if (friendsData.getFname() != null) {
            holder.firstNameTV.setText(friendsData.getFname().toString());
        }
        if (friendsData.getLname() != null) {
            holder.lastNameTV.setText(friendsData.getLname().toString());
        }
        if (friendsData.getUserBio() != null) {
            holder.bioTV.setText(friendsData.getUserBio().toString());
        }
        if (friendsData.getUserName() != null) {
            holder.userNameTV.setText(friendsData.getUserName());
        }
        if (friendsData.getUserMail() != null) {
            holder.emailTV.setText(friendsData.getUserMail());
        }
        if (friendsData.getUserContactNo() != null) {
            holder.contactNoTV.setText(friendsData.getUserContactNo());
        }

        if (friendsData.getProfilePic() != null) {
            Glide.with(mContext)
                    .load(friendsData.getProfilePic())
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
                    .into(holder.userProfileImageView);
        }


    }

    @Override
    public int getItemCount() {
        return mFriendsDataList.size();
    }

    public static class FriendsListViewHolder extends RecyclerView.ViewHolder {

        TextView firstNameTV, lastNameTV, lastSeenTV, contactNoTV, emailTV, userNameTV, bioTV;
        CircleImageView userProfileImageView;

        public FriendsListViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTV = itemView.findViewById(R.id.user_first_name_text_view);
            lastNameTV = itemView.findViewById(R.id.user_last_name_text_view);
            lastSeenTV = itemView.findViewById(R.id.user_last_seen_text_view);
            contactNoTV = itemView.findViewById(R.id.user_contact_text_view);
            emailTV = itemView.findViewById(R.id.user_email_text_view);
            userNameTV = itemView.findViewById(R.id.user_name_text_view);
            bioTV = itemView.findViewById(R.id.user_bio_text_view);
            userProfileImageView = itemView.findViewById(R.id.user_profile_image);
        }


    }

}
