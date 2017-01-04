package com.example.administrator.android_week7.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_week7.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.BaseFragment;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class TuNewFragment extends BaseFragment {

    TextView tv;
    ImageView iv;



    @Override
    protected int getContentView() {
        return R.layout.fragment_new_zixun;
    }

    @Override
    protected void init(View view) {
        super.init(view);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(getContext());
        ImageLoader.getInstance().init(configuration);

        Bundle bundle=getArguments();
        String text = bundle.getString("tu_text");
        String http=bundle.getString("tu_http");

        Log.d("TAG","text="+text+":http="+http+"===============================================");

        tv = (TextView) view.findViewById(R.id.tv_view_new);
        iv = (ImageView)view.findViewById(R.id.iv_view_new);

        tv.setText(text);
        ImageLoader.getInstance().displayImage(http,iv);

    }
}
