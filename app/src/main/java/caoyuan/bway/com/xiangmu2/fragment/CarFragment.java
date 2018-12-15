package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import caoyuan.bway.com.xiangmu2.R;

public class CarFragment extends Fragment {
    private View view;
    private RecyclerView mRlvShopcart;
    /**
     * 全选
     */
    private TextView mTvShopcartAddselect;
    /**
     * 总价：¥0
     */
    private TextView mTvShopcartTotalprice;
    /**
     * 共0件商品
     */
    private TextView mTvShopcartTotalnum;
    /**
     * 去结算
     */
    private TextView mTvShopcartSubmit;
    private LinearLayout mLlPay;
    private RelativeLayout mRlShopcartHave;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment, container, false);
        initView(view);
        return view;

    }

    private void initView(View view) {

        mRlvShopcart = (RecyclerView) view.findViewById(R.id.rlv_shopcart);
        mTvShopcartAddselect = (TextView) view.findViewById(R.id.tv_shopcart_addselect);
        mTvShopcartTotalprice = (TextView) view.findViewById(R.id.tv_shopcart_totalprice);
        mTvShopcartTotalnum = (TextView) view.findViewById(R.id.tv_shopcart_totalnum);
        mTvShopcartSubmit = (TextView) view.findViewById(R.id.tv_shopcart_submit);
        mLlPay = (LinearLayout) view.findViewById(R.id.ll_pay);
        mRlShopcartHave = (RelativeLayout) view.findViewById(R.id.rl_shopcart_have);
    }
}
