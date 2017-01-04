package com.example.administrator.android_week7.Enterty;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class PinlunBean {

    /**
     * id : 6186333400393657432
     * time : 昨天 08:40:19
     * timestamp : 1474936819
     * content : 我以为一栋，那太贵了，800万左右元郎我可以买得到
     * nick : 一哥
     * head : http://q2.qlogo.cn/g?b=qq&k=iagYvN7vkouHYua4IeVQq7w&s=40&t=1474992000
     * region : 腾讯网友
     * isreply : 1
     * replynick : 天立专业手扼
     * replycontent : 我是说一层
     */

    private String id;
    private String time;
    private int timestamp;
    private String content;
    private String nick;
    private String head;
    private String region;
    private int isreply;
    private String replynick;
    private String replycontent;


    public PinlunBean(JSONObject json) throws JSONException {
        nick = json.getString("nick");
        region = json.getString("region");
        time = json.getString("time");
        content = json.getString("content");
        replynick = json.getString("replynick");
        isreply = json.getInt("isreply");
        replycontent = json.getString("replycontent");
        head = json.getString("head");
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getIsreply() {
        return isreply;
    }

    public void setIsreply(int isreply) {
        this.isreply = isreply;
    }

    public String getReplynick() {
        return replynick;
    }

    public void setReplynick(String replynick) {
        this.replynick = replynick;
    }

    public String getReplycontent() {
        return replycontent;
    }

    public void setReplycontent(String replycontent) {
        this.replycontent = replycontent;
    }
}
