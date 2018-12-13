package caoyuan.bway.com.xiangmu2.fragment;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;

import android.widget.Toast;


import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.HomeShopAdapter;
import caoyuan.bway.com.xiangmu2.enity.BannrBean;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;
import caoyuan.bway.com.xiangmu2.gvmvp.gvpresenter.GvPresenter;
import caoyuan.bway.com.xiangmu2.gvmvp.gvview.GvView;
import caoyuan.bway.com.xiangmu2.util.ImageUtil;
import caoyuan.bway.com.xiangmu2.view.MyGallery;


public class HomeFragment extends Fragment implements GvView {
    /**
     * 图片资源数组
     */
    private int[] imageResIDs;

//    private int index = 0;
//    private final int AUTOPLAY = 2;
    private View view;
//
//    private ImageAdapter adapter;
    private MyGallery gallery;
    private MyGallery mMygallery;
    private XRecyclerView mXrecyc;
    private GvPresenter gvPresenter;

    private HomeShopAdapter homeShopAdapter;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment, container, false);
        gvPresenter = new GvPresenter();
        gvPresenter.Attar(this);
        gvPresenter.getEerry();
        initView(view);
        initData();
        return view;
    }

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);


    }


    private void initView(View view) {

        imageResIDs = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d,
                R.drawable.bitmap, R.drawable.b,};


        mXrecyc = view.findViewById(R.id.Xrecyc);

        mXrecyc = (XRecyclerView) view.findViewById(R.id.Xrecyc);


    }


    private void initData() {
//
//        adapter = new ImageAdapter();
//        gallery.setAdapter(adapter);
//        gallery.setSpacing(50); //图片之间的间距
//        gallery.setSelection((Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2) % imageResIDs.length);
//
//        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });
//        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), "当前位置position:" + position + "的图片被选中了", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        Timer timer = new Timer();
//        timer.schedule(task, 3000, 3000);
//
//        adapter.notifyDataSetChanged();
//
//        //首页数据
//        getShouyeShuJu();
//    }
//
//
//    /**
//     * 定时器，实现自动播放
//     */
//    private TimerTask task = new TimerTask() {
//        @Override
//        public void run() {
//            Message message = new Message();
//            message.what = AUTOPLAY;
//            index = gallery.getSelectedItemPosition();
//            index++;
//            handler.sendMessage(message);
//        }
//    };
//
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case AUTOPLAY:
//                    gallery.setSelection(index);
//                    break;
//                default:
//                    break;
//            }
//        }
//    };
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            default:
//                break;
//            case R.id.mygallery:
//                break;
//            case R.id.Xrecyc:
//                break;
//        }
//    }
//
//
//    public class ImageAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return Integer.MAX_VALUE;//用于循环滚动
//        }
//
//        @Override
//        public Object getItem(int position) {
//            if (position >= imageResIDs.length) {
//                position = position % imageResIDs.length;
//            }
//
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            if (position >= imageResIDs.length) {
//                position = position % imageResIDs.length;
//            }
//
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            ImageView imageView;
//            if (convertView != null) {
//                imageView = (ImageView) convertView;
//            } else {
//                imageView = new ImageView(getActivity());
//            }
//
//            if (position >= imageResIDs.length) {
//                position = position % imageResIDs.length;
//            }
//
//            Bitmap bitmap = ImageUtil.getImageBitmap(getResources(),
//                    imageResIDs[position]);
//            BitmapDrawable drawable = new BitmapDrawable(bitmap);
//            drawable.setAntiAlias(true); // 消除锯齿
//            imageView.setImageDrawable(drawable);
//            LayoutParams params = new LayoutParams(240, 320);
//            imageView.setLayoutParams(params);
//            return imageView;
//        }

//        @Override
//        public void notifyDataSetChanged() {
//
//            super.notifyDataSetChanged();
//
//        }
//

    }

    //以下是首页的
    private void getShouyeShuJu() {


    }

    @Override
    public void onSuesee(ShouYeBean.ResultBean list) {
mXrecyc.setLoadingListener(new XRecyclerView.LoadingListener() {
    @Override
    public void onRefresh() {
        doDate();

    }

    @Override
    public void onLoadMore() {
        doDate();

    }
});
        XRecyclerView.LayoutManager layoutManager2 = new GridLayoutManager(getActivity(), 1);
        mXrecyc.setLayoutManager(layoutManager2);

        homeShopAdapter = new HomeShopAdapter(getActivity(), list);

        mXrecyc.setAdapter(homeShopAdapter);

    }

    @Override
    public void onBannr(List<BannrBean.ResultBean> blist) {

    }

    @Override
    public void onFill() {

    }

    private void doDate() {
       mXrecyc.postDelayed(new Runnable() {
            @Override
            public void run() {
                mXrecyc.refreshComplete();
            }
        }, 2000);

    }
}





