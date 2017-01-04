package com.example.administrator.android_week7;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.XinfangBean;
import com.example.administrator.android_week7.Task.MyXinfanTask;
import com.example.administrator.android_week7.adapter.XinfangAdapter;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.qf.utillibary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class XinfangActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    int cityId;
    String urils = "";
    String id = "";
    boolean ismore;

    TextView tv;
    ListView lv;
    ImageView iv;

    int page = 1;

    List<XinfangBean> data;
    XinfangAdapter adapter;

    @Override
    public int getContentViewId() {
        return R.layout.activity_xinfang;
    }

    @Override
    protected void init() {
        super.init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.show();//默认情况是显示。可以不调用该方法。
        actionBar.hide();//隐藏ActionBar

        Intent intent = getIntent();
        cityId = intent.getIntExtra("cityid", 4);
        id = String.valueOf(cityId);

        urils = String.format(ShowsJieko.LOOKING_NEWHOUSE, page, id);

        Log.d("TAG", urils + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        //初始化
        setinit();
        //设置数据源
        data = new ArrayList<>();
        //创建适配器
        adapter = new XinfangAdapter(this, data);
        //设置适配器
        lv.setAdapter(adapter);

        getTask(page);

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == 0 && ismore) {
                    ++page;
                    getTask(page);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                ismore = ((firstVisibleItem + visibleItemCount) == totalItemCount);
            }
        });

        //设置每行的监听器
        lv.setOnItemClickListener(this);


        //设置头部返回
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //启动异步任务
    public void getTask(int pages) {
        urils = String.format(ShowsJieko.LOOKING_NEWHOUSE, page, id);
        MyXinfanTask task = new MyXinfanTask(new MyXinfanTask.Callbacks() {
            @Override
            public void getListData(List<XinfangBean> lists) {
                data.addAll(lists);
                tv.setText("共有" + data.size() + "座楼栋");
                adapter.notifyDataSetChanged();
            }
        });

        task.execute(urils);

    }

    //初始化
    private void setinit() {
        tv = (TextView) findViewById(R.id.tv_xingfang_num);
        lv = (ListView) findViewById(R.id.lv_xinfangss);
        iv = (ImageView) findViewById(R.id.iv_top_dao_xing);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               XinfangBean bean = data.get(position);
               Intent intent = new Intent(XinfangActivity.this,XinfanListActivity.class);
               intent.putExtra("id",bean.getFid());
               startActivity(intent);

    }


}