package caoyuan.bway.com.xiangmu2.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.BannrAdapter;
import caoyuan.bway.com.xiangmu2.enity.BannrBean;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;
import caoyuan.bway.com.xiangmu2.gvmvp.gvpresenter.GvPresenter;
import caoyuan.bway.com.xiangmu2.gvmvp.gvview.GvView;
import recycler.coverflow.CoverFlowLayoutManger;
import recycler.coverflow.RecyclerCoverFlow;

public class HomeFragment extends Fragment implements GvView {


    private GridView mGv;
    private RecyclerView mRv;
    private View view;
    private RecyclerCoverFlow mList;
    private List<BannrBean.ResultBean> list;
    private GvPresenter gvPresenter;
    private BannrAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homefragment, container, false);

        initView(view);
        return view;
    }

    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        initData();


    }


    private void initData() {
        gvPresenter = new GvPresenter();
        gvPresenter.Attar(this);

        gvPresenter.getBannr();
        list = new ArrayList<>();

        //        mList.setFlatFlow(true); //平面滚动
        adapter = new BannrAdapter(getActivity(), list);
        mList.setAdapter(adapter);
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                mList.getLayoutManager().getItemCount();
            }
        });


    }

    private void initView(View view) {

        mList = (RecyclerCoverFlow) view.findViewById(R.id.list);

    }


    @Override
    public void onSuesee(List<ShouYeBean.ResultBean> list) {

    }

    @Override
    public void onBannr(List<BannrBean.ResultBean> blist) {
        if (blist != null) {
            list.clear();
            list.addAll(list);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFill() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (gvPresenter != null) {
            gvPresenter.onDestroy();
        }
    }
}
