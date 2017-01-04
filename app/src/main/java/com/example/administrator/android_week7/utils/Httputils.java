package com.example.administrator.android_week7.utils;

import android.os.AsyncTask;
import android.util.Log;

import com.example.administrator.android_week7.Enterty.PinlunBean;
import com.example.administrator.android_week7.Enterty.TuBean;
import com.example.administrator.android_week7.Enterty.XinfangBean;
import com.example.administrator.android_week7.Enterty.ZixunBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class Httputils {

    //联网下载JSON字符串
    public static String getHttpString(String pathString){
        HttpURLConnection conn = null;
        StringBuilder sb = null;
        try {
            URL url = new URL(pathString);
            conn = (HttpURLConnection)url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            sb = new StringBuilder();
            String temp = null;
            while((temp=reader.readLine())!=null){
                sb.append(temp);
            }
            reader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if (conn!=null){
                conn.disconnect();
            }
        }

        return sb.toString();
    }




    //将图片JSON字符串转换为集合
    public static List<TuBean> getList(String value){
       List<TuBean> list = new ArrayList<>();
        try {
            JSONObject objs = new JSONObject(value);
            JSONArray arr = objs.getJSONArray("data");
            int len = arr.length();
            for (int i=0;i<len;i++){
                JSONObject json = arr.getJSONObject(i);
                TuBean bean = new TuBean(json);
                Log.d("TAG",bean.toString()+"~~~~~~~~~~~~~~~~~~");
                list.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    //将list数据的字符串转换为集合
    public static List<ZixunBean> getListview(String value){
        List<ZixunBean> data = new ArrayList<>();
        try {
            JSONObject objs = new JSONObject(value);
            ZixunBean bean = new ZixunBean(objs);

            data.add(bean);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return  data;
    }

    //将list_ping的数据的字符串转换成集合
    public static List<PinlunBean> getListpin(String value){
        List<PinlunBean> list = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(value);
            JSONObject objs = obj.getJSONObject("data");
            JSONArray arr = objs.getJSONArray("comments");
            int len = arr.length();
            for (int i=0;i<len;i++){
                JSONObject json = arr.getJSONObject(i);
                PinlunBean bean = new PinlunBean(json);
                //将类添加到集合
                list.add(bean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }

    //将list_xing的数据的字符串转换成集合
    public static List<XinfangBean> getListxing(String value){
        List<XinfangBean> list = new ArrayList<>();

        try {
            JSONObject obj = new JSONObject(value);
            JSONArray arr = obj.getJSONArray("data");
            int len = arr.length();
            for (int i=0;i<len;i++){
                JSONObject json = arr.getJSONObject(i);
                XinfangBean bean = new XinfangBean(json);
                //将类添加到集合
                list.add(bean);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return list;
    }
}
