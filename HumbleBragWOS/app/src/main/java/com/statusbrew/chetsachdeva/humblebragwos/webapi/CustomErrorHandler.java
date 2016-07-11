package com.statusbrew.chetsachdeva.humblebragwos.webapi;

import android.content.Context;
import android.content.Intent;
import com.statusbrew.chetsachdeva.humblebragwos.R;
import retrofit.ErrorHandler;
import retrofit.RetrofitError;

/**
 * Converts the complex error structure into a single string you can get with error.getLocalizedMessage() in Retrofit error handlers.
 * Also deals with there being no network available
 * <p/>
 * Uses a few string IDs for user-visible error messages
 */
public class CustomErrorHandler implements ErrorHandler {
    private final Context ctx;
    private final String TAG = "CustomErrorHandler";

    public CustomErrorHandler(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public Throwable handleError(RetrofitError cause) {
        String errorDescription = "";
        if (cause.getKind().equals(RetrofitError.Kind.NETWORK)) {
            errorDescription = ctx.getString(R.string.error_network);
        } else {
            if (cause.getResponse() == null) {
                errorDescription = ctx.getString(R.string.error_no_response);
            } else {
                if (cause.getResponse().getStatus() == 401) {
                    logout(ctx.getApplicationContext());
                } else {
                    errorDescription = cause.getMessage();
                }
            }
        }

        return new Exception(errorDescription.trim());
    }

    static void logout(Context context) {
//        Prefs.clear();
//        Intent mStartActivity = new Intent(context, DashboardActivity.class).putExtra("Session Expired", true);
//        if (mStartActivity != null) {
//            mStartActivity.setAction(Intent.ACTION_MAIN);
//            mStartActivity.addCategory(Intent.CATEGORY_HOME);
//            mStartActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            mStartActivity.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            mStartActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            context.startActivity(mStartActivity);
//        }
    }
}