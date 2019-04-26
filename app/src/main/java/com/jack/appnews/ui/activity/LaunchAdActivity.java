package com.jack.appnews.ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.ui.BaseActivity;

import butterknife.BindView;

/**
 * 启动广告页
 */
public class LaunchAdActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    @BindView(R.id.tv_copyright)
    TextView tvCopyright;
    @BindView(R.id.btn_jump)
    Button mBtnJump;

    private int jumpTime = 4000;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_launch_ad;
    }

    @Override
    protected void initViews() {
        mBtnJump.setOnClickListener(this);
        tvCopyright.setText("Copyright © 2017--2019");

        showSplash();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_jump:
                gotoMainActivity();
                break;
            default:
                break;
        }
    }

    private void showSplash() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.splash_img);
        if (bitmap != null) {
            ivSplash.setImageBitmap(bitmap);
            countDownTimer.start();
            mBtnJump.setVisibility(View.VISIBLE);
            return;
        }
        gotoMainActivity();
    }

    private CountDownTimer countDownTimer = new CountDownTimer(jumpTime, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mBtnJump.setText(" 跳过 (" + millisUntilFinished / 1000 + "s) ");
        }

        @Override
        public void onFinish() {
            mBtnJump.setText(" 跳过 (" + 0 + "s) ");
            gotoMainActivity();
        }
    };

    /**
     * 跳转到主界面
     */
    private void gotoMainActivity() {
        startActivity(new Intent(LaunchAdActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onDestroy() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }
}
