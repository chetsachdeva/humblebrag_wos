package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import android.util.Base64;
import android.os.AsyncTask;

import com.google.gson.Gson;
import com.statusbrew.chetsachdeva.humblebragwos.utils.Constants;
import com.statusbrew.chetsachdeva.humblebragwos.utils.HttpUtil;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.models.TwitterAuthToken;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetTokenAsyncTask extends AsyncTask<Object, Void, TwitterAuthToken> {

    GetTokenListener listener;

    public GetTokenAsyncTask(GetTokenListener listener) {
        this.listener=listener;
    }

    @Override
    protected TwitterAuthToken doInBackground(Object... params) {
        TwitterAuthToken twitterAuthToken = null;
        try {
            String twitterUrlApiKey = URLEncoder.encode(Constants.TWITTER_API_KEY, "UTF-8");
            String twitterUrlApiSecret = URLEncoder.encode(Constants.TWITTER_API_SECRET, "UTF-8");
            String twitterKeySecret = twitterUrlApiKey + ":" + twitterUrlApiSecret;
            String twitterKeyBase64 = Base64.encodeToString(twitterKeySecret.getBytes(), Base64.NO_WRAP);
            twitterAuthToken = getTwitterAuthToken(twitterKeyBase64);
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        } catch (IllegalStateException ex1) {
            ex1.printStackTrace();
        }
        return twitterAuthToken;
    }

    @Override
    protected void onPostExecute(TwitterAuthToken twitterAuthToken) {
        if (null != twitterAuthToken) {
            listener.onGetTokenSuccess(twitterAuthToken);
        }else{
            listener.onGetTokenFailure("Unable to fetch token");
        }
    }

    public TwitterAuthToken getTwitterAuthToken(String twitterKeyBase64) throws UnsupportedEncodingException {
        HttpPost httpPost = new HttpPost(Constants.TWITTER_TOKEN_URL);
        httpPost.setHeader("Authorization", "Basic " + twitterKeyBase64);
        httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
        httpPost.setEntity(new StringEntity("grant_type=client_credentials"));
        HttpUtil httpUtil = new HttpUtil();
        String twitterJsonResponse = httpUtil.getHttpResponse(httpPost);
        return convertJsonToTwitterAuthToken(twitterJsonResponse);
    }

    private TwitterAuthToken convertJsonToTwitterAuthToken(String jsonAuth) {
        TwitterAuthToken twitterAuthToken = null;
        if (jsonAuth != null && jsonAuth.length() > 0) {
            try {
                Gson gson = new Gson();
                twitterAuthToken = gson.fromJson(jsonAuth, TwitterAuthToken.class);
            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            }
        }
        return twitterAuthToken;
    }
}
