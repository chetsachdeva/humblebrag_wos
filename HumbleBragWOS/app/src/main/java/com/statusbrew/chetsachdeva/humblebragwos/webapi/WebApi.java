package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by chetsachdeva on 10-07-2016.
 */
public interface WebApi {

    String apiVersion = "/1.1/";

    @GET(apiVersion + "statuses/user_timeline.json")
    void getTweetsForScreenName(@Query("screen_name") String screenName, @Query("count") String count, Callback<ArrayList<TwitterTweet>> callback);


}
