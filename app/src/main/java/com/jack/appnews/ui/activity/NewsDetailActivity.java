package com.jack.appnews.ui.activity;

import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jack.appnews.BuildConfig;
import com.jack.appnews.R;
import com.jack.appnews.bean.NewsListBean;
import com.jack.appnews.bean.NewsListBean.DataBean.ListBean;
import com.jack.appnews.ui.BaseActivity;

import java.lang.reflect.Field;

import butterknife.BindView;

import static com.jack.appnews.R.id.pb_title;

/**
 * 新闻详情页 - Activity
 */
public class NewsDetailActivity extends BaseActivity implements View.OnClickListener{
    @Nullable
    @BindView(R.id.btn_back)
    Button mBtnBack;

    @BindView(R.id.tv_title_text)
    TextView mTextViewTitle;

    @BindView(pb_title)
    ProgressBar mProgressBarTitle;

    @BindView(R.id.wv_content)
    WebView mWebView;

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_news_detail;
    }

    @Override
    protected void initViews() {
        mBtnBack.setOnClickListener(this);

        initData();
    }

    private void initData() {
        ListBean newsDataItem = (ListBean) getIntent().getSerializableExtra("news_data");

        loadInWebView(newsDataItem);
//        if (newsDataItem != null) {
//            if (newsDataItem.getContent_type() == 1){ //view中打开
//                loadInLocalView(newsDataItem);
//            }else{//web view中打开
//                loadInWebView(newsDataItem);
//            }
//        }
    }

    private void loadInLocalView(ListBean newsDataItem){

    }

    /**
     * WebView中加载详情
     * @param newsDataItem
     */
    private void loadInWebView(ListBean newsDataItem) {
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mProgressBarTitle.setVisibility(View.VISIBLE);
        mTextViewTitle.setText(newsDataItem.getNews_title());
        mWebView.loadUrl(newsDataItem.getWeb_url());
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    // 网页加载完成
                    mProgressBarTitle.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (android.os.Build.VERSION.SDK_INT < 16) {
            try {
                Field field = WebView.class.getDeclaredField("mWebViewCore");
                field = field.getType().getDeclaredField("mBrowserFrame");
                field = field.getType().getDeclaredField("sConfigCallback");
                field.setAccessible(true);
                field.set(null, null);
            } catch (NoSuchFieldException e) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace();
                }
            }
        } else {
            try {
                Field sConfigCallback = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                if (sConfigCallback != null) {
                    sConfigCallback.setAccessible(true);
                    sConfigCallback.set(null, null);
                }
            } catch (NoSuchFieldException e) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace();
                }
            } catch (IllegalAccessException e) {
                if (BuildConfig.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}