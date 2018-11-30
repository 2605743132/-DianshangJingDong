package caoyuan.bway.com.xiangmu2.loginmvp.loginmodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.xiangmu2.net.HttpUtils;
import caoyuan.bway.com.xiangmu2.net.ICallBack;

public class LoginModel {

    public void getLogin(String url, ICallBack iCallBack , Type type){
        HttpUtils.getInstance().get(url,iCallBack,type);


    }
}
