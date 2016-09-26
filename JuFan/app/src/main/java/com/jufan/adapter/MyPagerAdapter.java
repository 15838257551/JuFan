package com.jufan.adapter;

/**
 * Created by Administrator on 2016/9/26.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jufan.activities.R;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> list;

    public MyPagerAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View v=View.inflate(context, R.layout.guide2,null);
        ImageView img= (ImageView) v.findViewById(R.id.img);
        img.setBackgroundResource(list.get(position));
        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}


