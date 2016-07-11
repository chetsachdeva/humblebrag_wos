package com.statusbrew.chetsachdeva.humblebragwos.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetTweetsAdapter extends RecyclerView.Adapter<GetTweetsAdapter.ViewHolder> {

    Context context;
    ArrayList<TwitterTweet> twitterTweetList;

    public GetTweetsAdapter(Context context, ArrayList<TwitterTweet> twitterTweetList) {
        this.context = context;
        this.twitterTweetList=twitterTweetList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.twitter_tweets_list, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.lisTextView.setTag(position);
        holder.lisTextView.setText(twitterTweetList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return twitterTweetList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.listTextView)
        TextView lisTextView;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}