package com.example.administrator.android_week7.Enterty;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class ListBean {

    /**
     * id : HSZ2016092600458905
     * type : 0
     * title : 深圳人香港买房记：贵但质量好
     * summary : 香港的二手楼是怎样的质素？中介会不会猛打骚扰电话？香港看楼究竟是怎样一种体验，本期记者采访了多位深圳人。
     * thumbnail : http://inews.gtimg.com/newsapp_ls/0/617293066_640330/0
     * groupthumbnail : http://inews.gtimg.com/newsapp_ls/0/617293066_150120/0
     * commentcount : 13
     * imagecount : 0
     * commentid : 1554392473
     */

    private String id;
    private String type;
    private String title;
    private String summary;
    private String thumbnail;
    private String groupthumbnail;
    private int commentcount;
    private int imagecount;
    private String commentid;

    public ListBean(JSONObject jsons) throws JSONException {
        id = jsons.getString("id");
        type = jsons.getString("type");
        title = jsons.getString("title");
        summary = jsons.getString("summary");
        thumbnail = jsons.getString("thumbnail");
        commentcount = jsons.getInt("commentcount");
        groupthumbnail = jsons.getString("groupthumbnail");
        imagecount = jsons.getInt("imagecount");
        commentid = jsons.getString("commentid");


        Log.d("TAG","id="+id+"~~~~~~~~~~~~~~~~~~[]~~~~~~~~~~~~~~~~~~~[]");

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getGroupthumbnail() {
        return groupthumbnail;
    }

    public void setGroupthumbnail(String groupthumbnail) {
        this.groupthumbnail = groupthumbnail;
    }

    public int getCommentcount() {
        return commentcount;
    }

    public void setCommentcount(int commentcount) {
        this.commentcount = commentcount;
    }

    public int getImagecount() {
        return imagecount;
    }

    public void setImagecount(int imagecount) {
        this.imagecount = imagecount;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    @Override
    public String toString() {
        return "ListBean{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", groupthumbnail='" + groupthumbnail + '\'' +
                ", commentcount=" + commentcount +
                ", imagecount=" + imagecount +
                ", commentid='" + commentid + '\'' +
                '}';
    }
}
