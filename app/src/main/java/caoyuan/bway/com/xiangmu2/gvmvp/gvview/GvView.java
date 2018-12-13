package caoyuan.bway.com.xiangmu2.gvmvp.gvview;

import java.util.List;

import caoyuan.bway.com.xiangmu2.enity.BannrBean;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;

public interface GvView {
    void onSuesee(ShouYeBean.ResultBean list);
    void onBannr(List<BannrBean.ResultBean> blist);
    void onFill();

}
