package com.example.administrator.android_week7.Enterty;

import java.util.List;

/**
 * Created by Administrator on 2016/9/30 0030.
 */
public class LoufangmessgeBean {


    /**
     * retcode : 0
     * retmsg : 成功
     * id : 176729
     * iskfthouse :
     * kftid :
     * kftrtid :
     * name : 佳华领域广场
     * price : 42000元/平
     * discount : 3万抵8万
     * label : 0
     * wanttosigned : 87
     * lat : 22.71709
     * lng : 114.054842
     * panoid :
     * heading : 0
     * pitch : 0
     * tel : 400-700-1234,674127
     * features : 打折优惠,品牌开发商
     * title : 9.28佳华领域广场在大中华开盘 均价约42000元/平米
     * summary : 佳华领域广场项目9月28日晚在大中华开盘，推出建筑面积34-54平1-2房精装公寓及建筑面积89-142平3-4房住宅产品，均价约42000元/平米。
     * url : http://openapi.inews.qq.com/c/sz_house/20160929031756?refer=kanfangtuan&filter=1
     * news :
     * traffic : 【地铁】地铁4号线延长线观澜中心站B出口（规划中）、有轨电车新澜站（建设中）、地铁10号线支线（规划中）。
     【公交】吉盛酒店站：312路, 321路, 332路, 627路, 794路, 866路, 882路, b651路, e16路, e4路,m392路, m408路, t2a, 长16路, 高峰专线54路, 深莞1线, 深莞2线, 深莞2线区间车, 中旅东部快线
     【自驾】
     福田出发：梅观高速（观澜出口下）－民和路－观澜大道；
     罗湖出发： 清平高速－机荷高速－梅观高速（观澜出口下）－民和路－观澜大道。
     南山、宝中出发：北环大道－梅观高速（观澜出口下）－民和路－观澜大道。
     西乡、福永出发：机荷高速－梅观高速（观澜出口下）－民和路－观澜大道。
     * around : 教育：观澜中心小学、观澜二中、佳华领域广场社区配套幼儿园
     商业：兴万达广场、观澜湖新城（北部万象城）、观澜天虹、比邻新天地等
     银行：中国农业银行、中国邮政储蓄银行、平安银行、中国工商银行、中国银行
     景观：享锦山公园、观澜老街公园、观澜人民公园和荔枝林景观资源
     * pic : [{"type":"5","name":"效果图","cover":"http://p1.qpic.cn/estate/0/bc224de08980716f829ef432a5979c95.jpg/450","num":3},{"type":"6","name":"样板间","cover":"http://p3.qpic.cn/estate/0/1951e0bb46ad7f85ebba0d26c0b1b95b.jpg/450","num":29},{"type":"4","name":"实景图","cover":"http://p2.qpic.cn/estate/0/e7b8ea83a8e179bd421885f041bed87e.jpg/450","num":12}]
     * info : ["楼盘位置:深圳市龙华新区地铁4号线延长线观澜中心站B出口","物业类别:住宅,建筑综合体,写字楼,商铺,自住型商品房","开盘时间:2016年9月28日","入住时间:2017年7月30日","物业费:3.8元/平方米·月","开发商:深圳市佳华房地产开发有限公司","销售许可:深房许字（2016）龙华011号","产权年限:住宅70年","建筑面积:200000平方米","占地面积:34000平方米","总户数:1028","建筑类别:高层,板塔结合","装修状况:毛坯|简装修","容积率:4.12","绿化率:30%","物业公司:深圳市佳华物业管理有限责任公司"]
     * pricelist : [{"price":42000,"time":"2016-09"}]
     * unitlist : {"num":0,"data":[]}
     * sellstatus : 1
     * istencentdiscount : 0
     * commentnum : 4
     * price_pre : 均价
     * price_value : 42000
     * price_unit : 元/平米
     * ktsf_cover :
     * houseurl : http://db.house.qq.com/sz_176729/
     * discountendtime : 2016-10-31
     * agent : []
     * wii : {}
     */

