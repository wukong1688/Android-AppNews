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
 * 新闻列表 - Fragment
 */
public class NewsListFragment extends BaseFragment {
    @BindView(R.id.tab_layout_news_list)
    TabLayout tabLayout;
    @BindView(R.id.view_pager_news_list)
    ViewPager viewPager;

    private String[] mTabTitles = new String[7];
    private Fragment[] mFragArrays = new Fragment[7];

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_news_list;
    }

    @Override
    protected void initViews() {
        bindData();
    }

    private void bindData() {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        TabLayoutUtil.reflex(tabLayout); //修复 文本显示宽度问题

        mTabTitles[0] = "推荐";
        mTabTitles[1] = "热点";
        mTabTitles[2] = "科技";
        mTabTitles[3] = "大数据";
        mTabTitles[4] = "健康";
        mTabTitles[5] = "互联网";
        mTabTitles[6] = "人工智能";

        mFragArrays[0] = TabNewsFragment.newInstance();
        mFragArrays[1] = TabNewsFragment.newInstance();
        mFragArrays[2] = TabNewsFragment.newInstance();
        mFragArrays[3] = TabNewsFragment.newInstance();
        mFragArrays[4] = TabNewsFragment.newInstance();
        mFragArrays[5] = TabNewsFragment.newInstance();
        mFragArrays[6] = TabNewsFragment.newInstance();

        //1)设置适配器
        PagerAdapter pagerAdapter = new MainViewPagerAdapter(getFragmentManager(), mTabTitles, mFragArrays);
        viewPager.setAdapter(pagerAdapter);

        //2)将ViewPager和TabLayout绑定
        tabLayout.setupWithViewPager(viewPager);
    }


}