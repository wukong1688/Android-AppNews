package com.jack.appnews.api;

import com.jack.appnews.bean.NewsCateBean;
import com.jack.appnews.bean.NewsDetailBean;
import com.jack.appnews.bean.NewsListBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NewsApi {
    String BASE_URL = "https://blog-static.cnblogs.com/files/wukong1688/";

    @GET("api_news_cate.js")
    Observable<NewsCateBean> cateList();

//    @GET("news_list_{cateId}")
//    Observable<NewsListBean> newsList(@Path("cateId") int cateId);
    @GET("api_news_list.js")
    Observable<NewsListBean> newsList();


//    @GET("news_detail_{newsId}")
//    Observable<NewsDetailBean> newsDetail(@Path("newsId") int newsId);
    @GET("api_news_detail.js")
    Observable<NewsDetailBean> newsDetail();

}