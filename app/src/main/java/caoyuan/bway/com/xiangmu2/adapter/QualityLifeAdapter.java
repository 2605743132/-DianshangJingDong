package caoyuan.bway.com.xiangmu2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;


public class QualityLifeAdapter extends RecyclerView.Adapter<QualityLifeAdapter.ViewHolder>{
    private Context mContext;
    private List<ShouYeBean.ResultBean.PzshBean> list;

    public QualityLifeAdapter(Context mContext, List<ShouYeBean.ResultBean.PzshBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public QualityLifeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_pinzhi_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ImPinzhi.setImageURI(Uri.parse(list.get(0).getCommodityList().get(position).getMasterPic()));
        holder.TvPinzhiName.setText(list.get(0).getCommodityList().get(position).getCommodityName());
        holder.TvPinzhiPrice.setText("¥"+list.get(0).getCommodityList().get(position).getPrice()+"");
    }



    @Override
    public int getItemCount() {
        return list.get(0).getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ImPinzhi;
        private TextView TvPinzhiName,TvPinzhiPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ImPinzhi= itemView.findViewById(R.id.ImPinzhi);
            TvPinzhiName= itemView.findViewById(R.id.TvPinzhiName);
            TvPinzhiPrice= itemView.findViewById(R.id.TvPinzhiPrice);
        }
    }
}

