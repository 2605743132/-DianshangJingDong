package caoyuan.bway.com.xiangmu2.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;

public class  PageAdapter extends PagerAdapter {
    List<Integer> list = new ArrayList();

    public PageAdapter(List<Integer> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
           View view  = LayoutInflater.from(container.getContext()).inflate(R.layout.item_loding,null);
        ImageView imgvi = view.findViewById(R.id.img_log);
        Integer imageId = list.get(position);
        imgvi.setImageResource(imageId);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

       container.removeView((View) object);
    }
}
