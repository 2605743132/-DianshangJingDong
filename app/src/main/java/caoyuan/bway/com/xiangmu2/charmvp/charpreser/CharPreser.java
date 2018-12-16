package caoyuan.bway.com.xiangmu2.charmvp.charpreser;

import caoyuan.bway.com.xiangmu2.charmvp.CarCallBack;
import caoyuan.bway.com.xiangmu2.charmvp.charmodel.CharModel;
import caoyuan.bway.com.xiangmu2.charmvp.charview.CharView;
import caoyuan.bway.com.xiangmu2.enity.CharBean;

public class CharPreser {
    private CharView carView;
    private CharModel carModel;

    public void CarPresenter(CharView carView) {
        this.carView = carView;
        carModel = new CharModel();
    }

    public void car() {
        carModel.car(new CarCallBack() {
            public CharBean carBean;

            @Override
            public void carSuccess(Object data) {
                 carBean = (CharBean) data;
                if (carBean != null) {
                    carView.onCar(carBean);
                }
            }

            @Override

            public void circleFaile(Exception e) {

                carView.onCircleFaile(carBean.getMessage());
            }
        });
    }
}
