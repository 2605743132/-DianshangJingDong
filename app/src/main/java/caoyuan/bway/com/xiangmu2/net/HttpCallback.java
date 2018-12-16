package caoyuan.bway.com.xiangmu2.net;

import caoyuan.bway.com.xiangmu2.enity.LoginBean;


public interface HttpCallback {

    void OnSuccess(Object result);

    void OnFaile(String msg);
}
