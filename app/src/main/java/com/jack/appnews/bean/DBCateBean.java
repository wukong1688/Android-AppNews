package com.jack.appnews.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "new_cate")
public class DBCateBean {
    private int cate_id;
    private String cate_name;
    public String getCate_name() {
        return this.cate_name;
    }
    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }
    public int getCate_id() {
        return this.cate_id;
    }
    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }
    @Generated(hash = 156994784)
    public DBCateBean(int cate_id, String cate_name) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
    }
    @Generated(hash = 1738002239)
    public DBCateBean() {
    }
}