package com.jack.appnews.ui.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.jack.appnews.R;
import com.jack.appnews.adapter.ImageListRecycleAdapter;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.bean.ItemVideoBean;
import com.jack.appnews.listener.ImageListItemClickListener;
import com.jack.appnews.listener.NewsListItemClickListener;
import com.jack.appnews.mock.ImageListConstant;
import com.jack.appnews.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 图片列表 只用RecyclerView展现
 */
public class ImageListFragment extends BaseFragment {
    private Context mContext;
    private List<ItemImageBean> mList = new ArrayList<>();

    @BindView(R.id.image_recycle_list)
    RecyclerView mRecyclerView;

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_image_list;
    }

    @Override
    protected void prepare() {
        mContext = getContext();
    }

    @Override
    protected void initViews() {
        //1)添加布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        //2)配置Adapter
        mList = genData();
        ImageListRecycleAdapter mAdapter = new ImageListRecycleAdapter(mContext, mList);
        mRecyclerView.setAdapter(mAdapter);

        //3)监听 点击,注意是监听 mAdapter ，而不是 mRecyclerView
        mAdapter.setOnItemClickListener(new ImageListItemClickListener(mContext));
    }

    /**
     * 生成数据实例
     */
    private List<ItemImageBean> genData() {
        List<ItemImageBean> mList = new ArrayList<>();
        int len = ImageListConstant.titleList.length;
        for (int i = 0; i < len; i++) {
            mList.add(new ItemImageBean(ImageListConstant.titleList[i], ImageListConstant.thumbImgList[i],
                    ImageListConstant.detailImgUrls[i]));
        }
        for (int i = 0; i < len; i++) {
            mList.add(new ItemImageBean(ImageListConstant.titleList[i], ImageListConstant.thumbImgList[i],
                    ImageListConstant.detailImgUrls[i]));
        }
        for (int i = 0; i < len; i++) {
            mList.add(new ItemImageBean(ImageListConstant.titleList[i], ImageListConstant.thumbImgList[i],
                    ImageListConstant.detailImgUrls[i]));
        }
        return mList;
    }


}