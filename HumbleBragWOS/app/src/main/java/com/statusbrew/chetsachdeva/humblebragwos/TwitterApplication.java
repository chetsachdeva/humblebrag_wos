package com.statusbrew.chetsachdeva.humblebragwos;

import android.app.Application;
import android.os.SystemClock;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.pixplicity.easyprefs.library.Prefs;
import com.statusbrew.chetsachdeva.humblebragwos.webapi.RestClient;

import java.util.concurrent.TimeUnit;

/**
 * Created by chetsachdeva on 11-07-2016.
 */
public class TwitterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Prefs.Builder()                       // Initialize Prefs
                .setContext(getApplicationContext())
                .build();
        Fresco.initialize(this);                  // Initialize Fresco
        new RestClient(getApplicationContext());  // Initialise REST client
    }
}
