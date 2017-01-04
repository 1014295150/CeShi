package com.example.administrator.android_week7;

import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.XinfangBean;
import com.example.administrator.android_week7.adapter.XinfangAdapter;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.qf.utillibary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class XinfanListActivity extends BaseActivity {

    private int id =0;
    private String urils = "";



    @Override
    public int getContentViewId() {
        return R.layout.activity_xinfan_list;
    }

    @Override
    protected void init() {
        super.init();


        Intent intent = getIntent();
        id = Integer.valueOf(intent.getStringExtra("id"));
        urils = String.format(ShowsJieko.NEW_HOUSE_INFO,id);

        TextView tv = (TextView)findViewById(R.id.tv_list_xing);
        tv.setText(urils);



    }

}
