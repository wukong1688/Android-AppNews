package com.jack.appnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.bean.ItemImageBean;
import com.jack.appnews.util.GlideUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageListRecycleAdapter extends RecyclerView.Adapter<ImageListRecycleAdapter.ViewHolder> {
    private Context context;
    private List<ItemImageBean> items;
    private ClickListener clickListener;

    public ImageListRecycleAdapter(Context context, List<ItemImageBean> items) {
        this.context = context;
        this.items = items;
    }

    public interface ClickListener {
        void onItemClick(View v, int position, List<ItemImageBean> items);
    }

    public void setOnItemClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_list_style, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ItemImageBean dataBean = items.get(position);

        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvTitle.setText(dataBean.getTitle());
        viewHolder.tvCount.setText(dataBean.getDetail_urls().length + "图");

        //加载缩略图片
        if (dataBean.getThumb_url() != null && !TextUtils.isEmpty(dataBean.getThumb_url())) {
            GlideUtil.load(context, dataBean.getThumb_url(), viewHolder.ivThumbImg);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = holder.getLayoutPosition();
                clickListener.onItemClick(holder.itemView, pos, items);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //图片
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_count)
        TextView tvCount;
        @BindView(R.id.iv_thumb_img)
        ImageView ivThumbImg;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}