package caoyuan.bway.com.xiangmu2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.activity.PersonalDataActivity;
import caoyuan.bway.com.xiangmu2.footactivity.FootActivity;
import caoyuan.bway.com.xiangmu2.information.information.InformActivity;
import caoyuan.bway.com.xiangmu2.loginmvp.LoginActivity;

public class MyFragment extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 个人资料
     */
    private TextView mPersonalData;
    /**
     * 我的圈子
     */
    private TextView mMyCircle;
    /**
     * 我的足迹
     */
    private TextView mMyFootprint;
    /**
     * 我的钱包
     */
    private TextView mMyWallet;
    /**
     * 我的收货地址
     */
    private TextView mMyShippingAddress;
    private SimpleDraweeView mFc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_wo, container, false);
        initView(view1);
        return view1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private void initData() {



    }

    private void initView(View view1) {

        mPersonalData = (TextView) view1.findViewById(R.id.personal_data);

        mMyCircle = (TextView) view1.findViewById(R.id.my_circle);
        mMyFootprint = (TextView) view1.findViewById(R.id.my_footprint);
        mMyWallet = (TextView) view1.findViewById(R.id.my_wallet);
        mMyShippingAddress = (TextView) view1.findViewById(R.id.my_shipping_address);
        mFc = (SimpleDraweeView) view1.findViewById(R.id.fc);
        mPersonalData.setOnClickListener(this);
        mMyCircle.setOnClickListener(this);
        mMyFootprint.setOnClickListener(this);

        mMyWallet.setOnClickListener(this);

        mMyShippingAddress.setOnClickListener(this);
        mFc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.personal_data:
           //跳转到个人信息界面
                Intent personal = new Intent(getActivity(), InformActivity.class);
                startActivity(personal);

                break;
            case R.id.my_circle:

                break;
            case R.id.my_footprint:
                Intent intent3 = new Intent(getActivity(), FootActivity.class);
                startActivity(intent3);
                break;
            case R.id.my_wallet:
                break;
            case R.id.my_shipping_address:
                break;
            case R.id.fc:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

                break;
        }
    }
}
