package caoyuan.bway.com.xiangmu2.net;

import caoyuan.bway.com.xiangmu2.enity.LoginBean;

/**
 * data:2018/12/1
 * author: HJL (磊)
 * function:
 */
public interface HttpCallback {
    void OnSuccess(LoginBean loginBean, String result);

    void OnFaile(String msg);

    void OnSuccess(String message);
}
