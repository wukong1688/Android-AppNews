package com.jack.appnews.ui.fragment;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;

import com.jack.appnews.R;
import com.jack.appnews.adapter.NewsListRecycleAdapter;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.bean.NewsListBean;
import com.jack.appnews.bean.NewsListBean.DataBean.ListBean;
import com.jack.appnews.listener.NewsListItemClickListener;
import com.jack.appnews.mock.ImageListConstant;
import com.jack.appnews.mock.NewsListConstant;
import com.jack.appnews.ui.BaseFragment;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;

/**
 * 每个单独标签-新闻列表 Fragment
 */
public class TabNewsFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    private Context mContext;

    @BindView(R.id.x_recycle_list)
    XRecyclerView mRecyclerView;

    private NewsListRecycleAdapter mAdapter;
    private List<ListBean> mList = new ArrayList<>();
    private int times = 0;

    public static Fragment newInstance() {
        TabNewsFragment fragment = new TabNewsFragment();
        return fragment;
    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_tab_recycle_list;
    }

    @Override
    protected void prepare() {
        mContext = getContext();
    }

    protected void initViews() {
        //1)初始化RecyclerView设置
        initSettingList();

        //2)添加布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //3)配置Adapter
        mList = genData();
        mAdapter = new NewsListRecycleAdapter(mContext, mList);
        mRecyclerView.setAdapter(mAdapter);

        //4) 监听 点击,注意是监听 mAdapter ，而不是 mRecyclerView
        mAdapter.setOnItemClickListener(new NewsListItemClickListener(mContext));

        //5)实现 下拉刷新和加载更多 接口
        mRecyclerView.setLoadingListener(this);
    }

    /**
     * 初始化设置 RecycleList 列表
     */
    private void initSettingList() {
        mRecyclerView.setPullRefreshEnabled(true);
        mRecyclerView.setLoadingMoreEnabled(true);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);
    }

    @NonNull
    /**
     * 生成数据实例
     */
    private List<ListBean> genData() {
        List<ListBean> mList = new ArrayList<>();
        int len = NewsListConstant.newsTitleList.length;
        for (int i = 0; i < len; i++) {
            mList.add(new ListBean(NewsListConstant.newsTitleList[i], NewsListConstant.newsCateList[i],
                    1, NewsListConstant.newsUrlList[i], arrayToList(NewsListConstant.newsImgList[i])));
        }
        for (int i = 0; i < len; i++) {
            mList.add(new ListBean(NewsListConstant.newsTitleList[i], NewsListConstant.newsCateList[i],
                    2, NewsListConstant.newsUrlList[i], arrayToList(NewsListConstant.newsImgList[i])));
        }
        for (int i = 0; i < len; i++) {
            mList.add(new ListBean(NewsListConstant.newsTitleList[i], NewsListConstant.newsCateList[i],
                    1, NewsListConstant.newsUrlList[i], arrayToList(NewsListConstant.newsImgList[i])));
        }

        Collections.shuffle(mList);//打乱顺序输出，为了美观
        return mList;
    }

    public List<String> arrayToList(String[] arr) {
        List<String> list = new ArrayList<>();
        for (String val : arr) {
            list.add(val);
        }
        return list;
    }

    @Override
    public void onRefresh() {
        times = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.clear(); //先要清掉数据

                List<NewsListBean.DataBean.ListBean> list = genData();
                mList.addAll(list); //再将数据插入到前面

                mAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete(); //下拉刷新完成
            }
        }, 1000);
    }

    @Override
    public void onLoadMore() {
        if (times < 2) {//加载2次后，就不再加载更多
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    List<ListBean> list = genData();
                    mList.addAll(list); //直接将数据追加到后面

                    mRecyclerView.loadMoreComplete();
                    mAdapter.notifyDataSetChanged();
                }
            }, 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    List<ListBean> list = genData();
                    mList.addAll(list); //将数据追加到后面

                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.setNoMore(true);
                }
            }, 1000);
        }
        times++;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mRecyclerView != null) {
            mRecyclerView.destroy();
            mRecyclerView = null;
        }
    }
}