package caoyuan.bway.com.xiangmu2.loginmvp.loginpresenter;

import caoyuan.bway.com.xiangmu2.loginmvp.loginmodel.LoginModel;
import caoyuan.bway.com.xiangmu2.loginmvp.loginview.Loginview;
import caoyuan.bway.com.xiangmu2.net.HttpCallback;

public class LoginPresenter {

    private LoginModel login_model;
    private Loginview login_view;

    public LoginPresenter(Loginview login_view) {
        this.login_view = login_view;
        login_model = new LoginModel();
    }

    public void login(String phone, String pwd) {
        login_model.login(phone, pwd, new HttpCallback() {
            @Override
            public void OnSuccess(String result) {
                login_view.OnSuccess(result);
            }

            @Override
            public void OnFaile(String msg) {
                login_view.OnFaile(msg);
            }
        });
    }
}
