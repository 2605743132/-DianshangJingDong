package caoyuan.bway.com.xiangmu2.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;
import cn.bingoogolapple.bgabanner.BGABanner;


public class HomeShopAdapter extends RecyclerView.Adapter<HomeShopAdapter.ViewHolder> {

    private Context mContext;
    private ShouYeBean.ResultBean alist;
 private String[] murl= {
         "http://172.17.8.100/images/small/banner/cj.png",
         "http://172.17.8.100/images/small/banner/hzp.png"
         ,"http://172.17.8.100/images/small/banner/lyq.png",
         "http://172.17.8.100/images/small/banner/px.png",
         "http://172.17.8.100/images/small/banner/wy.png"

 };
 private String[] mtitle = {
   "抽奖",
         "美妆工具",
         "连衣裙",
         "跑鞋",
         "卫衣"


 };
private List<String> surl;
    private List<String> slist;


    public HomeShopAdapter(Context Context, ShouYeBean.ResultBean Shoplist ) {
        mContext = Context;
        alist = Shoplist;

    }
    public void setHomeShopAdapter(ShouYeBean.ResultBean resultBean) {
        this.alist = resultBean;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int ViewType) {
        if (ViewType==0){
            View view = LayoutInflater.from(mContext).inflate(R.layout.bann_layout, viewGroup, false);
            return new ViewHolder(view);
        }else if (ViewType==1){
            View view = LayoutInflater.from(mContext).inflate(R.layout.rexiao_layout, viewGroup, false);
            return new ViewHolder(view);

        }else if (ViewType==2) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.moli_layout, viewGroup, false);
            return new ViewHolder(view);

        }else if (ViewType == 3){
            View view = LayoutInflater.from(mContext).inflate(R.layout.pinzhi_layout, viewGroup, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        int type = getItemViewType(position);
        switch (type) {
            case 0:
        surl = new ArrayList<>();

        slist = new ArrayList<>();

for (int i  =0 ; i<murl.length;i++){
surl.add(murl[i]);
slist.add(mtitle[i]);


}
//集合传入banner
                viewHolder.banner.setData(surl,slist);


                viewHolder.banner.setAdapter(new BGABanner.Adapter<ImageView, String>() {
                    @Override
                    public void fillBannerItem(BGABanner banner, ImageView itemView, @Nullable String model, int position) {
                        ImageLoader.getInstance().displayImage(surl.get(position),itemView);
                    }
                });

            break;
            case 1:
                viewHolder.Rexiao.setAdapter(new NewDesignAdapter(mContext, alist.getRxxp()));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                viewHolder.Rexiao.setLayoutManager(linearLayoutManager);
                break;
            case 2:
                viewHolder.Moli.setAdapter(new MagicFashionAdapter(mContext, alist.getMlss()));
                LinearLayoutManager linearLayoutManage = new LinearLayoutManager(mContext);
                linearLayoutManage.setOrientation(LinearLayoutManager.VERTICAL);
                viewHolder.Moli.setLayoutManager(linearLayoutManage);
                break;
            case 3:
                viewHolder.Pinzhi.setAdapter(new QualityLifeAdapter(mContext, alist.getPzsh()));
                viewHolder.Pinzhi.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }

        //viewHolder.tvRxName.setText(list.get(position).getCommodityList().get(position).getPrice()+"");
       /* viewHolder.tvRxPrice.setText(list.get(0).getCommodityList().get(position).getPrice() + "");
        viewHolder.tvRxName.setText(list.get(0).getCommodityList().get(position).getCommodityName());
        Picasso.with(mContext).load(list.get(0).getCommodityList().get(position).getMasterPic()).into(viewHolder.ImRx);*/
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position % 4 == 1) {
            type = 1;
        } else if (position % 4 == 2) {
            type = 2;
        }else  if (position%4==3){
            type =3;
        }
        return type;
    }

    @Override
    public int getItemCount() {
        //return list.get(0).getCommodityList().size()==0?0:list.get(0).getCommodityList().size();
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private BGABanner banner;
        private RecyclerView Rexiao, Moli, Pinzhi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.Banner);
            Rexiao = itemView.findViewById(R.id.Rexiao);
            Moli = itemView.findViewById(R.id.Moli);
            Pinzhi = itemView.findViewById(R.id.Pinzhi);
        }
    }
}

