package caoyuan.bway.com.xiangmu2.circlemvp.circleview;

import caoyuan.bway.com.xiangmu2.enity.CircleBean;

public interface CircleView {
    void onCircle(CircleBean data);

    void onCircleFaile(String msg);
}
