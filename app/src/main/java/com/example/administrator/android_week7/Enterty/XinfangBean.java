package com.example.administrator.android_week7.Enterty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class XinfangBean {


    /**
     * fid : 176729
     * fcover : http://p1.qpic.cn/estate/0/bc224de08980716f829ef432a5979c95.jpg/180
     * fname : 佳华领域广场
     * faddress : 深圳市龙华新区地铁4号线延长线观澜中心站B出口
     * fregion : 龙华
     * lng : 114.054842
     * lat : 22.71709
     * fsellstatus : 2
     * istencentdiscount : 0
     * faroundhighprice : 0
     * faroundlowprice : 0
     * groupbuynum : 0
     * bookmark : [{"tag":"品牌开发商","type":3}]
     * price_pre : 待定
     * price_value :
     * price_unit :
     * fpricedisplaystr : 暂无均价
     * panoid :
     * heading :
     * pitch :
     * has_agent : 0
     * hui : 0
     */

    private String fid;
    private String fcover;
    private String fname;
    private String faddress;
    private String fregion;
    private String lng;
    private String lat;
    private String fsellstatus;
    private int istencentdiscount;
    private int faroundhighprice;
    private int faroundlowprice;
    private int groupbuynum;
    private String price_pre;
    private String price_value;
    private String price_unit;
    private String fpricedisplaystr;
    private String panoid;
    private String heading;
    private String pitch;
    private int has_agent;
    private int hui;
    /**
     * tag : 品牌开发商
     * type : 3
     */

    private List<BookmarkBean> bookmark;


    public XinfangBean(JSONObject json) throws JSONException {
        fid = json.getString("fid");
        fcover = json.getString("fcover");
        fname = json.getString("fname");
        faddress = json.getString("faddress");
        fregion = json.getString("fregion");
        price_pre = json.getString("price_pre");
        fpricedisplaystr = json.getString("fpricedisplaystr");

        bookmark = new ArrayList<>();
        JSONArray arr = json.getJSONArray("bookmark");
        int len = arr.length();
        for (int i= 0;i<len;i++){
            JSONObject objs = arr.getJSONObject(i);
            BookmarkBean bean = new BookmarkBean(objs);

            bookmark.add(bean);
        }
    }



    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getFcover() {
        return fcover;
    }

    public void setFcover(String fcover) {
        this.fcover = fcover;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFaddress() {
        return faddress;
    }

    public void setFaddress(String faddress) {
        this.faddress = faddress;
    }

    public String getFregion() {
        return fregion;
    }

    public void setFregion(String fregion) {
        this.fregion = fregion;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFsellstatus() {
        return fsellstatus;
    }

    public void setFsellstatus(String fsellstatus) {
        this.fsellstatus = fsellstatus;
    }

    public int getIstencentdiscount() {
        return istencentdiscount;
    }

    public void setIstencentdiscount(int istencentdiscount) {
        this.istencentdiscount = istencentdiscount;
    }

    public int getFaroundhighprice() {
        return faroundhighprice;
    }

    public void setFaroundhighprice(int faroundhighprice) {
        this.faroundhighprice = faroundhighprice;
    }

    public int getFaroundlowprice() {
        return faroundlowprice;
    }

    public void setFaroundlowprice(int faroundlowprice) {
        this.faroundlowprice = faroundlowprice;
    }

    public int getGroupbuynum() {
        return groupbuynum;
    }

    public void setGroupbuynum(int groupbuynum) {
        this.groupbuynum = groupbuynum;
    }

    public String getPrice_pre() {
        return price_pre;
    }

    public void setPrice_pre(String price_pre) {
        this.price_pre = price_pre;
    }

    public String getPrice_value() {
        return price_value;
    }

    public void setPrice_value(String price_value) {
        this.price_value = price_value;
    }

    public String getPrice_unit() {
        return price_unit;
    }

    public void setPrice_unit(String price_unit) {
        this.price_unit = price_unit;
    }

    public String getFpricedisplaystr() {
        return fpricedisplaystr;
    }

    public void setFpricedisplaystr(String fpricedisplaystr) {
        this.fpricedisplaystr = fpricedisplaystr;
    }

    public String getPanoid() {
        return panoid;
    }

    public void setPanoid(String panoid) {
        this.panoid = panoid;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public int getHas_agent() {
        return has_agent;
    }

    public void setHas_agent(int has_agent) {
        this.has_agent = has_agent;
    }

    public int getHui() {
        return hui;
    }

    public void setHui(int hui) {
        this.hui = hui;
    }

    public List<BookmarkBean> getBookmark() {
        return bookmark;
    }

    public void setBookmark(List<BookmarkBean> bookmark) {
        this.bookmark = bookmark;
    }

}
