
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Url {

    @Expose
    String expanded_url;
    @Expose
    String url;
    @Expose
    List<Integer> indices = new ArrayList<Integer>();
    @Expose
    String display_url;

    public String getExpanded_url() {
        return expanded_url;
    }

    public void setExpanded_url(String expanded_url) {
        this.expanded_url = expanded_url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public void setIndices(List<Integer> indices) {
        this.indices = indices;
    }

    public String getDisplay_url() {
        return display_url;
    }

    public void setDisplay_url(String display_url) {
        this.display_url = display_url;
    }
}