    private int retcode;
    private String retmsg;
    private int id;
    private String iskfthouse;
    private String kftid;
    private String kftrtid;
    private String name;
    private String price;
    private String discount;
    private String label;
    private int wanttosigned;
    private String lat;
    private String lng;
    private String panoid;
    private int heading;
    private int pitch;
    private String tel;
    private String features;
    private String title;
    private String summary;
    private String url;
    private String news;
    private String traffic;
    private String around;
    /**
     * num : 0
     * data : []
     */

    private UnitlistBean unitlist;
    private String sellstatus;
    private String istencentdiscount;
    private String commentnum;
    private String price_pre;
    private String price_value;
    private String price_unit;
    private String ktsf_cover;
    private String houseurl;
    private String discountendtime;
    private WiiBean wii;
    /**
     * type : 5
     * name : 效果图
     * cover : http://p1.qpic.cn/estate/0/bc224de08980716f829ef432a5979c95.jpg/450
     * num : 3
     */

    private List<PicBean> pic;
    private List<String> info;
    /**
     * price : 42000
     * time : 2016-09
     */

    private List<PricelistBean> pricelist;
    private List<?> agent;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIskfthouse() {
        return iskfthouse;
    }

    public void setIskfthouse(String iskfthouse) {
        this.iskfthouse = iskfthouse;
    }

    public String getKftid() {
        return kftid;
    }

    public void setKftid(String kftid) {
        this.kftid = kftid;
    }

    public String getKftrtid() {
        return kftrtid;
    }

    public void setKftrtid(String kftrtid) {
        this.kftrtid = kftrtid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getWanttosigned() {
        return wanttosigned;
    }

    public void setWanttosigned(int wanttosigned) {
        this.wanttosigned = wanttosigned;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getPanoid() {
        return panoid;
    }

    public void setPanoid(String panoid) {
        this.panoid = panoid;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public String getAround() {
        return around;
    }

    public void setAround(String around) {
        this.around = around;
    }

    public UnitlistBean getUnitlist() {
        return unitlist;
    }

    public void setUnitlist(UnitlistBean unitlist) {
        this.unitlist = unitlist;
    }

    public String getSellstatus() {
        return sellstatus;
    }

    public void setSellstatus(String sellstatus) {
        this.sellstatus = sellstatus;
    }

    public String getIstencentdiscount() {
        return istencentdiscount;
    }

    public void setIstencentdiscount(String istencentdiscount) {
        this.istencentdiscount = istencentdiscount;
    }

    public String getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(String commentnum) {
        this.commentnum = commentnum;
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

    public String getKtsf_cover() {
        return ktsf_cover;
    }

    public void setKtsf_cover(String ktsf_cover) {
        this.ktsf_cover = ktsf_cover;
    }

    public String getHouseurl() {
        return houseurl;
    }

    public void setHouseurl(String houseurl) {
        this.houseurl = houseurl;
    }

    public String getDiscountendtime() {
        return discountendtime;
    }

    public void setDiscountendtime(String discountendtime) {
        this.discountendtime = discountendtime;
    }

    public WiiBean getWii() {
        return wii;
    }

    public void setWii(WiiBean wii) {
        this.wii = wii;
    }

    public List<PicBean> getPic() {
        return pic;
    }

    public void setPic(List<PicBean> pic) {
        this.pic = pic;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public List<PricelistBean> getPricelist() {
        return pricelist;
    }

    public void setPricelist(List<PricelistBean> pricelist) {
        this.pricelist = pricelist;
    }

    public List<?> getAgent() {
        return agent;
    }

    public void setAgent(List<?> agent) {
        this.agent = agent;
    }

    public static class UnitlistBean {
        private int num;
        private List<?> data;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public List<?> getData() {
            return data;
        }

        public void setData(List<?> data) {
            this.data = data;
        }
    }

    public static class WiiBean {
    }

    public static class PicBean {
        private String type;
        private String name;
        private String cover;
        private int num;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }
    }

    public static class PricelistBean {
        private int price;
        private String time;

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
