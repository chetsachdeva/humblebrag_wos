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
import com.statusbrew.chetsachdeva.humblebragwos.get_tweets.GetTweetsContract;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.Retweeted_status;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetTweetsAdapter extends RecyclerView.Adapter<GetTweetsAdapter.ViewHolder> {

    Context context;
    GetTweetsContract.View view;
    ArrayList<Retweeted_status> twitterTweetList;

    public GetTweetsAdapter(Context context, GetTweetsContract.View view, ArrayList<Retweeted_status> twitterTweetList) {
        this.context = context;
        this.view = view;
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
        Retweeted_status retweetedStatus = twitterTweetList.get(position);
        if (null != retweetedStatus) {
            if (null != retweetedStatus.getText()) {
                holder.tvTweet.setText(retweetedStatus.getText());
            } else {
                holder.tvTweet.setText(R.string.tweet);
            }
            if (null != retweetedStatus.getUser()) {
                if (null != retweetedStatus.getUser().getName()) {
                    holder.tvName.setText(retweetedStatus.getUser().getName());
                } else {
                    holder.tvName.setText(R.string.name);
                }
                if (null != retweetedStatus.getUser().getScreen_name()) {
                    holder.tvScreenName.setText("@" + retweetedStatus.getUser().getScreen_name());
                } else {
                    holder.tvScreenName.setText("");
                }
                if (null != retweetedStatus.getUser().getProfile_image_url()) {
                    holder.sdvPP.setImageURI(Uri.parse(retweetedStatus.getUser().getBigger_profile_image_url()));
                    holder.sdvPP.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            view.onImageClicked(position);
                        }
                    });
                } else {
                    holder.sdvPP.setImageURI(Uri.parse("res:///" + R.drawable.ic_placeholder));
                }
            }
        } else {
            holder.tvName.setText(R.string.name);
            holder.tvTweet.setText(R.string.tweet);
            holder.sdvPP.setImageURI(Uri.parse("res:///" + R.drawable.ic_placeholder));
            holder.tvScreenName.setText("");
        }
        if ((position >= getItemCount() - 1)) {
            view.onLoadMore();
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
        @Bind(R.id.tv_screenName)
        TextView tvScreenName;
        @Bind(R.id.tv_tweet)
        TextView tvTweet;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}