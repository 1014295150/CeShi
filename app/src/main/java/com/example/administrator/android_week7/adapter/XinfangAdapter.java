package com.example.administrator.android_week7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.BookmarkBean;
import com.example.administrator.android_week7.Enterty.XinfangBean;
import com.example.administrator.android_week7.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.BaseActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
public class XinfangAdapter extends BaseAdapter {

    Context context;
    List<XinfangBean> data;

    LayoutInflater inflater;

    public XinfangAdapter(Context context, List<XinfangBean> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);

        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(context);
        ImageLoader.getInstance().init(configuration);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_xinfang_one,parent,false);
            holder = new ViewHolder();
            holder.iv = (ImageView)convertView.findViewById(R.id.iv_xinfang_two);
            holder.title = (TextView)convertView.findViewById(R.id.tv_xingfang_title);
            holder.addr = (TextView)convertView.findViewById(R.id.tv_address_xingfang);
            holder.values = (TextView)convertView.findViewById(R.id.tv_pressvalue);
            holder.content = (TextView)convertView.findViewById(R.id.tv_xingfang_content);
            holder.bt1 = (TextView)convertView.findViewById(R.id.tv_xingfang_bt_1);
            holder.bt2 = (TextView)convertView.findViewById(R.id.tv_xingfang_bt_2);
            holder.bt3 = (TextView)convertView.findViewById(R.id.tv_xingfang_bt_3);
            holder.title = (TextView)convertView.findViewById(R.id.tv_xingfang_title);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        //清空数据
        holder.bt1.setText("");
        holder.bt2.setText("");
        holder.bt3.setText("");

         //设置值
        XinfangBean beans = data.get(position);
        holder.title.setText(beans.getFname());
        holder.addr.setText(beans.getFregion());
        holder.content.setText(beans.getFaddress());
        if (beans.getPrice_pre().equals("待定")) {
            holder.values.setText("价格"+beans.getPrice_pre());
        }else{
            holder.values.setText(beans.getFpricedisplaystr());
        }

        int nums = beans.getBookmark().size();
        List<BookmarkBean> bean =beans.getBookmark();
        for (int i= 0 ;i<nums;i++){
            if (i==0){
                holder.bt1.setText(bean.get(i).getTag());
            }else if (i==1){
                holder.bt2.setText(bean.get(i).getTag());
            }else if (i==2){
                holder.bt3.setText(bean.get(i).getTag());
            }
        }

        ImageLoader.getInstance().displayImage(beans.getFcover(),holder.iv);




        return convertView;
    }

    class ViewHolder{
        ImageView iv;
        TextView title;
        TextView addr;
        TextView values;
        TextView content;
        TextView bt1;
        TextView bt2;
        TextView bt3;
    }
}
