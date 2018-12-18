package caoyuan.bway.com.xiangmu2.footactivity.footmp.footpreier;

import caoyuan.bway.com.xiangmu2.enity.MyFootBean;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.FootCallBake;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.footiew.FootView;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.footmodel.FootModel;

public class FootPreier {
    private FootView footView;
    private FootModel footModel;

    public FootPreier(FootView footView) {
        this.footView = footView;
        footModel = new FootModel();
    }

    public void myfoot(int page, int count) {
        footModel.myFoot(page, count, new FootCallBake() {
            @Override
            public void OnfootSuccess(Object result) {
                MyFootBean myCircleBean = (MyFootBean) result;
                if (myCircleBean != null) {
                    footView.onCircle(myCircleBean);
                }
            }

            @Override
            public void OnFaile(Exception e) {
                footView.OnFaile(e);
            }
        });
    }
}
