package com.jack.appnews.ui.activity;


import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.jack.appnews.App;
import com.jack.appnews.R;
import com.jack.appnews.ui.BaseActivity;
import com.jack.appnews.ui.fragment.ImageListFragment;
import com.jack.appnews.ui.fragment.MineFragment;
import com.jack.appnews.ui.fragment.NewsListFragment;
import com.jack.appnews.ui.fragment.VideoListFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;

public class MainActivity extends BaseActivity implements TabHost.OnTabChangeListener {
    @BindView(android.R.id.tabhost)
    FragmentTabHost mTabHost;

    private List<Fragment> mFragmentList;
    private Class mClass[] = {NewsListFragment.class, VideoListFragment.class, ImageListFragment.class, MineFragment.class};
    private Fragment mFragment[] = {new NewsListFragment(), new VideoListFragment(), new ImageListFragment(), new MineFragment()};
    private String mTitles[] = {"首页", "视频", "图片", "我的"};
    private int mImages[] = {
            R.drawable.main_tab_btn_news,
            R.drawable.main_tab_btn_video,
            R.drawable.main_tab_btn_image,
            R.drawable.main_tab_btn_mine
    };
    private long exitTime = 0;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        mFragmentList = new ArrayList<>();
        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_content);
        mTabHost.getTabWidget().setDividerDrawable(null);

        for (int i = 0; i < mFragment.length; i++) {
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTitles[i]).setIndicator(getTabView(i));
            mTabHost.addTab(tabSpec, mClass[i], null);
            mFragmentList.add(mFragment[i]);
            mTabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.WHITE);
        }
    }

    private View getTabView(int index) {
        View view = LayoutInflater.from(this).inflate(R.layout.main_tab_indicator, null);

        ImageView image = (ImageView) view.findViewById(R.id.iv_tab_icon);
        TextView title = (TextView) view.findViewById(R.id.tv_tab_text);

        image.setImageResource(mImages[index]);
        title.setText(mTitles[index]);

        return view;
    }

    @Override
    public void onTabChanged(String tabId) {
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View v = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                v.setSelected(true);
            } else {
                v.setSelected(false);
            }
        }
        supportInvalidateOptionsMenu();
    }

    @Override
    protected void onResume() {
        super.onResume();
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }

        if ((System.currentTimeMillis() - exitTime) > 2000) {
            App.toast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();

        //暂停时播放器状态恢复
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_SENSOR;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }
}