
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

public class Entities_ {

    @Expose
    Url_ url;
    @Expose
    Description description;

    public Url_ getUrl() {
        return url;
    }

    public void setUrl(Url_ url) {
        this.url = url;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
