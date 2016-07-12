
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

public class GetTweetsResponse {

    @Expose
    String coordinates;
    @Expose
    Boolean favorited;
    @Expose
    Boolean truncated;
    @Expose
    String created_at;
    @Expose
    String id_str;
    @Expose
    Entities entities;
    @Expose
    String in_reply_to_user_id_str;
    @Expose
    String contributors;
    @Expose
    String text;
    @Expose
    Integer retweet_count;
    @Expose
    String in_reply_to_status_id_str;
    @Expose
    Long id;
    @Expose
    String geo;
    @Expose
    Boolean retweeted;
    @Expose
    Boolean possibly_sensitive;
    @Expose
    String in_reply_to_user_id;
    @Expose
    String place;
    @Expose
    User user;
    @Expose
    String in_reply_to_screen_name;
    @Expose
    String source;
    @Expose
    String in_reply_to_status_id;
    @Expose
    public Retweeted_status retweeted_status;

    public Retweeted_status getRetweeted_status() {
        return retweeted_status;
    }

    public void setRetweeted_status(Retweeted_status retweeted_status) {
        this.retweeted_status = retweeted_status;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    public Boolean getTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public Entities getEntities() {
        return entities;
    }

    public void setEntities(Entities entities) {
        this.entities = entities;
    }

    public String getIn_reply_to_user_id_str() {
        return in_reply_to_user_id_str;
    }

    public void setIn_reply_to_user_id_str(String in_reply_to_user_id_str) {
        this.in_reply_to_user_id_str = in_reply_to_user_id_str;
    }

    public String getContributors() {
        return contributors;
    }

    public void setContributors(String contributors) {
        this.contributors = contributors;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRetweet_count() {
        return retweet_count;
    }

    public void setRetweet_count(Integer retweet_count) {
        this.retweet_count = retweet_count;
    }

    public String getIn_reply_to_status_id_str() {
        return in_reply_to_status_id_str;
    }

    public void setIn_reply_to_status_id_str(String in_reply_to_status_id_str) {
        this.in_reply_to_status_id_str = in_reply_to_status_id_str;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGeo() {
        return geo;
    }

    public void setGeo(String geo) {
        this.geo = geo;
    }

    public Boolean getRetweeted() {
        return retweeted;
    }

    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    public Boolean getPossibly_sensitive() {
        return possibly_sensitive;
    }

    public void setPossibly_sensitive(Boolean possibly_sensitive) {
        this.possibly_sensitive = possibly_sensitive;
    }

    public String getIn_reply_to_user_id() {
        return in_reply_to_user_id;
    }

    public void setIn_reply_to_user_id(String in_reply_to_user_id) {
        this.in_reply_to_user_id = in_reply_to_user_id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getIn_reply_to_screen_name() {
        return in_reply_to_screen_name;
    }

    public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
        this.in_reply_to_screen_name = in_reply_to_screen_name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIn_reply_to_status_id() {
        return in_reply_to_status_id;
    }

    public void setIn_reply_to_status_id(String in_reply_to_status_id) {
        this.in_reply_to_status_id = in_reply_to_status_id;
    }
}
