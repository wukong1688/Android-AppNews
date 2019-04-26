package com.jack.appnews.ui.activity;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.ui.BaseActivity;
import com.jack.appnews.util.WebViewUtil;

import butterknife.BindView;

/**
 * 关于我们
 */
public class MineAboutUsActivity extends BaseActivity implements View.OnClickListener {
    private Context mContext;

    @BindView(R.id.btn_back)
    Button mBtnBack;
    @BindView(R.id.project_address)
    TextView mAddress;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initViews() {
        mContext = MineAboutUsActivity.this;
        mBtnBack.setOnClickListener(this);
        mAddress.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.project_address:
                String githubUrl = "https://github.com/wukong1688/Android-AppNews";
                WebView webView = WebViewUtil.loadUrl(mContext, githubUrl);
                setContentView(webView);
                break;
        }
    }

}