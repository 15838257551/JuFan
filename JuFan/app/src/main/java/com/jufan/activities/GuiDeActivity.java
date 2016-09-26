package com.jufan.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.jufan.adapter.MyPagerAdapter;
import java.util.ArrayList;

public class GuiDeActivity extends Activity {
    private ViewPager mViewPager;
    private ArrayList<Integer> list;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_de);
        SharedPreferences sp=getSharedPreferences("1",MODE_PRIVATE);
        SharedPreferences.Editor e=sp.edit();
        e.putBoolean("flag", false);
        e.commit();
        addData();
        init();
    }

    private void addData() {
        list = new ArrayList<Integer>();
        list.add(R.mipmap.li_img_guide_1);
        list.add(R.mipmap.li_img_guide_2);
        list.add(R.mipmap.li_img_guide_3);
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        tv = (TextView) findViewById(R.id.tv);
        mViewPager.setAdapter(new MyPagerAdapter(GuiDeActivity.this, list));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 2) {
                    tv.setVisibility(View.VISIBLE);
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(GuiDeActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }else{
                    tv.setVisibility(View.GONE);
                }
            }
            @Override
            public void onPageSelected(int position) {

            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}
