package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.pixplicity.easyprefs.library.Prefs;
import com.statusbrew.chetsachdeva.humblebragwos.utils.Constants;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterAuthToken;

public class TokenManagerImpl implements TokenManager {

    Context ctx;

    public TokenManagerImpl(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public String getToken() {
        return Prefs.getString(Constants.AUTH_TOKEN, Constants.AUTH_TOKEN);
    }

    @Override
    public boolean hasToken() {
        if (Prefs.contains(Constants.AUTH_TOKEN)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clearToken() {
        SharedPreferences.Editor editor = Prefs.edit();
        editor.remove(Constants.AUTH_TOKEN);
        editor.remove(Constants.IS_USER_AUTHENTICATED);
        editor.commit();
    }

    @Override
    public synchronized void refreshToken() {
        new GetTokenAsyncTask(new GetTokenListener() {
            @Override
            public void onGetTokenSuccess(TwitterAuthToken twitterAuthToken) {
                Prefs.putString(Constants.AUTH_TOKEN, twitterAuthToken.getAccess_token());
            }

            @Override
            public void onGetTokenFailure(String message) {
                Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
            }
        }).execute();
    }
}
