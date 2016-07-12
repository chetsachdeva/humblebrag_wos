package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;

import java.util.ArrayList;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public interface GetTweetsContract {

    void getTweetsForScreenName(String screenName, int count, int currentPage, Listener listener);

    interface View{
        void showProgress();
        void hideProgress();
        void onGetTweetsSuccess(ArrayList<GetTweetsResponse> twitterTweets);
        void onGetTweetsFailure(String message);
        void onLoadMore();
    }

    interface Presenter{
        void getTweetsForScreenName(String screenName, int count, int currentPage);
    }

    interface Listener{
        void onGetTweetsSuccess(ArrayList<GetTweetsResponse> getTweetsResponseArrayList);
        void onGetTweetsFailure(String message);
    }
}
