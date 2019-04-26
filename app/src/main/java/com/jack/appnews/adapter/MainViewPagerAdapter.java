package com.jack.appnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private String[] mTabTitles;
    private Fragment[] mFragmentArrays;

    public MainViewPagerAdapter(FragmentManager fm, String[] mTabTitles, Fragment[] mFragmentArrays) {
        super(fm);
        this.mTabTitles = mTabTitles;
        this.mFragmentArrays = mFragmentArrays;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentArrays[position];
    }

    @Override
    public int getCount() {
        return mFragmentArrays.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles[position];
    }
}