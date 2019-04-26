package com.jack.appnews.ui.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.jack.appnews.R;
import com.jack.appnews.adapter.MainViewPagerAdapter;
import com.jack.appnews.ui.BaseFragment;
import com.jack.appnews.util.TabLayoutUtil;

import butterknife.BindView;

/**
 * 视频列表 - Fragment
 */
public class VideoListFragment extends BaseFragment {
    @BindView(R.id.tab_layout_video_list)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_video_list)
    ViewPager viewPager;

    private String[] mTabTitles = new String[8];
    private Fragment[] mFragArrays = new Fragment[8];

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_video_list;
    }

    @Override
    protected void initViews() {
        bindData();
    }

    private void bindData() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayoutUtil.reflex(tabLayout); //修复 文本显示宽度问题

        mTabTitles[0] = "推荐";
        mTabTitles[1] = "直播";
        mTabTitles[2] = "影视";
        mTabTitles[3] = "游戏";
        mTabTitles[4] = "音乐";
        mTabTitles[5] = "综艺";
        mTabTitles[6] = "搞笑";
        mTabTitles[7] = "时尚";

        mFragArrays[0] = TabVideoFragment.newInstance();
        mFragArrays[1] = TabVideoFragment.newInstance();
        mFragArrays[2] = TabVideoFragment.newInstance();
        mFragArrays[3] = TabVideoFragment.newInstance();
        mFragArrays[4] = TabVideoFragment.newInstance();
        mFragArrays[5] = TabVideoFragment.newInstance();
        mFragArrays[6] = TabVideoFragment.newInstance();
        mFragArrays[7] = TabVideoFragment.newInstance();

        //1)设置适配器
        PagerAdapter pagerAdapter = new MainViewPagerAdapter(getFragmentManager(), mTabTitles, mFragArrays);
        viewPager.setAdapter(pagerAdapter);

        //2)将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }


}