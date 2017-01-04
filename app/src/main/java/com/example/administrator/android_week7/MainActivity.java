package com.example.administrator.android_week7;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.android_week7.Fragments.ChongZhiFragment;
import com.example.administrator.android_week7.Fragments.GerenFragment;
import com.example.administrator.android_week7.Fragments.HomeFragment;
import com.example.administrator.android_week7.Fragments.KeFuFragment;
import com.qf.utillibary.base.BaseActivity;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    RadioGroup rg;
    RadioButton rb;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();

        ActionBar actionBar = getSupportActionBar();
        actionBar.show();//默认情况是显示。可以不调用该方法。
        actionBar.hide();//隐藏ActionBar

        rg = findViewByIds(R.id.rg_shou);
        rg.setOnCheckedChangeListener(this);
        //模仿点击效果--自动点击了一下
        rg.getChildAt(0).performClick();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch(checkedId){
            case R.id.rb_home:{
                //设置加载布局
                fragmentManager(R.id.frag_layout,new HomeFragment(),"HomeFragment");
            }
            break;
            case R.id.rb_chongzhi:{
                //设置加载布局
                fragmentManager(R.id.frag_layout,new ChongZhiFragment(),"ChongZhiFragment");
            }
            break;
            case R.id.rb_kefu:{
                //设置加载布局
                fragmentManager(R.id.frag_layout,new KeFuFragment(),"KeFuFragment");
            }
            break;
            case R.id.rb_geren:{
                //设置加载布局
                fragmentManager(R.id.frag_layout,new GerenFragment(),"GerenFragment");
            }
            break;
        }
    }


   // 按两次退出
    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序",
                        Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
