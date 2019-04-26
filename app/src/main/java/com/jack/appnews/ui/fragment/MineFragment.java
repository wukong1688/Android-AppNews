package com.jack.appnews.ui.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jack.appnews.R;
import com.jack.appnews.ui.BaseFragment;
import com.jack.appnews.ui.activity.MineAboutUsActivity;
import com.jack.appnews.util.CleanCacheUtils;

import butterknife.BindView;

/**
 * 我的
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.ll_clear)
    LinearLayout llClear;
    @BindView(R.id.ll_about)
    LinearLayout llAbout;
    @BindView(R.id.tv_cache)
    TextView mCache;
    private ProgressDialog mProgressDialog;//清理缓存时的对话框

    @Override
    protected int inflateLayoutId() {
        return R.layout.fragment_mine_list;
    }

    @Override
    protected void initViews() {
        llClear.setOnClickListener(this);
        llAbout.setOnClickListener(this);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandle = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int value = msg.what;
            switch (value) {
                case 1:
                    mProgressDialog.dismiss();
                    mCache.setText(msg.getData().getString("cacheSize"));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.ll_clear: //清除缓存
                clearHistory();
                break;
            case R.id.ll_about: //关于我们
                startActivity(new Intent(getActivity(), MineAboutUsActivity.class));
                break;
        }
    }

    /**
     * 清除历史记录
     */
    public void clearHistory() {
        mProgressDialog = ProgressDialog.show(getActivity(), null, "清除记录中...",
                true, false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                cleanDatabase();
                // 通知历史记录发生变化
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Message msg = Message.obtain();
                msg.what = 1;
                mHandle.sendMessage(msg);
            }
        }).start();

    }

    /**
     * 清除本应用数据库文件 和mDiskLruCache的大小
     *
     * @return
     */
    private void cleanDatabase() {
        try {
            CleanCacheUtils.cleanDatabases(getActivity());
            CleanCacheUtils.cleanExternalDatabases(getActivity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}