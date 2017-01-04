package com.example.administrator.android_week7.Enterty;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class TuBean {
    private String picurl;
    private String title;
    private String newsurl;

    public TuBean(JSONObject json) throws JSONException {
        picurl = json.getString("picurl");
        title = json.getString("title");
        newsurl = json.getString("newsurl");
    }

    public String getPicurl() {
        return picurl;
    }

    public String getTitle() {
        return title;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsurl() {
        return newsurl;
    }

    public void setNewsurl(String newsurl) {
        this.newsurl = newsurl;
    }

    @Override
    public String toString() {
        return "TuBean{" +
                "picurl='" + picurl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
