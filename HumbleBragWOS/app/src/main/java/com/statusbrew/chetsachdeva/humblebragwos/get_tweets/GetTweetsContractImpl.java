package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.RestClient;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public class GetTweetsContractImpl implements GetTweetsContract {
    @Override
    public void getTweetsForScreenName(String screenName, int count,int currentPage, final Listener listener) {
        HashMap<String, String> queryParams= new HashMap<>();
        queryParams.put("screen_name",screenName);
        queryParams.put("count",String.valueOf(count));
        queryParams.put("page",String.valueOf(currentPage));

        RestClient.get().getTweetsForScreenName(queryParams, new Callback<ArrayList<GetTweetsResponse>>() {
            @Override
            public void success(ArrayList<GetTweetsResponse> getTweetsResponseArrayList, Response response) {
                if(null!=getTweetsResponseArrayList){
                    if(getTweetsResponseArrayList.size()>0){
                        listener.onGetTweetsSuccess(getTweetsResponseArrayList);
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
