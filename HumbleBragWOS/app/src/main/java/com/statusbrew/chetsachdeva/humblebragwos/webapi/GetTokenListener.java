package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterAuthToken;

public interface GetTokenListener {
    void onGetTokenSuccess(TwitterAuthToken twitterAuthToken);
    void onGetTokenFailure(String message);
}