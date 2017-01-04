package com.example.administrator.android_week7.Enterty;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class BookmarkBean {

    private String tag;
    private int type;

    public BookmarkBean(JSONObject json) throws JSONException {
        tag = json.getString("tag");
        type = json.getInt("type");
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
