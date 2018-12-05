package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import caoyuan.bway.com.xiangmu2.R;
import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeFragment extends Fragment {
    private BGABanner bannr;
    private ArrayList<String> imageUrl;
    private ArrayList<String> imageDes;
    private String[] picUrl = {
            "http://172.17.8.100/images/tech/banner/20181026151647.png",
            "http://172.17.8.100/images/tech/banner/20181026151647.png",
            "http://172.17.8.100/images/tech/banner/20181026151647.png"

    };
    private String[] picDes = {
            "抽奖",
            "贝览得美妆蛋",
            "男款上衣"

    };
    private View view;
    private GridView mGv;
    private RecyclerView mRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment, container, false);
        bannr = view.findViewById(R.id.bannr);

        initView(view);
        return view;
    }

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        initData();


    }


    private void initData() {
        //创建image和des的集合
        imageUrl = new ArrayList<String>();
        imageDes = new ArrayList<>();
        //循环添加到集合
        for (int a = 0; a < picUrl.length; a++) {
            imageUrl.add(picUrl[a]);
            imageDes.add(picDes[a]);
        }

        //集合传入banner
        bannr.setData(imageUrl, imageDes);
        bannr.setAdapter(new BGABanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                //   ImageLoader.getInstance().displayImage(imageUrl.get(position), itemView);
                Glide.with(getActivity()).load(imageUrl.get(position)).into(itemView);



            }
        });

        getBuJu();

    }
    private void initView(View view) {
        mGv = (GridView) view.findViewById(R.id.gv);
        mRv = (RecyclerView) view.findViewById(R.id.rv);

    }
   //写布局
    public void getBuJu() {


    }
}
