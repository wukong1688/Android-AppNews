package com.jack.appnews.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jack.appnews.R;

public class GlideUtil {
    public static void load(Context context, String imgUrl, ImageView imageView) {
        try {
            Glide.with(context)
                    .load(imgUrl)
                    .crossFade()
                    .error(R.mipmap.ic_article_delete)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)//开启缓存
                    .into(imageView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}