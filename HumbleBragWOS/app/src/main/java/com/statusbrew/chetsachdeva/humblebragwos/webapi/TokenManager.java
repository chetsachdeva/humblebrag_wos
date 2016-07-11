package com.statusbrew.chetsachdeva.humblebragwos.webapi;


/**
 * Created by deepaksingh on 16/05/16.
 */
public interface TokenManager {
    String getToken();
    boolean hasToken();
    void clearToken();
    void refreshToken();
}
