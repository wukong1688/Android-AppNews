package com.jack.appnews.ui.fragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.jack.appnews.R;
import com.jack.appnews.adapter.VideoListRecycleAdapter;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.bean.ItemVideoBean;
import com.jack.appnews.mock.ImageListConstant;
import com.jack.appnews.mock.VideoListConstant;
import com.jack.appnews.ui.BaseFragment;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * 每个单独标签-视频列表 Fragment
 */
public class TabVideoFragment extends BaseFragment implements XRecyclerView.LoadingListener {
    private Context mContext;

    @BindView(R.id.x_recycle_list)
    XRecyclerView mRecyclerView;

    private VideoListRecycleAdapter mAdapter;
    private List<ItemVideoBean> mList = new ArrayList<>();
    private int times = 0;

    public static Fragment newInstance() {
        TabVideoFragment fragment = new TabVideoFragment();
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
        mAdapter = new VideoListRecycleAdapter(mContext, mList);
        mRecyclerView.setAdapter(mAdapter);

        //4)实现 下拉刷新和加载更多 接口
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

        //设置点击视频全屏时，默认横屏播放
        JZVideoPlayer.FULLSCREEN_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        JZVideoPlayer.NORMAL_ORIENTATION = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    /**
     * 生成数据实例
     */
    private List<ItemVideoBean> genData() {
        List<ItemVideoBean> list = new ArrayList<>();
        int len = VideoListConstant.videoTitleList.length;
        for (int i = 0; i < len; i++) {
            list.add(new ItemVideoBean(VideoListConstant.videoTitleList[i], VideoListConstant.videoCateList[i],
                    VideoListConstant.videoImgList[i], VideoListConstant.videoUrlList[i], 1));
        }
        for (int i = 0; i < len; i++) {
            list.add(new ItemVideoBean(VideoListConstant.videoTitleList[i], VideoListConstant.videoCateList[i],
                    VideoListConstant.videoImgList[i], VideoListConstant.videoUrlList[i], 1));
        }
        for (int i = 0; i < len; i++) {
            list.add(new ItemVideoBean(VideoListConstant.videoTitleList[i], VideoListConstant.videoCateList[i],
                    VideoListConstant.videoImgList[i], VideoListConstant.videoUrlList[i], 1));
        }

        Collections.shuffle(list);
        return list;
    }

    @Override
    public void onRefresh() {
        times = 0;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.clear(); //先要清掉数据

                List<ItemVideoBean> list = genData();
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
                    List<ItemVideoBean> list = genData();
                    mList.addAll(list); //直接将数据追加到后面

                    mRecyclerView.loadMoreComplete();
                    mAdapter.notifyDataSetChanged();
                }
            }, 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    List<ItemVideoBean> list = genData();
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