package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by chetsachdeva on 10-07-2016.
 */
public interface WebApi {

    String apiVersion = "/1.1/";

    @GET(apiVersion + "statuses/user_timeline.json")
    void getTweetsForScreenName(@Query("screen_name") String screenName, @Query("count") String count, Callback<ArrayList<GetTweetsResponse>> callback);


}
