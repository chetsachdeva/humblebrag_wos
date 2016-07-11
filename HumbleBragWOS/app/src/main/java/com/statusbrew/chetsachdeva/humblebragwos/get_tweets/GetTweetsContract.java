package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public interface GetTweetsContract {

    void getTweetsForScreenName(String screenName, int count, Listener listener);

    interface View{
        void showProgress();
        void hideProgress();
        void onGetTweetsSuccess(ArrayList<TwitterTweet> twitterTweets);
        void onGetTweetsFailure(String message);
    }

    interface Presenter{
        void getTweetsForScreenName(String screenName, int count);
    }

    interface Listener{
        void onGetTweetsSuccess(ArrayList<TwitterTweet> twitterTweets);
        void onGetTweetsFailure(String message);
    }
}
