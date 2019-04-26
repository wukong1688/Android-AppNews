package com.jack.appnews.bean;

public class ItemVideoBean {
    private int video_id;
    private String video_title;
    private String source_name;
    private String thumb_img;
    private String video_url;
    private int content_type;

    public ItemVideoBean(String video_title, String source_name, String thumb_img, String video_url, int content_type) {
        this.video_title = video_title;
        this.source_name = source_name;
        this.thumb_img = thumb_img;
        this.video_url = video_url;
        this.content_type = content_type;
    }

    public int getVideo_id() {
        return video_id;
    }

    public void setVideo_id(int video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public String getThumb_img() {
        return thumb_img;
    }

    public void setThumb_img(String thumb_img) {
        this.thumb_img = thumb_img;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getContent_type() {
        return content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }
}