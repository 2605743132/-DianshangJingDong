package caoyuan.bway.com.xiangmu2.loginmvp.loginview;

import caoyuan.bway.com.xiangmu2.enity.LoginBean;

public interface Loginview {

    void OnSuccess(LoginBean result);

    void OnFaile(String msg);

}
