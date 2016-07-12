
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Description {

    @Expose
    List<Object> urls = new ArrayList<Object>();

    public List<Object> getUrls() {
        return urls;
    }

    public void setUrls(List<Object> urls) {
        this.urls = urls;
    }
}
