package com.jufan.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.jufan.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class GuiDeActivity extends Activity {
    private ViewPager mViewPager;
    private ArrayList<View> list;
    private Button btn;
    private View v3;
    private View v2;
    private View v1;
    private SharedPreferences sp;
    private boolean flag;
    private View v4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gui_de);
        addData();
        init();
    }
    private void addData() {
        list = new ArrayList<View>();
        v1 = View.inflate(this, R.layout.guide1, null);
        v2 = View.inflate(this, R.layout.guide2, null);
        v3 = View.inflate(this, R.layout.guide3, null);
        v4 = View.inflate(this, R.layout.guide4, null);
        list.add(v1);
        new Thread(){
            @Override
            public void run() {
                SystemClock.sleep(3000);
            }
        }.start();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.vp);
        sp = getSharedPreferences("1", MODE_PRIVATE);
        flag = sp.getBoolean("flag", true);
        if (flag) {
            list.clear();
            list.add(v2);
            list.add(v3);
            list.add(v4);
            mViewPager.setAdapter(new MyPagerAdapter(GuiDeActivity.this, list));
            mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    if (position == 2) {
                        Button btn= (Button) v4.findViewById(R.id.btn);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(GuiDeActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    }
                }
                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });
        } else {
            Intent intent = new Intent(GuiDeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }


    }
}
