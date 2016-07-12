package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.adapters.GetTweetsAdapter;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.TwitterTweet;
import com.statusbrew.chetsachdeva.humblebragwos.widgets.progress.CustomProgressDialog;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetTweetsActivity extends AppCompatActivity implements GetTweetsContract.View{

    @Bind(R.id.rv_tweets)
    RecyclerView rvTweets;
    CustomProgressDialog progressDialog;

    LinearLayoutManager linearLayoutManager;
    ArrayList<GetTweetsResponse> twitterTweetsList;
    GetTweetsAdapter getTweetsAdapter;
    GetTweetsContract.Presenter presenter;

    final static String twitterScreenName = "humblebrag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tweets);
        ButterKnife.bind(this);
        presenter = new GetTweetsPresenterImpl(this);

        twitterTweetsList = new ArrayList<>();
        rvTweets.setHasFixedSize(true);
        linearLayoutManager = new LinearLayoutManager(this);
        rvTweets.setLayoutManager(linearLayoutManager);
        getTweetsAdapter = new GetTweetsAdapter(this, twitterTweetsList);
        rvTweets.setAdapter(getTweetsAdapter);

        presenter.getTweetsForScreenName(twitterScreenName, 10);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void showProgress() {
        if (progressDialog == null) {
            progressDialog = new CustomProgressDialog(this);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    @Override
    public void hideProgress() {
        if (null != progressDialog) {
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }
    }

    @Override
    public void onGetTweetsSuccess(ArrayList<GetTweetsResponse> twitterTweets) {
        this.twitterTweetsList.addAll(twitterTweets);
        getTweetsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetTweetsFailure(String message) {
        Toast.makeText(GetTweetsActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
