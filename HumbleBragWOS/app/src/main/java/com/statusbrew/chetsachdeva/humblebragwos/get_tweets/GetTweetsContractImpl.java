package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.RestClient;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public class GetTweetsContractImpl implements GetTweetsContract {
    @Override
    public void getTweetsForScreenName(String screenName, int count, final Listener listener) {
        RestClient.get().getTweetsForScreenName(screenName, String.valueOf(count), new Callback<ArrayList<TwitterTweet>>() {
            @Override
            public void success(ArrayList<TwitterTweet> twitterTweets, Response response) {
                if(null!=twitterTweets){
                    if(twitterTweets.size()>0){
                        listener.onGetTweetsSuccess(twitterTweets);
                    }
                }
            }

            @Override
            public void failure(RetrofitError error) {
                listener.onGetTweetsFailure(error.getLocalizedMessage());
            }
        });
    }
}
