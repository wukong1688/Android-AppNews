package com.jack.appnews.ui.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.adapter.PhotoViewAdapter;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.ui.BaseActivity;
import com.jack.appnews.widget.PhotoViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片查看器
 */
public class PhotoViewActivity extends BaseActivity {
    private PhotoViewPager mViewPager;
    private int currentPosition;
    private PhotoViewAdapter adapter;
    private TextView mTvImageCount;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_photo_view;
    }

    @Override
    protected void initViews() {
        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
        mTvImageCount = (TextView) findViewById(R.id.tv_image_count);

        initData();
    }

    private void initData() {
        Intent intent = getIntent();
        currentPosition = intent.getIntExtra("curPos", 0);
        ItemImageBean dataBean = (ItemImageBean) intent.getSerializableExtra("dataBean");
        String[] detailUrls = dataBean.getDetail_urls();
        final int imgLen = detailUrls.length;

        List<String> mImgList = new ArrayList<>();
        for (int i = 0; i < imgLen; i++) {
            mImgList.add(detailUrls[i]);
        }

        adapter = new PhotoViewAdapter(mImgList, this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(currentPosition, false);
        mTvImageCount.setText(currentPosition + 1 + " /" + imgLen);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                mTvImageCount.setText(currentPosition + 1 + "/" + imgLen);
            }
        });
    }


}
