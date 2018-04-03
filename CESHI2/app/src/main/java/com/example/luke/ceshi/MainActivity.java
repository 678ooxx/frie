package com.example.luke.ceshi;

import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Fragment> fragments;

    WeixinFragment weixinFragment;
    FavorListFragment favorListFragment;
    FindFragment findFragment;
    SelfFragment SelfFragment;

    private ViewPager viewPager;
    FragmentManager fragmentManager;
    private LinearLayout weixin, favor, find, self;
    private ImageView weixin_img, favor_img, find_img, self_img;
    private TextView weixin_txt, favor_txt, find_txt, self_txt;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化加载首页布局
        initView();
        //调用自定义initListener方法，为各个组件添加监听事件
        initListener();
        //设置默认选择的pager和导航栏的状态
        viewPager.setCurrentItem(0);
        weixin_img.setSelected(true);
        weixin_txt.setSelected(true);
        //hide my title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    private void initListener() {
        //导航组件添加监听
        weixin.setOnClickListener(this);
        favor.setOnClickListener(this);
        find.setOnClickListener(this);
        self.setOnClickListener(this);

        button.setOnClickListener(this);

        //viewpager添加页面变化的监听以及事件处理
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //滑动根据位置直接决定显示哪个fragment
                viewPager.setCurrentItem(position);
                switch (position) {
                    case 0:
                        weixin_img.setSelected(true);
                        weixin_txt.setSelected(true);

                        favor_img.setSelected(false);
                        favor_txt.setSelected(false);
                        find_img.setSelected(false);
                        find_txt.setSelected(false);
                        self_img.setSelected(false);
                        self_txt.setSelected(false);

                        break;
                    case 1:
                        weixin_img.setSelected(false);
                        weixin_txt.setSelected(false);

                        favor_img.setSelected(true);
                        favor_txt.setSelected(true);
                        find_img.setSelected(false);
                        find_txt.setSelected(false);
                        self_img.setSelected(false);
                        self_txt.setSelected(false);

                        break;
                    case 2:
                        weixin_img.setSelected(false);
                        weixin_txt.setSelected(false);

                        favor_img.setSelected(false);
                        favor_txt.setSelected(false);
                        find_img.setSelected(true);
                        find_txt.setSelected(true);
                        self_img.setSelected(false);
                        self_txt.setSelected(false);

                        break;
                    case 3:
                        weixin_img.setSelected(false);
                        weixin_txt.setSelected(false);

                        favor_img.setSelected(false);
                        favor_txt.setSelected(false);
                        find_img.setSelected(false);
                        find_txt.setSelected(false);
                        self_img.setSelected(true);
                        self_txt.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void initView() {

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        weixinFragment = new WeixinFragment();
        favorListFragment = new FavorListFragment();
        findFragment = new FindFragment();
        SelfFragment = new SelfFragment();
        fragments = new ArrayList<>();
        //添加fragments到集合中

        fragments.add(weixinFragment);
        fragments.add(favorListFragment);
        fragments.add(findFragment);
        fragments.add(SelfFragment);
        fragmentManager = getSupportFragmentManager();

        viewPager.setAdapter(new MyFragmentPagerAdapter(fragmentManager));

        weixin = (LinearLayout) findViewById(R.id.weixin);
        favor = (LinearLayout) findViewById(R.id.favor);
        find = (LinearLayout) findViewById(R.id.find);
        self = (LinearLayout) findViewById(R.id.self);

        button = (Button) findViewById(R.id.buttongoback);

        //载入图标
        weixin_img = (ImageView) findViewById(R.id.weixin_img);
        favor_img = (ImageView) findViewById(R.id.favor_img);
        find_img = (ImageView) findViewById(R.id.find_img);
        self_img = (ImageView) findViewById(R.id.self_img);

        weixin_txt = (TextView) findViewById(R.id.weixin_txt);
        favor_txt = (TextView) findViewById(R.id.favor_txt);
        find_txt = (TextView) findViewById(R.id.find_txt);
        self_txt = (TextView) findViewById(R.id.self_txt);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weixin:
                viewPager.setCurrentItem(0);
                weixin_img.setSelected(true);
                weixin_txt.setSelected(true);

                favor_img.setSelected(false);
                favor_txt.setSelected(false);
                find_img.setSelected(false);
                find_txt.setSelected(false);
                self_img.setSelected(false);
                self_txt.setSelected(false);
                break;

            case R.id.find:
                viewPager.setCurrentItem(2);
                weixin_img.setSelected(false);
                weixin_txt.setSelected(false);

                favor_img.setSelected(false);
                favor_txt.setSelected(false);
                find_img.setSelected(true);
                find_txt.setSelected(true);
                self_img.setSelected(false);
                self_txt.setSelected(false);

                break;
            case R.id.favor:
                viewPager.setCurrentItem(1);
                weixin_img.setSelected(false);
                weixin_txt.setSelected(false);

                favor_img.setSelected(true);
                favor_txt.setSelected(true);
                find_img.setSelected(false);
                find_txt.setSelected(false);
                self_img.setSelected(false);
                self_txt.setSelected(false);

                break;
            case R.id.self:
                viewPager.setCurrentItem(3);
                weixin_img.setSelected(false);
                weixin_txt.setSelected(false);

                favor_img.setSelected(false);
                favor_txt.setSelected(false);
                find_img.setSelected(false);
                find_txt.setSelected(false);
                self_img.setSelected(true);
                self_txt.setSelected(true);
                break;
//
            case R.id.buttongoback:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Hello");
                dialog.setMessage("goback");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
                break;
//                case  R.id.bottom:
//                String intputText = editText.getText().toString();
//                Toast.makeText(MainActivity.this,intputText,Toast.LENGTH_SHORT).show();
//                break;
        }
    }

    //创建FragmentPagerAdapter
    class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}