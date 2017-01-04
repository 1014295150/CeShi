package com.example.administrator.android_week7.adapter;

import android.content.Context;

import com.example.administrator.android_week7.Enterty.ListBean;
import com.example.administrator.android_week7.R;
import com.qf.utillibary.base.AbsBaseAdapter;
import com.qf.utillibary.base.AbsMoreItemBaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/9/26 0026.
 */
public class HomeAdapter extends AbsMoreItemBaseAdapter<ListBean>{

    public HomeAdapter(Context context, int... resId) {
        super(context, resId);
    }

    @Override
    public void bindDatas(ViewHodler viewHodler, ListBean data, int position) {

        if (getItemViewType(position)==0){
            viewHodler.setImageView(R.id.iv_list_0,datas.get(position).getThumbnail())
                    .setTextView(R.id.tv_list_title_0,datas.get(position).getTitle())
                    .setTextView(R.id.tv_list_content_0,datas.get(position).getSummary())
                    .setTextView(R.id.tv_num_list_0,datas.get(position).getCommentcount()+"评");
        }else{
            viewHodler.setTextView(R.id.tv_list_title_1,datas.get(position).getTitle())
                    .setImageView(R.id.iv_list_1,datas.get(position).getGroupthumbnail())
                    .setTextView(R.id.tv_num_list_1,datas.get(position).getCommentcount()+"评");
        }
    }

    @Override
    public int getItemViewType(int position) {
        return Integer.valueOf(datas.get(position).getType());
    }


}
