package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterTweet;

import java.util.ArrayList;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public class GetTweetsPresenterImpl implements GetTweetsContract.Presenter, GetTweetsContract.Listener {

    GetTweetsContract contract;
    GetTweetsContract.View view;

    public GetTweetsPresenterImpl(GetTweetsContract.View view) {
        this.view = view;
        this.contract = new GetTweetsContractImpl();
    }

    @Override
    public void getTweetsForScreenName(String screenName, int count) {
        view.showProgress();
        contract.getTweetsForScreenName(screenName, 10, this);
    }


    @Override
    public void onGetTweetsSuccess(ArrayList<TwitterTweet> twitterTweets) {
        view.hideProgress();
        view.onGetTweetsSuccess(twitterTweets);
    }

    @Override
    public void onGetTweetsFailure(String message) {
        view.hideProgress();
        view.onGetTweetsFailure(message);
    }
}
