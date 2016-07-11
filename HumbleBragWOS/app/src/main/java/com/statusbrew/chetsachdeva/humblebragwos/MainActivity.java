package com.statusbrew.chetsachdeva.humblebragwos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;
import com.statusbrew.chetsachdeva.humblebragwos.get_tweets.GetTweetsActivity;
import com.statusbrew.chetsachdeva.humblebragwos.utils.Constants;
import com.statusbrew.chetsachdeva.humblebragwos.utils.NetworkUtil;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.GetTokenAsyncTask;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.GetTokenListener;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterAuthToken;

public class MainActivity extends AppCompatActivity implements GetTokenListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (NetworkUtil.isConnected(this)) {
            if (Prefs.contains(Constants.AUTH_TOKEN)) {
                openGetTweetsActivity();
            } else {
               new GetTokenAsyncTask(this).execute();
            }
        } else {
            Toast.makeText(this, getString(R.string.error_network), Toast.LENGTH_SHORT);
        }
    }

    public void openGetTweetsActivity() {
        startActivity(new Intent(this, GetTweetsActivity.class));
        this.finish();
    }

    @Override
    public void onGetTokenSuccess(TwitterAuthToken twitterAuthToken) {
        Prefs.putString(Constants.AUTH_TOKEN, twitterAuthToken.getAccess_token());
        openGetTweetsActivity();
    }

    @Override
    public void onGetTokenFailure(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
