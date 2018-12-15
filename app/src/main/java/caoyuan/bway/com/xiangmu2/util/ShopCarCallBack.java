package caoyuan.bway.com.xiangmu2.util;

import caoyuan.bway.com.xiangmu2.enity.CharBean;

public interface ShopCarCallBack {
    void onSuccessShopCar(CharBean CarBean);
    void onFailerShopCar(String error);

}
