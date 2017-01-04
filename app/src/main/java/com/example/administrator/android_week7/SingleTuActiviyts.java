package com.example.administrator.android_week7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.administrator.android_week7.Fragments.ListPinlunFragment;
import com.example.administrator.android_week7.Fragments.ListZixunFragment;
import com.example.administrator.android_week7.adapter.ViewListAdapter;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.qf.utillibary.base.BaseActivity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class SingleTuActiviyts extends BaseActivity implements View.OnClickListener{

    String new_util = "";
    List<Fragment> framents;

    ViewListAdapter adapter;

    ViewPager viewpager;
    LinearLayout single_layout_mess,single_layout_pinlun;
    TextView tvs;
    ImageView ivs;
    ImageView iv_top,iv_icon;
    TextView tv_title;

    String id;
    int num;
    String conmentid;

    Boolean isCheckd=false;

    @Override

    public int getContentViewId() {
        return R.layout.activity_singletop;
    }

    @Override
    protected void init() {
        super.init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.show();//默认情况是显示。可以不调用该方法。
        actionBar.hide();//隐藏ActionBar

        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        num = intent.getIntExtra("num",0);
        conmentid = intent.getStringExtra("id_cont");
        new_util = String.format(ShowsJieko.NEWS_DETAIL, id);
        // Toast.makeText(this,new_util,Toast.LENGTH_SHORT).show();

        //初始化控件
        setinit();
        //添加数据源
        setadds();
        //设置ViewPager
        setViewPager();

    }
    //设置ViewPager
    private void setViewPager() {
        adapter = new ViewListAdapter(getSupportFragmentManager(),framents);
        viewpager.setAdapter(adapter);
        //设置监听
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position==1){
                    ivs.setVisibility(View.GONE);
                    tvs.setText("原文");
                    viewpager.setCurrentItem(1);
                    tv_title.setText("评论");
                }else{
                    ivs.setVisibility(View.VISIBLE);
                    tvs.setText(num+"");
                    viewpager.setCurrentItem(0);
                    tv_title.setText("房产咨询");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //添加数据源
    private void setadds() {
        framents = new ArrayList<>();
        framents.add(new ListZixunFragment());
        framents.add(new ListPinlunFragment());

        Bundle bundle = new Bundle();
        bundle.putString("id",id);
        bundle.putString("id_cont",conmentid);
        for (int i=0;i<framents.size();i++){
            framents.get(i).setArguments(bundle);
        }
    }

    private void setinit() {
       viewpager = (ViewPager)findViewById(R.id.singletu_view);
        single_layout_mess = (LinearLayout)findViewById(R.id.single_layout_mess);
        single_layout_pinlun= (LinearLayout)findViewById(R.id.single_layout_pinluns);
        tvs = (TextView)findViewById(R.id.tv_msg_s);
        ivs = (ImageView)findViewById(R.id.iv_msg_s);
        iv_top =(ImageView)findViewById(R.id.iv_top_dao);
        iv_icon = (ImageView)findViewById(R.id.iv_top_icon);
        tv_title = (TextView)findViewById(R.id.tv_top_title);

        //设置属性
        single_layout_mess.setBackgroundResource(R.drawable.btn_bg_msgslec);
        tvs.setText(num+"");

        //设置监听
        single_layout_mess.setOnClickListener(this);
        single_layout_pinlun.setOnClickListener(this);
        iv_top.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.single_layout_mess:{
                 isCheckd = !isCheckd;
                 //监听
                set_message(isCheckd);

            }
            break;
            case R.id.single_layout_pinluns:{

             }
            break;
            case R.id.iv_top_dao:{
                finish();
            }
            break;
        }
    }

    private void set_message(Boolean isCheckd) {
        if (isCheckd){
           ivs.setVisibility(View.GONE);
            tvs.setText("原文");
            viewpager.setCurrentItem(1);
            tv_title.setText("评论");
        }else{
            ivs.setVisibility(View.VISIBLE);
            tvs.setText(num+"");
            viewpager.setCurrentItem(0);
            tv_title.setText("房产咨询");
        }


    }
}
