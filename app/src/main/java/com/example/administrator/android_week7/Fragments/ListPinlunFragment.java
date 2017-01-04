package com.example.administrator.android_week7.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.PinlunBean;
import com.example.administrator.android_week7.Enterty.TuBean;
import com.example.administrator.android_week7.Enterty.ZixunBean;
import com.example.administrator.android_week7.R;
import com.example.administrator.android_week7.Task.MyListPinTask;
import com.example.administrator.android_week7.Task.MyListTask;
import com.example.administrator.android_week7.Task.MyTuTask;
import com.example.administrator.android_week7.adapter.PinlunAdapter;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class ListPinlunFragment extends BaseFragment {

    private String id ="";
    private String cont_id="";
    private String utils = "";
    private String urils_cont="";

    List<ZixunBean> date1;
    List<PinlunBean> date2;

    PinlunAdapter adapter;

    TextView title,address,time;
    ListView lv;

    @Override
    protected int getContentView() {
        return R.layout.fragment_listview_pinlun;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        Bundle bundle = getArguments();
        id = bundle.getString("id");
        cont_id = bundle.getString("id_cont");
        utils= String.format(ShowsJieko.NEWS_DETAIL, id);
        urils_cont = String.format(ShowsJieko.NEWS_COMMENT,cont_id);


        Log.d("TAG",cont_id+"****************");

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(getContext());
        ImageLoader.getInstance().init(configuration);

        //初始化
        setinit(view);
        //初始化数据源
        date1 = new ArrayList<>();
        date2 = new ArrayList<>();
        //设置异步任务
        setTasks(view);
        //创建适配器
        adapter = new PinlunAdapter(getContext(),date2);
        //设置适配器
        lv.setAdapter(adapter);

        //
        MyListPinTask tasks =new  MyListPinTask(new MyListPinTask.Callbackdss() {
            @Override
            public void getDatas(List<PinlunBean> list) {
                if (list!=null) {
                    date2.addAll(list);
                    Log.d("TAG",date2.size()+"--------"+date2.toString());
                    adapter.notifyDataSetChanged();
                }
            }
        });

        tasks.execute(urils_cont);


    }
    //设置异步任务
    private void setTasks(View view) {
        MyListTask task = new MyListTask(new MyListTask.CallBacks() {
            @Override
            public void getData(List<ZixunBean> list) {
                date1.addAll(list);
                //设置头布局
                title.setText(date1.get(0).getTitle());
                address.setText(date1.get(0).getSource());
                time.setText(date1.get(0).getTime());

            }
        });
        task.execute(utils);
    }

    //初始化
    private void setinit(View view) {
        title = (TextView)view.findViewById(R.id.list_title_1);
        address = (TextView)view.findViewById(R.id.list_adress_1);
        time = (TextView)view.findViewById(R.id.list_time_1);
        lv= (ListView)view.findViewById(R.id.view_list_lvs);

    }
}
