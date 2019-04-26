package com.jack.appnews.util;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * WebViewUtil
 */
public class WebViewUtil {

    public static WebView loadUrl(Context context, String url) {
        WebView webView = new WebView(context);
        webView.setWebViewClient(new WebViewClient() {
            //设置在webView点击打开的新网页在当前界面显示,而不跳转到新的浏览器中
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);  //设置WebView属性,运行执行js脚本
        webView.loadUrl(url);          //调用loadUrl方法为WebView加入链接
        return webView;
    }
}