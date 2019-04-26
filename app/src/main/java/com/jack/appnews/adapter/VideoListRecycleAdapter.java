package com.jack.appnews.adapter;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.bean.ItemVideoBean;
import com.jack.appnews.util.GlideUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class VideoListRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ItemVideoBean> items;
    private ClickListener clickListener;

    public VideoListRecycleAdapter(Context context, List<ItemVideoBean> items) {
        this.context = context;
        this.items = items;
    }

    public interface ClickListener {
        void onItemClick(View v, int position, List<ItemVideoBean> items);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerView.ViewHolder viewHolder = null;

        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_list_style, parent, false);
                viewHolder = new ViewHolder(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final XRecyclerView.ViewHolder holder, int position) {
        ItemVideoBean dataBean = items.get(position);
        switch (getItemViewType(position)) {
            case 1: //情况1,暂时为了后续兼容
                ViewHolder viewHolder = (ViewHolder) holder;
                viewHolder.tvSourceName.setText(dataBean.getSource_name());
                viewHolder.videoPlayer.setUp(dataBean.getVideo_url(), JZVideoPlayerStandard.SCREEN_WINDOW_LIST
                        , dataBean.getVideo_title());

                //加载缩略图片
                if (dataBean.getThumb_img() != null && !TextUtils.isEmpty(dataBean.getThumb_img())) {
                    GlideUtil.load(context, dataBean.getThumb_img(), viewHolder.videoPlayer.thumbImageView);
                }

                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int pos = holder.getLayoutPosition();
//                clickListener.onItemClick(holder.itemView, pos, items);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getContent_type();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //1视频
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_video_source_name)
        TextView tvSourceName;
        @BindView(R.id.video_player)
        JZVideoPlayerStandard videoPlayer;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}