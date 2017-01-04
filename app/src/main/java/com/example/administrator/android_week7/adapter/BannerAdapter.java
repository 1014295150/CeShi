package com.example.administrator.android_week7.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class BannerAdapter extends PagerAdapter {

    List<View> view;

    public BannerAdapter(List<View> view) {
        this.view = view;
    }

    @Override
    public int getCount() {
        return view.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(view.get(position));
        return view.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((View)object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
