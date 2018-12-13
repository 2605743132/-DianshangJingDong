package caoyuan.bway.com.xiangmu2.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;

public class NewDesignAdapter extends RecyclerView.Adapter<NewDesignAdapter.ViewHolder> {

    private Context mContext;
    private List<ShouYeBean.ResultBean.RxxpBean> list;

    public NewDesignAdapter(Context mContext, List<ShouYeBean.ResultBean.RxxpBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_rexiao_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ImRx.setImageURI(Uri.parse(list.get(0).getCommodityList().get(position).getMasterPic()));
        holder.tvRxName.setText(list.get(0).getCommodityList().get(position).getCommodityName());
        holder.tvRxPrice.setText("¥"+list.get(0).getCommodityList().get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.get(0).getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ImRx;
        private TextView tvRxName,tvRxPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ImRx= itemView.findViewById(R.id.ImRx);
            tvRxName= itemView.findViewById(R.id.tvRxName);
            tvRxPrice= itemView.findViewById(R.id.tvRxPrice);
        }
    }
}

