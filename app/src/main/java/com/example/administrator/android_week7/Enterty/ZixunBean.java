package com.example.administrator.android_week7.Enterty;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class ZixunBean {

    /**
     * retcode : 0
     * retmsg : 成功
     * id : HSZ2016092800658102
     * title : 深圳钉子户的胜利！房价从6千撑到6万
     * source : 深圳新闻网
     * time : 2016-09-28 07:29:46
     * url : http://xw.qq.com/house/20160928006581/HSZ2016092800658102
     * surl : http://m.house.qq.com/a/HSZ2016092800658102/
     * content : [{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623836297/640"},{"type":1,"value":"广东深圳，在深圳北站前，一栋外墙红砖裸露、总面积950平米的简陋七层楼房，耸立车站广场前，周边空地杂草重生，部分地块被附近的居民改造为菜地和临时停车场。 (来自:深圳新闻网)"},{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623836298/640"},{"type":1,"value":"楼房所在的土地，位于深圳北站东广场二客站控制区，被深圳市政府列为13个重大发展项目之一。前不久，当地街办公布的樟坑华侨新村的房屋征收补偿单价，该处房屋执行每平方米6548元（不含二次装修补偿）。 (来自:深圳新闻网)"},{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623836299/640"},{"type":1,"value":"而屋主坚持以房换房，双方因补偿分歧未达成一致。上月中旬，与该楼一街之隔的一处楼房开盘，房屋每平米单价达到六万五。陈美兰，广东河源籍中年女子，业主。早年，她花18万购买了这块地，建了7层小楼。从2011年年初，她便开始与拆迁人员打交道。2011年年初，正是深圳北站的建设初具雏形的时候，除了陈美兰的楼，还有多栋这样的红砖楼矗立在北站的正对面。这些楼的用地原为宅基地，但后被多方转让。 (来自:深圳新闻网)"},{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623836300/640"},{"type":1,"value":"当地街道办称，这些楼都没有完备的手续，楼也只建了一半，外墙都没有装修，他们要对这块地进行重新规划，以配得上深圳北站即将崛起的身影。图为现场。一些拆迁户获得了每平方米7000元的赔偿。折算下来，一户能获得的赔偿大约在600万左右。但也人拒绝了赔偿方案。陈美兰就是其中之一。针对这些\u201c钉子户\u201d，政府一度打算强拆。不过，最终他们没有这样做。现在，距离这栋7层小楼百米之遥，就是深圳北站。夜晚时分，深圳北站沐浴灯火，屹立而起。两者相对，有些不协调。 (来自:深圳新闻网)"},{"type":2,"value":"http://inews.gtimg.com/newsapp_bt/0/623836301/640"},{"type":1,"value":"图为透过小楼房的窗户，看到不远处\u201c深圳北站\u201d几个字，小楼房与深圳北站并存着。而现在当地街道办也不再紧张，因为规划尚未出炉，这些楼在此碍不着谁的利益。不过，陈美兰则有些焦急。拆迁不可避免，只是希望这一天早日到来。2016年，深圳房价急升，这栋楼再次吸引了人们眼球。而现在当地街道办也不再紧张，因为规划尚未出炉，这些楼在此碍不着谁的利益。不过，陈美兰则有些焦急。拆迁不可避免，只是希望这一天早日到来。2016年，深圳房价急升，这栋楼再次吸引了人们眼球。 (来自:深圳新闻网)"}]
     */

    private int retcode;
    private String retmsg;
    private String id;
    private String title;
    private String source;
    private String time;
    private String url;
    private String surl;
    /**
     * type : 2
     * value : http://inews.gtimg.com/newsapp_bt/0/623836297/640
     */

    private List<ContentBean> content;

    public  ZixunBean(JSONObject json) throws JSONException {
        title = json.getString("title");
        source = json.getString("source");
        time = json.getString("time");
        JSONArray arr = json.getJSONArray("content");
        int len = arr.length();
        content = new ArrayList<>();
        for (int i=0;i<len;i++){
            JSONObject objs = arr.getJSONObject(i);
            ContentBean bean = new ContentBean();
            bean.setType(objs.getInt("type"));
            bean.setValue(objs.getString("value"));

            content.add(bean);
        }

    }

    public int getRetcode() {
        return retcode;
    }

    public void setRetcode(int retcode) {
        this.retcode = retcode;
    }

    public String getRetmsg() {
        return retmsg;
    }

    public void setRetmsg(String retmsg) {
        this.retmsg = retmsg;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }


}
