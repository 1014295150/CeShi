package com.example.administrator.android_week7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.ContentBean;
import com.example.administrator.android_week7.Enterty.ZixunBean;
import com.example.administrator.android_week7.Fragments.ListPinlunFragment;
import com.example.administrator.android_week7.Fragments.ListZixunFragment;
import com.example.administrator.android_week7.Fragments.TuNewFragment;
import com.example.administrator.android_week7.Task.MyListPinTask;
import com.example.administrator.android_week7.Task.MyListTask;
import com.example.administrator.android_week7.adapter.ViewListAdapter;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.qf.utillibary.base.BaseActivity;
import com.qf.utillibary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class LinesTuActivity extends BaseActivity implements View.OnClickListener{

    String id;
    int num;
    String conmentid;
    String urils;
    List<Fragment> fragments;
    List<ZixunBean> datas;
    List<ContentBean> lists;
    boolean isCheckd=false;
    int positions=0;

    int cont=0;

    ViewPager viewpagers;

    LinearLayout single_layout_pinlun,single_layout_mess;
    TextView tvs,tv_title,textnum;
    ImageView ivs,iv_top,iv_icon;

    Bundle bundle=null;

    ViewListAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_linestu;
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
        urils = String.format(ShowsJieko.NEWS_DETAIL, id);
        // Toast.makeText(this,new_util,Toast.LENGTH_SHORT).show();

        LayoutInflater inflater = LayoutInflater.from(this);

        //初始化控件
        setinit();
        //添加数据源
        setaddsd();

    }
    //设置ViewPager
    private void setViewPagers() {
       adapter = new ViewListAdapter(getSupportFragmentManager(),fragments);

        //设置适配器
        viewpagers.setAdapter(adapter);
        //监听
        viewpagers.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 textnum.setText((position+1)+"");
                positions=position+1;
                if (position==(fragments.size()-1)){
                    ivs.setVisibility(View.GONE);
                    tvs.setText("原文");
                    tv_title.setText("评论");
                    textnum.setText("");

                }else {
                    ivs.setVisibility(View.VISIBLE);
                    tvs.setText(num+"");
                    tv_title.setText("/"+fragments.size());

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
    //添加数据源
    private void setaddsd() {
        fragments = new ArrayList<>();
        datas = new ArrayList<>();
        lists = new ArrayList<>();


        //设置ViewPager
        setViewPagers();

        MyListTask tasks= new MyListTask(new MyListTask.CallBacks() {
            @Override
            public void getData(List<ZixunBean> list) {
                datas.addAll(list);
                ZixunBean beans= datas.get(0);
                String title=beans.getTitle();
                String source=beans.getSource();
                String time=beans.getTime();
                lists.addAll(beans.getContent());
                int len = lists.size();




                for (int i=0;i<len+1;i++){
                    if (i<len){
                        ContentBean bean = null;
                        if (i%2!=0) {
                            TuNewFragment fragment = new TuNewFragment();
                            fragments.add(fragment);
                        }
                    }else{
                        ListPinlunFragment pinlun = new ListPinlunFragment();
                        fragments.add(pinlun);
                    }
                }

                int s=0;
                for (int i=0;i<len+1;i++){
                    if (i<len){
                        ContentBean bean = null;
                        if (i%2==0) {
                            bundle = new Bundle();
                            bean =lists.get(i);
                            bundle.putString("tu_http",bean.getValue());
                        }else{
                            bean =lists.get(i);
                            bundle.putString("tu_text", bean.getValue());
                            fragments.get(s).setArguments(bundle);
                            s++;

                        }
                    }else{
                        Bundle bundle = new Bundle();
                        bundle.putString("id",id);
                        bundle.putString("id_cont",conmentid);
                        fragments.get(fragments.size()-1).setArguments(bundle);
                    }
                }

                  tv_title.setText("/"+fragments.size());
                   adapter.notifyDataSetChanged();
            }


        });

        tasks.execute(urils);
    }

    //初始化控件
    private void setinit() {

        viewpagers = (ViewPager)findViewById(R.id.linesletu_view1);

        single_layout_mess = (LinearLayout)findViewById(R.id.single_layout_mess1);
        single_layout_pinlun= (LinearLayout)findViewById(R.id.single_layout_pinluns1);
        tvs = (TextView)findViewById(R.id.tv_msg_s1);
        ivs = (ImageView)findViewById(R.id.iv_msg_s1);
        iv_top =(ImageView)findViewById(R.id.iv_top_dao1);
        iv_icon = (ImageView)findViewById(R.id.iv_top_icon1);
        tv_title = (TextView)findViewById(R.id.tv_top_num2);
        textnum = (TextView)findViewById(R.id.tv_top_num1);

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
            case R.id.single_layout_mess1:{
                isCheckd = !isCheckd;
                //监听
                set_message(isCheckd);

            }
            break;
            case R.id.single_layout_pinluns1:{

            }
            break;
            case R.id.iv_top_dao1:{
                finish();
            }
            break;
        }
    }

    private void set_message(boolean isCheckds) {
        if (isCheckds){
            /*if (positions!=fragments.size()) {*/
                ivs.setVisibility(View.GONE);
                tvs.setText("原文");
                cont = positions;
                viewpagers.setCurrentItem(fragments.size() - 1);
                tv_title.setText("评论");
            /*}else {
                isCheckd=!isCheckds;
            }*/
        }else{
            ivs.setVisibility(View.VISIBLE);
            tvs.setText(num+"");
            tv_title.setText(fragments.size()+"");
            viewpagers.setCurrentItem(cont-1);
        }
    }
}
