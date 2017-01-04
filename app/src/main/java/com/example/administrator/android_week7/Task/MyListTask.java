package com.example.administrator.android_week7.Task;

import android.os.AsyncTask;

import com.example.administrator.android_week7.Enterty.ZixunBean;
import com.example.administrator.android_week7.utils.Httputils;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class MyListTask extends AsyncTask<String,Void,List<ZixunBean>> {

    public interface CallBacks{
        public void getData(List<ZixunBean> list);
    }

    CallBacks cb;

    public MyListTask(CallBacks cb) {
        this.cb = cb;
    }

    @Override
    protected List<ZixunBean> doInBackground(String... params) {
        String value = Httputils.getHttpString(params[0]);
        List<ZixunBean> list = Httputils.getListview(value);
        return list;
    }

    @Override
    protected void onPostExecute(List<ZixunBean> zixunBeen) {
        super.onPostExecute(zixunBeen);
        if (cb!=null){
            cb.getData(zixunBeen);
        }
    }
}
