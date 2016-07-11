package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterAuthToken;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;

public interface GetTokenListener {
    void onGetTokenSuccess(TwitterAuthToken twitterAuthToken);
    void onGetTokenFailure(String message);
}