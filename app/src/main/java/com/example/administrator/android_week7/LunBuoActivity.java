package com.example.administrator.android_week7;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qf.utillibary.base.BaseActivity;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class LunBuoActivity extends BaseActivity {

    WebView webView;
    ImageView iv;

    String http=null;

    @Override
    public int getContentViewId() {
        return R.layout.activity_lunbuo;
    }

    @Override
    protected void init() {
        super.init();
        ActionBar actionBar = getSupportActionBar();
        actionBar.show();//默认情况是显示。可以不调用该方法。
        actionBar.hide();//隐藏ActionBar

        Intent intent = getIntent();
        http=intent.getStringExtra("http");
       // Toast.makeText(this,http,Toast.LENGTH_SHORT).show();

        webView = (WebView)findViewById(R.id.webview);
        iv = (ImageView)findViewById(R.id.iv_lunbo_top);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(http);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
