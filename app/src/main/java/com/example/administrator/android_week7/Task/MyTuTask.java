package com.example.administrator.android_week7.Task;

import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.android_week7.Enterty.TuBean;
import com.example.administrator.android_week7.utils.Httputils;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */

public class MyTuTask extends AsyncTask<String,Void ,List<TuBean>> {

    public interface CallBack{
        public void getData(List<TuBean> value);
    }

    CallBack cb;

    public MyTuTask(CallBack cb) {
        this.cb = cb;
    }

    @Override
    protected List<TuBean> doInBackground(String... params) {
       //联网获取字符串
        String value = Httputils.getHttpString(params[0]);
        //将JSON字符串转换为集合
       List<TuBean> list =Httputils.getList(value);
        Log.d("TAG",list.toString()+"_________________________");
        return list;
    }

    @Override
    protected void onPostExecute(List<TuBean> tuBeen) {
        super.onPostExecute(tuBeen);
        if (cb!=null){
           cb.getData(tuBeen);
        }
    }
}