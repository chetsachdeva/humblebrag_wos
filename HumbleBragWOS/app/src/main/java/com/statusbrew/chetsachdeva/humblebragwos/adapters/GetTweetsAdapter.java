package com.statusbrew.chetsachdeva.humblebragwos.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.TwitterTweet;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetTweetsAdapter extends RecyclerView.Adapter<GetTweetsAdapter.ViewHolder> {

    Context context;
    ArrayList<GetTweetsResponse> twitterTweetList;

    public GetTweetsAdapter(Context context, ArrayList<GetTweetsResponse> twitterTweetList) {
        this.context = context;
        this.twitterTweetList = twitterTweetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_tweets_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tvName.setTag(position);
        GetTweetsResponse tweetsResponse = twitterTweetList.get(position);
        if (null != tweetsResponse) {
            if (null != tweetsResponse.getRetweeted_status()) {
                if (null != tweetsResponse.getRetweeted_status().getText()) {
                    holder.tvTweet.setText(tweetsResponse.getRetweeted_status().getText());
                }
                if (null != tweetsResponse.getRetweeted_status().getUser()) {
                    if (null != tweetsResponse.getRetweeted_status().getUser().getName()) {
                        holder.tvName.setText(tweetsResponse.getRetweeted_status().getUser().getName());
                    }
                    if (null != tweetsResponse.getRetweeted_status().getUser().getProfile_image_url()) {
                        holder.sdvPP.setImageURI(Uri.parse(tweetsResponse.getRetweeted_status().getUser().getProfile_image_url()));
                    }
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        return twitterTweetList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.sdv_pp)
        SimpleDraweeView sdvPP;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_tweet)
        TextView tvTweet;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}