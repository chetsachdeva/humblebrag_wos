package com.statusbrew.chetsachdeva.humblebragwos.get_tweets;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.statusbrew.chetsachdeva.humblebragwos.R;
import com.statusbrew.chetsachdeva.humblebragwos.adapters.GetTweetsAdapter;
import com.statusbrew.chetsachdeva.humblebragwos.show_image.FullScreenActivity;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.GetTweetsResponse;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets.Retweeted_status;
import com.statusbrew.chetsachdeva.humblebragwos.widgets.progress.CustomProgressDialog;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetTweetsActivity extends AppCompatActivity implements GetTweetsContract.View {

    @Bind(R.id.rv_tweets)
    RecyclerView rvTweets;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tv_toolbar_title)
    TextView tvToolbarTitle;

    ArrayList<Retweeted_status> twitterTweetsList;
    GetTweetsAdapter getTweetsAdapter;
    GetTweetsContract.Presenter presenter;

    CustomProgressDialog progressDialog;
    final String twitterScreenName = "humblebrag";
    final int MAX_COUNT = 100;

    int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_tweets);
        ButterKnife.bind(this);

        setToolbar();
        setRecyclerView();

        presenter = new GetTweetsPresenterImpl(this);
        presenter.getTweetsForScreenName(twitterScreenName, 10, currentPage);
    }

    public void setToolbar() {
        if (null != toolbar) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setIcon(R.drawable.ic_navigation_icon);
            tvToolbarTitle.setText(R.string.hb_retweeted);
        }
    }

    public void setRecyclerView() {
        twitterTweetsList = new ArrayList<>();
        rvTweets.setHasFixedSize(true);
        rvTweets.setLayoutManager(new LinearLayoutManager(this));
        getTweetsAdapter = new GetTweetsAdapter(this, this, twitterTweetsList);
        rvTweets.setAdapter(getTweetsAdapter);
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
    public void onGetTweetsSuccess(ArrayList<GetTweetsResponse> getTweetsResponseArrayList) {
        for (GetTweetsResponse getTweet : getTweetsResponseArrayList) {
            if (null != getTweet) {
                if (null != getTweet.getRetweeted_status()) {
                    twitterTweetsList.add(getTweet.getRetweeted_status());
                }
            }
        }
        getTweetsAdapter.notifyDataSetChanged();
    }

    @Override
    public void onGetTweetsFailure(String message) {
        Toast.makeText(GetTweetsActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadMore() {
        if (twitterTweetsList.size() <= MAX_COUNT) {
            currentPage++;
            presenter.getTweetsForScreenName(twitterScreenName, 10, currentPage);
        } else {
            Toast.makeText(GetTweetsActivity.this, "You have made a century!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onImageClicked(int position) {
        Intent intent = new Intent(this, FullScreenActivity.class);
        intent.putExtra("position", position);
        intent.putExtra("imagesList", getImagesList());
        startActivity(intent);
    }

    public ArrayList<String> getImagesList() {
        ArrayList<String> imagesList = new ArrayList<>();
        for (Retweeted_status tweets : twitterTweetsList) {
            if(null!=tweets.getUser().getProfile_image_url()) {
                imagesList.add(tweets.getUser().getOriginal_profile_image_url());
            }
        }
        return imagesList;
    }
}
