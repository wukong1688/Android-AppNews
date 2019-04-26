package com.jack.appnews.listener;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.jack.appnews.adapter.NewsListRecycleAdapter;
import com.jack.appnews.bean.NewsListBean;
import com.jack.appnews.ui.activity.NewsDetailActivity;

import java.util.List;

/**
 * 新闻列表
 * 点击  监听
 */
public class NewsListItemClickListener implements NewsListRecycleAdapter.ClickListener {
    private Context mContext;

    public NewsListItemClickListener(Context context) {
        mContext = context;
    }

    @Override
    public void onItemClick(View v, int position, List<NewsListBean.DataBean.ListBean> items) {
        Intent intent = new Intent(mContext, NewsDetailActivity.class);
        intent.putExtra("news_data", items.get(position - 1));
        mContext.startActivity(intent);
    }
}