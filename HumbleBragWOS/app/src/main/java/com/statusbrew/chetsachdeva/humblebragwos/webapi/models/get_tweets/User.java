
package com.statusbrew.chetsachdeva.humblebragwos.webapi.models.get_tweets;

import com.google.gson.annotations.Expose;

public class User {

    @Expose
    String profile_sidebar_fill_color;
    @Expose
    String profile_sidebar_border_color;
    @Expose
    Boolean profile_background_tile;
    @Expose
    String name;
    @Expose
    String profile_image_url;
    @Expose
    String created_at;
    @Expose
    String location;
    @Expose
    Boolean follow_request_sent;
    @Expose
    String profile_link_color;
    @Expose
    Boolean is_translator;
    @Expose
    String id_str;
    @Expose
    Entities_ entities;
    @Expose
    Boolean default_profile;
    @Expose
    Boolean contributors_enabled;
    @Expose
    Integer favourites_count;
    @Expose
    String url;
    @Expose
    String profile_image_url_https;
    @Expose
    Integer utc_offset;
    @Expose
    Long id;
    @Expose
    Boolean profile_use_background_image;
    @Expose
    Integer listed_count;
    @Expose
    String profile_text_color;
    @Expose
    String lang;
    @Expose
    Integer followers_count;
    @Expose
    Boolean _protected;
    @Expose
    Object notifications;
    @Expose
    String profile_background_image_url_https;
    @Expose
    String profile_background_color;
    @Expose
    Boolean verified;
    @Expose
    Boolean geo_enabled;
    @Expose
    String time_zone;
    @Expose
    String description;
    @Expose
    Boolean default_profile_image;
    @Expose
    String profile_background_image_url;
    @Expose
    Integer statuses_count;
    @Expose
    Integer friends_count;
    @Expose
    Object following;
    @Expose
    Boolean show_all_inline_media;
    @Expose
    String screen_name;

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getProfile_sidebar_fill_color() {
        return profile_sidebar_fill_color;
    }

    public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
        this.profile_sidebar_fill_color = profile_sidebar_fill_color;
    }

    public String getProfile_sidebar_border_color() {
        return profile_sidebar_border_color;
    }

    public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
        this.profile_sidebar_border_color = profile_sidebar_border_color;
    }

    public Boolean getProfile_background_tile() {
        return profile_background_tile;
    }

    public void setProfile_background_tile(Boolean profile_background_tile) {
        this.profile_background_tile = profile_background_tile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_image_url() {
        return profile_image_url;
    }
    public String getBigger_profile_image_url() {
        return profile_image_url.replace("normal","bigger");
    }
    public String getOriginal_profile_image_url() {
        return profile_image_url.replace("_normal","");
    }

    public void setProfile_image_url(String profile_image_url) {
        this.profile_image_url = profile_image_url;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getFollow_request_sent() {
        return follow_request_sent;
    }

    public void setFollow_request_sent(Boolean follow_request_sent) {
        this.follow_request_sent = follow_request_sent;
    }

    public String getProfile_link_color() {
        return profile_link_color;
    }

    public void setProfile_link_color(String profile_link_color) {
        this.profile_link_color = profile_link_color;
    }

    public Boolean getIs_translator() {
        return is_translator;
    }

    public void setIs_translator(Boolean is_translator) {
        this.is_translator = is_translator;
    }

    public String getId_str() {
        return id_str;
    }

    public void setId_str(String id_str) {
        this.id_str = id_str;
    }

    public Entities_ getEntities() {
        return entities;
    }

    public void setEntities(Entities_ entities) {
        this.entities = entities;
    }

    public Boolean getDefault_profile() {
        return default_profile;
    }

    public void setDefault_profile(Boolean default_profile) {
        this.default_profile = default_profile;
    }

    public Boolean getContributors_enabled() {
        return contributors_enabled;
    }

    public void setContributors_enabled(Boolean contributors_enabled) {
        this.contributors_enabled = contributors_enabled;
    }

    public Integer getFavourites_count() {
        return favourites_count;
    }

    public void setFavourites_count(Integer favourites_count) {
        this.favourites_count = favourites_count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getProfile_image_url_https() {
        return profile_image_url_https;
    }

    public void setProfile_image_url_https(String profile_image_url_https) {
        this.profile_image_url_https = profile_image_url_https;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getProfile_use_background_image() {
        return profile_use_background_image;
    }

    public void setProfile_use_background_image(Boolean profile_use_background_image) {
        this.profile_use_background_image = profile_use_background_image;
    }



}
