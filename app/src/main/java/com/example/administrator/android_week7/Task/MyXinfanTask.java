package com.example.administrator.android_week7.Task;

import android.os.AsyncTask;

import com.example.administrator.android_week7.Enterty.XinfangBean;
import com.example.administrator.android_week7.XinfangActivity;
import com.example.administrator.android_week7.utils.Httputils;


import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class MyXinfanTask extends AsyncTask<String,Void,List<XinfangBean>>{

    public interface Callbacks{
        public  void getListData(List<XinfangBean> lists);
    }

    Callbacks cb;

    public MyXinfanTask(Callbacks cb) {
        this.cb = cb;
    }


    @Override
    protected List<XinfangBean> doInBackground(String... params) {
        List<XinfangBean> lists = null;
        String value = Httputils.getHttpString(params[0]);
        lists = Httputils.getListxing(value);

        return lists;
    }

    @Override
    protected void onPostExecute(List<XinfangBean> xinfangBeen) {
        super.onPostExecute(xinfangBeen);
        if (cb!=null){
            cb.getListData(xinfangBeen);
        }
    }
}
