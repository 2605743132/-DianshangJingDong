package caoyuan.bway.com.xiangmu2.loginmvp.loginpresenter;

import com.google.gson.reflect.TypeToken;

import caoyuan.bway.com.xiangmu2.enity.LoginBean;
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
            public void OnSuccess(LoginBean loginBean, String result) {
                login_view.OnSuccess(loginBean,result);
            }

            @Override
            public void OnFaile(String msg) {
                login_view.OnFaile(msg);
            }
        });
    }
}
