package caoyuan.bway.com.xiangmu2.footactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.MyFootAdapter;
import caoyuan.bway.com.xiangmu2.enity.MyFootBean;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.footiew.FootView;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.footpreier.FootPreier;

public class FootActivity extends AppCompatActivity implements FootView {


    private XRecyclerView mMyFootRe;
    private FootPreier preier;
    private MyFootAdapter myFootAdapter;
    private List<MyFootBean.ResultBean> list = new ArrayList<>();
    private int page = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);
        initView();
initData();
    }

    private void initData() {
        preier= new FootPreier(this);
       preier.myfoot(1,5);

         myFootAdapter = new MyFootAdapter(this,list);
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMyFootRe.setAdapter(myFootAdapter);
        mMyFootRe.setLayoutManager(manager);
mMyFootRe.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                list.clear();
                preier.myfoot(1, 5);
                mMyFootRe.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                preier.myfoot(page, 5);
                mMyFootRe.loadMoreComplete();
            }
        });
    }



    @Override
    public void onCircle(MyFootBean data) {
        if (data != null) {
            list.addAll(data.getResult());
        }
        myFootAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnFaile(Exception e) {
        Toast.makeText(this,""+e.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void initView() {
        mMyFootRe = (XRecyclerView) findViewById(R.id.my_foot_re);
    }
}
