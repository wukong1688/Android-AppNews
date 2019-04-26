package com.jack.appnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.bean.NewsListBean.DataBean.ListBean;
import com.jack.appnews.util.GlideUtil;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ListBean> items;
    private ClickListener clickListener;

    public NewsListRecycleAdapter(Context context, List<ListBean> items) {
        this.context = context;
        this.items = items;
    }

    public interface ClickListener {
        void onItemClick(View v, int position, List<ListBean> items);
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list_style_1, parent, false);
                viewHolder = new ViewHolderOne(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list_style_2, parent, false);
                viewHolder = new ViewHolderThree(view);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final XRecyclerView.ViewHolder holder, int position) {
        ListBean newsBean = items.get(position);
        switch (getItemViewType(position)) {
            case 1: //1张图 情况
                ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
                viewHolderOne.tvTitle.setText(newsBean.getNews_title());
                viewHolderOne.tvCateName.setText(newsBean.getSource_name());

                //加载图片
                if (newsBean.getImg_list() != null && newsBean.getImg_list().size() == 1) {
                    GlideUtil.load(context, newsBean.getImg_list().get(0), viewHolderOne.ivImage);
                }
                break;
            case 2: //3张图 情况
                ViewHolderThree viewHolderThree = (ViewHolderThree) holder;
                viewHolderThree.tvTitle.setText(newsBean.getNews_title());
                viewHolderThree.tvCateName.setText(newsBean.getSource_name());

                if (newsBean.getImg_list() != null && newsBean.getImg_list().size() == 3) {
                    GlideUtil.load(context, newsBean.getImg_list().get(0), viewHolderThree.ivImage1);
                    GlideUtil.load(context, newsBean.getImg_list().get(1), viewHolderThree.ivImage2);
                    GlideUtil.load(context, newsBean.getImg_list().get(2), viewHolderThree.ivImage3);
                }
                break;
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

    //1张图
    public static class ViewHolderOne extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_cate_name)
        TextView tvCateName;
        @BindView(R.id.iv_main_img)
        ImageView ivImage;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        public ViewHolderOne(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    //3张图
    public static class ViewHolderThree extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_cate_name)
        TextView tvCateName;
        @BindView(R.id.iv_main_img1)
        ImageView ivImage1;
        @BindView(R.id.iv_main_img2)
        ImageView ivImage2;
        @BindView(R.id.iv_main_img3)
        ImageView ivImage3;
        @BindView(R.id.ll_item)
        LinearLayout llItem;

        public ViewHolderThree(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}