package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.CircleAdapter;
import caoyuan.bway.com.xiangmu2.circlemvp.circlepresete.CirclePresete;
import caoyuan.bway.com.xiangmu2.circlemvp.circleview.CircleView;
import caoyuan.bway.com.xiangmu2.enity.CircleBean;

public class CircleFragment extends Fragment implements CircleView {

    private CirclePresete circlePresenter;
    private List<CircleBean.ResultBean> list;
    private int page = 1;
    private CircleAdapter circleAdapter;
    private View view;
    private XRecyclerView mCircleRe;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentcirile, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        circlePresenter = new CirclePresete(this);

        circlePresenter.circle(page, 5);
        list = new ArrayList<>();
        circleAdapter = new CircleAdapter(getActivity(), list);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mCircleRe.setAdapter(circleAdapter);
        mCircleRe.setLayoutManager(manager);
        mCircleRe.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                circlePresenter.circle(1, 5);
                mCircleRe.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                circlePresenter.circle(page, 5);
                mCircleRe.loadMoreComplete();
            }
        });

    }

    @Override
    public void onCircle(CircleBean data) {

        if (data != null) {
            if (page == 1) {
                list.clear();
            }
            list.addAll(data.getResult());
            circleAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onCircleFaile(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }

    private void initView(View view) {
        mCircleRe = (XRecyclerView) view.findViewById(R.id.circle_re);
    }
}



