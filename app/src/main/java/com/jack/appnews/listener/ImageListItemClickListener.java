package com.jack.appnews.listener;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jack.appnews.adapter.ImageListRecycleAdapter;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.ui.activity.PhotoViewActivity;

import java.util.List;

public class ImageListItemClickListener implements ImageListRecycleAdapter.ClickListener {
    private Context mContext;

    public ImageListItemClickListener(Context context) {
        mContext = context;
    }

    @Override
    public void onItemClick(View v, int position, List<ItemImageBean> items) {
        Intent intent = new Intent(mContext, PhotoViewActivity.class);
        Bundle bundle = new Bundle();
//        bundle.putSerializable("dataBean", items.get(position - 1));
        bundle.putSerializable("dataBean", items.get(position));
        intent.putExtras(bundle);
        intent.putExtra("curPos", 0);

        mContext.startActivity(intent);
    }
}