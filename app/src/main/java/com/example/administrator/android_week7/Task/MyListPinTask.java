package com.example.administrator.android_week7.Task;

import android.os.AsyncTask;

import com.example.administrator.android_week7.Enterty.PinlunBean;
import com.example.administrator.android_week7.utils.Httputils;
import com.example.administrator.android_week7.utils.JsonUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class MyListPinTask extends AsyncTask<String,Void,List<PinlunBean>>{

    public interface Callbackdss{
        public void getDatas(List<PinlunBean> list);
    }

    Callbackdss cb;

    public MyListPinTask(Callbackdss cb) {
        this.cb = cb;
    }
    public MyListPinTask(){}

    @Override
    protected List<PinlunBean> doInBackground(String... params) {
        String value = Httputils.getHttpString(params[0]);
        List<PinlunBean> list = Httputils.getListpin(value);

        return list;
    }

    @Override
    protected void onPostExecute(List<PinlunBean> list) {
        super.onPostExecute(list);
        if (cb!=null){
            cb.getDatas(list);
        }
    }
}
