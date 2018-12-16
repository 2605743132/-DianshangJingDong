package caoyuan.bway.com.xiangmu2.circlemvp.circlepresete;

import caoyuan.bway.com.xiangmu2.circlemvp.CircleCallBack;
import caoyuan.bway.com.xiangmu2.circlemvp.circlemodel.CircleModel;
import caoyuan.bway.com.xiangmu2.circlemvp.circleview.CircleView;
import caoyuan.bway.com.xiangmu2.enity.CircleBean;

public class CirclePresete {
    private CircleView circleView;
    private CircleModel circleModel;

    public CirclePresete(CircleView circleView) {
        this.circleView = circleView;
        circleModel = new CircleModel();
    }

    public void circle(int page, int count) {
        circleModel.circle(page, count, new CircleCallBack() {
            @Override
            public void circleSuccess(Object data) {
                CircleBean circleBean = (CircleBean) data;
                if (circleBean != null) {
                    circleView.onCircle(circleBean);
                }
            }

            @Override
            public void circleFaile(String data) {
                circleView.onCircleFaile(data);
            }
        });
    }
}
