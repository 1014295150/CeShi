package com.example.administrator.android_week7.Fragments;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.android_week7.Enterty.ListBean;
import com.example.administrator.android_week7.Enterty.TuBean;
import com.example.administrator.android_week7.ErshouActivity;
import com.example.administrator.android_week7.KaiPanActivity;
import com.example.administrator.android_week7.LinesTuActivity;
import com.example.administrator.android_week7.LunBuoActivity;
import com.example.administrator.android_week7.Task.MyTuTask;
import com.example.administrator.android_week7.R;
import com.example.administrator.android_week7.SingleTuActiviyts;
import com.example.administrator.android_week7.XinfangActivity;
import com.example.administrator.android_week7.adapter.BannerAdapter;
import com.example.administrator.android_week7.adapter.HomeAdapter;
import com.example.administrator.android_week7.utils.JsonUtil;
import com.example.administrator.android_week7.utils.LocalDisplay;
import com.example.administrator.android_week7.utils.ShowsJieko;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.BaseFragment;
import com.qf.utillibary.util.HttpUtil;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class HomeFragment extends BaseFragment implements HttpUtil.DownLoadListener,AbsListView.OnScrollListener,View.OnClickListener{

    private int reqnum=10,pageflag=0,buttonmore=0;
    private int cityid=4;//默认为是深圳
    String new_util="";
    String web_util="";

   private  ListView lv;
   private PtrFrameLayout ptrframelayout;
    List<ListBean> data;
    HomeAdapter adapter;

    boolean ismore=false;
    boolean isStop=false;
    Thread starts;
    int count =0;

    List<View> views ;
    List<TuBean> list;
    BannerAdapter badapter;
    ViewPager viewpager;
    TextView tv_view;
    LinearLayout line_layout;

    ImageView iv_xinfang,iv_ershou,iv_zufang,iv_zixun,iv_youhui,iv_kaipan,iv_fandai,iv_more;
    TextView tv_view_mess;
    LinearLayout layout_more_1,layout_more_2,layout_more_3;
    LinearLayout Layout_rg_views;
    boolean isShow = false;


    @Override
    protected int getContentView() {
        return R.layout.fragment_home;
    }

    @Override
    public void onStop() {
        super.onStop();
        isStop=true;
        Log.d("TAG",isStop+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    @Override
    public void onResume() {
        super.onResume();
        isStop=false;
        startThread();
        Log.d("TAG",isStop+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    //初始化
    @Override
    protected void init(final View view) {
        super.init(view);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(getContext());
        ImageLoader.getInstance().init(configuration);

        //初始化控件
        lv = (ListView)view.findViewById(R.id.lv);
        ptrframelayout = (PtrFrameLayout)view.findViewById(R.id.ptr_classic_header_rotate_view_shou);

        // header
        final MaterialHeader header = new MaterialHeader(getContext());
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, LocalDisplay.dp2px(15), 0, LocalDisplay.dp2px(10));
        header.setPtrFrameLayout(ptrframelayout);

        ptrframelayout.setLoadingMinTime(1000);
        ptrframelayout.setDurationToCloseHeader(1500);
        ptrframelayout.setHeaderView(header);
        ptrframelayout.addPtrUIHandler(header);



        //创建适配器
        adapter = new HomeAdapter(getContext(),R.layout.item_list_0,R.layout.item_list_1);
        //listview添加头部view必须要在setadapter之前添加
        View handleView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_verpager,null);
        lv.addHeaderView(handleView);
        //初始化控件
        setinit(view);
        list = new ArrayList<>();

        MyTuTask task= new MyTuTask(new MyTuTask.CallBack() {
            @Override
            public void getData(List<TuBean> value) {
                //添加数据源
                setinput(view,value);
                //设置圆点
                setyuan(view);
                //初始化适配器
                badapter = new BannerAdapter(views);
                //设置适配器
                viewpager.setAdapter(badapter);
                //设置监听
                viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                       tv_view.setText(list.get(position).getTitle());
                        int len = views.size();
                        for (int i = 0;i<len;i++){
                            ImageView iv = (ImageView) line_layout.getChildAt(i);
                            if (position==i){
                                iv.setImageResource(R.drawable.btn_yuan_check);
                            }else{
                                iv.setImageResource(R.drawable.btn_yuan_nomal);
                            }
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });


            }
        });
        web_util = String.format(ShowsJieko.FIRST_PAGE_WEBVIEW,cityid);
        task.execute(web_util);

        //设置lv的适配器
        lv.setAdapter(adapter);
        //设置lv的监听器，上拉加载
        lv.setOnScrollListener(this);
        //设置ptrframelayout的回调监听
        ptrframelayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame,
                        content, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                //清空data
                data.clear();
                //更新adapter
                adapter.setDatas(data);

                reqnum=10;
                //拼接字符串
                new_util = String.format(ShowsJieko.FIRST_PAGE_LISTVIEW,reqnum,pageflag,buttonmore,cityid);
                //联网下载JSON字符串
                HttpUtil.downJson(new_util,HomeFragment.this);
            }
        });

        //设置lv的监听器
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(),"position="+position+",id="+id,Toast.LENGTH_LONG).show();
                Log.d("TAG",data.get((int)id).getId()+"---------------------------------");
                ListBean bean = data.get((int)id);

                if (Integer.valueOf(bean.getType())==0){
                    Intent intent = new Intent(getContext(),SingleTuActiviyts.class);
                    //传参
                    intent.putExtra("id",bean.getId());
                    intent.putExtra("num",bean.getCommentcount());
                    intent.putExtra("id_cont",bean.getCommentid());
                    startActivity(intent);

                }else{
                   Intent intent = new Intent(getContext(), LinesTuActivity.class);
                    //传参
                    intent.putExtra("id",bean.getId());
                    startActivity(intent);
                }

            }
        });

    }

    //用线程让图片动起来
    public void  startThread(){
        starts = new Thread() {
            @Override
            public void run() {
                super.run();
                while (!isStop) {
                    SystemClock.sleep(3000);
                    try {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count = viewpager.getCurrentItem();
                                count++;
                                if (list.size()!=0) {
                                    viewpager.setCurrentItem(count % list.size());
                                }
                            }
                        });
                    }catch (Exception e){
                        e.getLocalizedMessage();
                    }
                }
            }
        };
        starts.start();
    }

    //设置圆点
    private void setyuan(View view) {
        int len = views.size();
        //设置圆点在间距
        LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(20,20);
        params.setMargins(5,5,5,5);

        for (int i= 0;i<len;i++){
            ImageView iv = new ImageView(getContext());
            if (i==0){
                iv.setImageResource(R.drawable.btn_yuan_check);
                tv_view.setText(list.get(i).getTitle());
            }else{
                iv.setImageResource(R.drawable.btn_yuan_nomal);
            }
            //设置圆点的共有属性
           /* iv.setClickable(true);
            iv.setOnClickListener(this);
            iv.setTag(i);*/
            iv.setLayoutParams(params);

            line_layout.addView(iv);

        }

    }

    //添加数据源
    private void setinput(View view,List<TuBean> lists) {
        list.addAll(lists);
        views = new ArrayList<>();
        int len = list.size();
        for (int i=0;i<len;i++){
            ImageView iv = new ImageView(getContext());
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setClickable(true);
            iv.setOnClickListener(this);
            iv.setTag(i);
            //加载图片
            ImageLoader.getInstance().displayImage(list.get(i).getPicurl(),iv);
            //把图片加入集合
            views.add(iv);
        }

    }

    //初始化控件轮播图
    private void setinit(View view) {

        viewpager = (ViewPager)view.findViewById(R.id.viewpager);
        tv_view = (TextView)view.findViewById(R.id.tv_viewpager);
        line_layout = (LinearLayout)view.findViewById(R.id.linear_layout);

        iv_xinfang = (ImageView)view.findViewById(R.id.iv_view_xinfang);
        iv_ershou = (ImageView)view.findViewById(R.id.iv_view_ershou);
        iv_zufang = (ImageView)view.findViewById(R.id.iv_view_zufang);
        iv_zixun = (ImageView)view.findViewById(R.id.iv_view_zixun);
        iv_youhui = (ImageView)view.findViewById(R.id.iv_view_youhui);
        iv_kaipan = (ImageView)view.findViewById(R.id.iv_view_kaipan);
        iv_fandai = (ImageView)view.findViewById(R.id.iv_view_fandai);
        iv_more = (ImageView)view.findViewById(R.id.iv_view_more);
        tv_view_mess= (TextView) view.findViewById(R.id.tv_view_messge);
        Layout_rg_views=(LinearLayout)view.findViewById(R.id.Layout_rg_view);

        layout_more_1 = (LinearLayout)view.findViewById(R.id.iv_layout_more1);
        layout_more_2= (LinearLayout)view.findViewById(R.id.iv_layout_more2);
        layout_more_3 = (LinearLayout) view.findViewById(R.id.iv_layout_more3);

        //设置属性
        layout_more_1.setBackgroundResource(R.drawable.btn_bg_colorsed);
        layout_more_2.setBackgroundResource(R.drawable.btn_bg_colorsed);
        layout_more_3.setBackgroundResource(R.drawable.btn_bg_colorsed);

        //设置监听器
        iv_xinfang.setOnClickListener(this);
        iv_ershou.setOnClickListener(this);
        iv_zufang.setOnClickListener(this);
        iv_zixun.setOnClickListener(this);
        iv_youhui.setOnClickListener(this);
        iv_kaipan.setOnClickListener(this);
        iv_fandai.setOnClickListener(this);
        iv_more.setOnClickListener(this);

        layout_more_1.setOnClickListener(this);
        layout_more_2.setOnClickListener(this);
        layout_more_3.setOnClickListener(this);

    }


    //加载数据
    @Override
    protected void loadDatas() {
        super.loadDatas();
        //拼接字符串
        new_util = String.format(ShowsJieko.FIRST_PAGE_LISTVIEW,reqnum,pageflag,buttonmore,cityid);
        //联网下载JSON字符串
        HttpUtil.downJson(new_util,this);

    }



    @Override
    public void downSucc(String url, String json) {
        //数据源
        data = new ArrayList<>();
         String value =json;
       // Log.d("TAG",json+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            data.addAll(JsonUtil.getData(value, reqnum-10));

      //  Log.d("TAG",data.toString());
        adapter.addDatas(data);
       // Log.d("TAG",data.size()+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      //  Log.d("TAG","reqnum="+reqnum+"~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        //停止刷新
        ptrframelayout.refreshComplete();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
            if (scrollState==0&&ismore){

                reqnum +=10;
                //拼接字符串
                new_util = String.format(ShowsJieko.FIRST_PAGE_LISTVIEW,reqnum,pageflag,buttonmore,cityid);
                //联网下载JSON字符串
                HttpUtil.downJson(new_util,this);
            }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            ismore = ((firstVisibleItem+visibleItemCount)==totalItemCount);
    }

    @Override
    public void onClick(View v) {
        if(v.getTag()!=null) {
            int num = (int) v.getTag();
            TuBean beand =list.get(num);
            Intent intent = new Intent(getContext(), LunBuoActivity.class);
            intent.putExtra("http",beand.getNewsurl());
            startActivity(intent);

        }
        switch(v.getId()){
            case R.id.iv_view_xinfang:{

                Intent intent = new Intent(getContext(), XinfangActivity.class);
                intent.putExtra("cityid",cityid);
                startActivity(intent);

            }
            break;
            case R.id.iv_view_ershou:{
                Intent intent = new Intent(getContext(), ErshouActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.iv_view_zufang:{

            }
            break;
            case R.id.iv_view_zixun:{

            }
            break;
            case R.id.iv_view_youhui:{

            }
            break;
            case R.id.iv_view_kaipan:{

                Intent intent = new Intent(getContext(), KaiPanActivity.class);
                intent.putExtra("cityid",cityid);
                startActivity(intent);

            }
            break;
            case R.id.iv_view_fandai:{

            }
            break;
            case R.id.iv_view_more:{
               isShow= !isShow;
                setImageviews(isShow);
            }
            break;
            case R.id.iv_layout_more1:{

            }
            break;
            case R.id.iv_layout_more2:{

            }
            break;
            case R.id.iv_layout_more3:{

            }
            break;

        }
    }

    //设置imageview中more的监听
    public void setImageviews(Boolean is){
        if (is){
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,0,0,0);

            tv_view_mess.setLayoutParams(params);
           Layout_rg_views.setVisibility(View.VISIBLE);
        }else{
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0,5,0,0);

            tv_view_mess.setLayoutParams(params);
            Layout_rg_views.setVisibility(View.GONE);
        }

    }
}
