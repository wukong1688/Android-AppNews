package com.jack.appnews.bean;

import java.io.Serializable;

public class ItemImageBean implements Serializable {
    private String title;
    private String thumb_url;
    private String[] detail_urls;

    public ItemImageBean(String title, String thumb_url) {
        this.title = title;
        this.thumb_url = thumb_url;
    }

    public ItemImageBean(String title, String thumb_url, String[] detail_urls) {
        this.title = title;
        this.thumb_url = thumb_url;
        this.detail_urls = detail_urls;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String[] getDetail_urls() {
        return detail_urls;
    }

    public void setDetail_urls(String[] detail_urls) {
        this.detail_urls = detail_urls;
    }
}