package caoyuan.bway.com.xiangmu2.adapter;

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

public class MagicFashionAdapter extends RecyclerView.Adapter<MagicFashionAdapter.ViewHolder> {

    private Context mContext;
    private List<ShouYeBean.ResultBean.MlssBean> list;

    public MagicFashionAdapter(Context mContext, List<ShouYeBean.ResultBean.MlssBean> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_mlss_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ImMl.setImageURI(Uri.parse(list.get(0).getCommodityList().get(position).getMasterPic()));
        holder.TvMlName.setText(list.get(0).getCommodityList().get(position).getCommodityName());
        holder.TvMlPrice.setText("¥"+list.get(0).getCommodityList().get(position).getPrice()+"");


    }

    @Override
    public int getItemCount() {
        return list.get(0).getCommodityList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView ImMl;
        private TextView TvMlName,TvMlPrice;
        public ViewHolder(View itemView) {
            super(itemView);
            ImMl= itemView.findViewById(R.id.ImMl);
            TvMlName= itemView.findViewById(R.id.TvMlName);
            TvMlPrice= itemView.findViewById(R.id.TvMlPrice);
        }
    }
}

