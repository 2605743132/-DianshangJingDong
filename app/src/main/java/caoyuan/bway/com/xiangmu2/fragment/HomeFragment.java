package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import caoyuan.bway.com.xiangmu2.R;
import cn.bingoogolapple.bgabanner.BGABanner;

public class HomeFragment extends Fragment {
    private BGABanner bannr;
    private ArrayList<String> imageUrl;
    private ArrayList<String> imageDes;
    private String[] picUrl = {
            "http://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg",
            "http://ws1.sinaimg.cn/large/0065oQSqly1fuo54a6p0uj30sg0zdqnf.jpg",
            "http://ws1.sinaimg.cn/large/0065oQSqly1fuh5fsvlqcj30sg10onjk.jpg"

    };
    private String[] picDes = {
         "上百头母猪为何半夜惨叫？",
            "女生宿舍内衣为何频频失窃？"
            ,"宿某的不归路"


    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment, container, false);
        bannr =  view.findViewById(R.id.bannr);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

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

    }
}
