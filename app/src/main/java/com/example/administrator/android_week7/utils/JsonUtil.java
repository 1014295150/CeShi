package com.example.administrator.android_week7.utils;

import android.util.Log;

import com.example.administrator.android_week7.Enterty.ListBean;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

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
 * Created by Administrator on 2016/9/26 0026.
 */
public class JsonUtil {


    //联网下载JSON字符串
    public static String getHttpStrings(String pathString){
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

        Log.d("TAG",sb.toString()+"===================================");
        return sb.toString();
    }


    public static List<ListBean> getData(String json,int num){

        List<ListBean> data = new ArrayList<>();
        try {
            JSONObject objs = new JSONObject(json);
            JSONArray arr = objs.getJSONArray("data");
            int len = arr.length();
            for(int i= num ; i<len;i++) {

                JSONObject jsons = arr.getJSONObject(i);
                ListBean bean = new ListBean(jsons);

                data.add(bean);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
       return  data;
    }
}
