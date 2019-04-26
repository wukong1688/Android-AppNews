package com.jack.appnews.bean;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

import java.util.List;

@Entity(nameInDb = "new_list")
public class DBNewsBean {
    @Id(autoincrement = true)
    private long id;

    private int news_id;
    private String news_title;
    private int content_type;
    private String web_url;
    private int created;
    private String source_name;

    //转 String 存储
    @Convert(columnType = String.class, converter = String_Converter.class)
    private List<String> img_list_str;


    public String getSource_name() {
        return this.source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public int getCreated() {
        return this.created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getWeb_url() {
        return this.web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    public int getContent_type() {
        return this.content_type;
    }

    public void setContent_type(int content_type) {
        this.content_type = content_type;
    }

    public String getNews_title() {
        return this.news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public int getNews_id() {
        return this.news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getImg_list_str() {
        return this.img_list_str;
    }

    public void setImg_list_str(List<String> img_list_str) {
        this.img_list_str = img_list_str;
    }

    @Generated(hash = 969840521)
    public DBNewsBean(long id, int news_id, String news_title, int content_type,
                      String web_url, int created, String source_name, List<String> img_list_str) {
        this.id = id;
        this.news_id = news_id;
        this.news_title = news_title;
        this.content_type = content_type;
        this.web_url = web_url;
        this.created = created;
        this.source_name = source_name;
        this.img_list_str = img_list_str;
    }

    @Generated(hash = 1584064865)
    public DBNewsBean() {
    }
}