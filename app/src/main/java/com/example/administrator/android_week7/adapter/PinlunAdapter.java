package com.example.administrator.android_week7.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.android_week7.Enterty.PinlunBean;
import com.example.administrator.android_week7.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qf.utillibary.base.AbsMoreItemBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28 0028.
 */
public class PinlunAdapter extends BaseAdapter {

    Context context;
    List<PinlunBean> data;

    LayoutInflater inflater;

    public PinlunAdapter(Context context, List<PinlunBean> data) {
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

        ViewHolder holder = null;
        if (convertView == null){
            convertView = inflater.inflate(R.layout.item_pinlun,parent,false);
            holder = new ViewHolder();
            holder.head = (ImageView)convertView.findViewById(R.id.iv_pin_show);
            holder.name = (TextView)convertView.findViewById(R.id.tv_pin_name);
            holder.content = (TextView)convertView.findViewById(R.id.tv_content_pin);
            holder.address = (TextView)convertView.findViewById(R.id.tv_pin_add);
            holder.time = (TextView)convertView.findViewById(R.id.tv_pin_time);
            holder.other = (TextView)convertView.findViewById(R.id.tv_other_pin);
            holder.nothing = (TextView)convertView.findViewById(R.id.tv_nothing);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }


        PinlunBean bean = data.get(position);

        if (data.size()!=0) {
            holder.name.setText(bean.getNick());
            holder.address.setText(bean.getRegion());
            holder.time.setText(bean.getTime());
            holder.content.setText(bean.getContent());

            ImageLoader.getInstance().displayImage(bean.getHead(), holder.head);

            if (data.get(position).getIsreply() != 0) {

                holder.other.setText(data.get(position).getReplynick() + ":" + data.get(position).getReplycontent());
            }
        }else {
            holder.nothing.setText("沙发很寂寞");
        }

        return convertView;
    }


    class ViewHolder{
        ImageView head;
        TextView  name;
        TextView content;
        TextView address;
        TextView time;
        TextView other;
        TextView nothing;
    }

    /*@Override
    public void bindDatas(ViewHodler viewHodler, PinlunBean data, int position) {

            viewHodler.setImageView(R.id.iv_pin_show,datas.get(position).getHead())
                    .setTextView(R.id.tv_pin_name,datas.get(position).getNick())
                    .setTextView(R.id.tv_list_content_0,datas.get(position).getContent());

        if (data.getIsreply()!=0) {

            viewHodler.setTextView(R.id.tv_other_pin,datas.get(position).getReplynick()+":"+datas.get(position).getReplycontent());
        }

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }*/
}
