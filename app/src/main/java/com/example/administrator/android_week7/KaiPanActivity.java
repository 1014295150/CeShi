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
 * Created by Administrator on 2016/9/30 0030.
 */
public class KaiPanActivity extends BaseActivity {

    private int id = 0;
    private String utils="";
    private int page = 1;
    boolean ismore=false;

    ListView lv;
    TextView tv;
    ImageView iv;

    List<XinfangBean> data;

    XinfangAdapter adapter;





    @Override
    public int getContentViewId() {
        return R.layout.activity_kaipan;

    }

    @Override
    protected void init() {
        super.init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.show();//默认情况是显示。可以不调用该方法。
        actionBar.hide();//隐藏ActionBar

        Intent intent = getIntent();
        id = intent.getIntExtra("cityid",4);

        //初始化
        setinit();
        //创建数据源
        data = new ArrayList<>();
        //创建适配器
        adapter = new XinfangAdapter(this,data);
        //设置适配器
        lv.setAdapter(adapter);
        //启动异步任务
        setTask(page);
        //设置下拉jiant
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState==0&&ismore){
                    ++page;
                    setTask(page);
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                 ismore=(firstVisibleItem+visibleItemCount)==totalItemCount;
            }
        });

        //设置lv监听
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XinfangBean bean = data.get(position);
                Intent intent = new Intent(KaiPanActivity.this,XinfanListActivity.class);
                intent.putExtra("id",bean.getFid());
                startActivity(intent);
            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    //启动异步任务
    private void setTask(int pages) {

        utils = String.format(ShowsJieko.NEWEST_HOUSE,page,id);
        MyXinfanTask task = new MyXinfanTask(new MyXinfanTask.Callbacks() {

            @Override
            public void getListData(List<XinfangBean> lists) {
                    data.addAll(lists);
                    tv.setText("当前共有"+data.size()+"座楼房");
                    adapter.notifyDataSetChanged();
            }
        });
        Log.d("TAG",utils);
        task.execute(utils);

    }

    //初始化
    private void setinit() {
        lv = (ListView)findViewById(R.id.lv_kaipan);
        tv=  (TextView)findViewById(R.id.tv_kaipan);
        iv = (ImageView)findViewById(R.id.iv_top_dao_kaipan);

    }
}
