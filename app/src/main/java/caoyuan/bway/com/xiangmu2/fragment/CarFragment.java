package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.CarAdapter;
import caoyuan.bway.com.xiangmu2.charmvp.charpreser.CharPreser;
import caoyuan.bway.com.xiangmu2.charmvp.charview.CharView;
import caoyuan.bway.com.xiangmu2.enity.CharBean;

public class CarFragment extends Fragment implements CharView {

    private static final String TAG = "FragmentCar";
    private RecyclerView mcarre;
    private CharPreser carPresenter;
    private List<CharBean.ResultBean> list = new ArrayList<>();
    private CarAdapter carAdapter;
    private CheckBox mboxall;
    private TextView mprice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.car_fragment, container, false);
        mcarre = view.findViewById(R.id.car_re);
        mboxall = view.findViewById(R.id.box_all);
        mprice = view.findViewById(R.id.total_price);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        carPresenter = new CharPreser();
        carPresenter.CarPresenter(this);
        carPresenter.car();

        carAdapter = new CarAdapter(getActivity(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mcarre.setAdapter(carAdapter);
        mcarre.setLayoutManager(manager);
        carAdapter.notifyDataSetChanged();

        initcheck();

    }

    private void initcheck() {
        //全选框选中
        mboxall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = mboxall.isChecked();//true
                for (CharBean.ResultBean resultBean : list) {
                    resultBean.setChecked(checked);//给集合中赋值true,条目checkbox选中
                }
                //刷新页面
                carAdapter.notifyDataSetChanged();
                getSum();//计算总价
            }
        });

        //判断商品条目checkbox
        carAdapter.setOnShopCartClickListener(new CarAdapter.OnShopCartClickListener() {
            @Override
            public void onShopCartClick(int position, boolean isChecked) {
                //条目不选中,去哪选不选中
                if (!isChecked) {
                    mboxall.setChecked(false);
                } else {
                    boolean click = true;
                    //遍历判断条目是否都选中
                    for (CharBean.ResultBean resultBean : list) {
                        if (!resultBean.isChecked()) {//有不选中的
                            click = false;
                            break;//停止
                        }
                    }
                    mboxall.setChecked(click);//全选框不选中
                }
                getSum();//计算总价
            }
        });

        //全选
        carAdapter.setOnAddClickListener(new CarAdapter.OnAddClickListener() {
            @Override
            public void onAddClick() {
                getSum();//计算总价
            }
        });
    }

    //计算总价
    public void getSum() {
        float sum = 0;
        for (CharBean.ResultBean resultBean : list) {
            if (resultBean.isChecked()) {
                sum += resultBean.getPrice() * resultBean.getCount();
            }
        }
        mprice.setText("" + sum);
    }

    @Override
    public void onCar(CharBean carBean) {
        if (carBean != null) {
            list.clear();
            list.addAll(carBean.getResult());
        }
        carAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCircleFaile(String as) {
        Toast.makeText(getActivity(), as, Toast.LENGTH_SHORT).show();

    }
}


