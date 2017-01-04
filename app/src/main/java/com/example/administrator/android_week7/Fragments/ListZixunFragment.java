package com.example.administrator.android_week7.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.ContentBean;
import com.example.administrator.android_week7.Enterty.ZixunBean;
import com.example.administrator.android_week7.R;
import com.example.administrator.android_week7.Task.MyListTask;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class ListZixunFragment extends BaseFragment implements View.OnClickListener{

    List<ZixunBean> data;
    List<ContentBean> list;
    TextView title;
    TextView address;
    TextView time;
    LinearLayout  add_layout;

    String path;

    @Override
    protected int getContentView() {
        return R.layout.fragment_listview_zixue;
    }

    @Override
    protected void init(View view) {
        super.init(view);
        Bundle bundle = getArguments();
        String id=bundle.getString("id");
        Log.d("TAG",id+"++++++++++++++++++++++++++++");
        path= String.format(ShowsJieko.NEWS_DETAIL, id);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(getContext());
        ImageLoader.getInstance().init(configuration);


        //初始化控件
        setinit(view);

        data = new ArrayList<>();

        //启动异步任务
        setTask(view);
    }
    //启动异步任务
    private void setTask(View view) {
        MyListTask task = new MyListTask(new MyListTask.CallBacks() {
            @Override
            public void getData(List<ZixunBean> list) {
                data.clear();
                //添加
                data.addAll(list);
                //设置头布局
                title.setText(data.get(0).getTitle());
                address.setText(data.get(0).getSource());
                time.setText(data.get(0).getTime());


                //添加控件并设置控件
                setAddview();

            }
        });
        task.execute(path);
    }
    //添加控件并设置控件
    private void setAddview() {
        list = new ArrayList<>();
        list.addAll(data.get(0).getContent());
        int len=list.size();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0,5,0,5);
        for (int i=0;i<len;i++){
            ContentBean bean =list.get(i) ;
            if (bean.getType()==1){
               TextView tv = new TextView(getContext());
                tv.setLayoutParams(params);
                tv.setText(bean.getValue());
                //加入到集合
                add_layout.addView(tv);

            }else{
                ImageView iv = new ImageView(getContext());
                iv.setLayoutParams(params);
                iv.setClickable(true);
                iv.setOnClickListener(this);

                ImageLoader.getInstance().displayImage(bean.getValue(),iv);

                //加入到集合
                add_layout.addView(iv);
            }

        }
    }

    //初始化控件
    private void setinit(View view) {
        title = (TextView)view.findViewById(R.id.list_title_0);
        address = (TextView)view.findViewById(R.id.list_adress_0);
        time = (TextView)view.findViewById(R.id.list_time_0);
        add_layout = (LinearLayout)view.findViewById(R.id.list_layout_linea);
    }

    @Override
    public void onClick(View v) {

    }
}
