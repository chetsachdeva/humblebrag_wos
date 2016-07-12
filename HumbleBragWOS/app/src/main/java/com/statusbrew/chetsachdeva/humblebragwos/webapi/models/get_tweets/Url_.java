
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Url_ {

    @Expose
    List<Url__> urls = new ArrayList<Url__>();

    public List<Url__> getUrls() {
        return urls;
    }

    public void setUrls(List<Url__> urls) {
        this.urls = urls;
    }
}
