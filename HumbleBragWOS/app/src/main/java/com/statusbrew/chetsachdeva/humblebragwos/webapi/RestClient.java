package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import android.content.Context;
import android.content.Intent;

import com.pixplicity.easyprefs.library.Prefs;
import com.squareup.okhttp.OkHttpClient;
import com.statusbrew.chetsachdeva.humblebragwos.utils.Constants;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.WebApi;

import java.util.concurrent.TimeUnit;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/*
 * Creates a RestClient used to hit API with Endpoint : http://staging.kulcare.com/api/ and Header as Authorization Token
 */
public class RestClient {

    static Context ctx;
    private static WebApi REST_CLIENT;

    public RestClient(Context ctx) {
        this.ctx = ctx;
        setupRestClient();
    }

    private static void setupRestClient() {

        TokenManager tokenManager = new TokenManagerImpl(ctx);

        OkHttpClient ok = new OkHttpClient();
        ok.setReadTimeout(30, TimeUnit.SECONDS);
        ok.setWriteTimeout(30, TimeUnit.SECONDS);
        ok.setConnectTimeout(10, TimeUnit.SECONDS);
        ok.setRetryOnConnectionFailure(true);
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(Constants.TWITTER_API_URL)
                .setClient(new OkClient(ok))
                .setRequestInterceptor(new TokenInterceptor(tokenManager))
                .setErrorHandler(new CustomErrorHandler(ctx))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(WebApi.class);
    }

    public static WebApi get() {
        if (null != REST_CLIENT) {
            return REST_CLIENT;
        } else {
            setupRestClient();
            return REST_CLIENT;
        }
    }

    static class TokenInterceptor implements RequestInterceptor {

        private final TokenManager mTokenManager;

        private TokenInterceptor(TokenManager tokenManager) {
            mTokenManager = tokenManager;
        }

        @Override
        public void intercept(RequestFacade request) {
            if (mTokenManager.hasToken()) {
                request.addHeader("Authorization", "Bearer " + mTokenManager.getToken());
            } else {
                mTokenManager.clearToken();
                mTokenManager.refreshToken();
                request.addHeader("Authorization", "Bearer " + mTokenManager.getToken());
            }
        }
    }
}
