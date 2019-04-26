package com.jack.appnews.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.jack.appnews.R;
import com.jack.appnews.ui.BaseActivity;

/**
 * 启动跳转页
 */
public class SplashActivity extends BaseActivity {
    private int jumpTime = 2000;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_splash;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int value = msg.what;
            switch (value) {
                case 1:
                    startActivity(new Intent(SplashActivity.this, LaunchAdActivity.class));
                    finish();
                    break;
            }
        }
    };

    @Override
    protected void initViews() {
        mHandle.sendEmptyMessageDelayed(1, jumpTime);
    }

    @Override
    public void onBackPressed() {
    }
}
