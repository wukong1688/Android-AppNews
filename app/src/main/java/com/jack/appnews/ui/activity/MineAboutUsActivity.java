package com.jack.appnews.ui.activity;

import android.view.View;
import android.widget.Button;

import com.jack.appnews.R;
import com.jack.appnews.ui.BaseActivity;

import butterknife.BindView;

public class MineAboutUsActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_back)
    Button mBtnBack;

    @Override
    protected int inflateLayoutId() {
        return R.layout.activity_about_us;
    }

    @Override
    protected void initViews() {
        mBtnBack.setOnClickListener(this);
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