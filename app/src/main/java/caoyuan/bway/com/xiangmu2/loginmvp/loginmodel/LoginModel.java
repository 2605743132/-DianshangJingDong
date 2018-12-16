package caoyuan.bway.com.xiangmu2.loginmvp.loginmodel;


import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import caoyuan.bway.com.xiangmu2.constant.Util;
import caoyuan.bway.com.xiangmu2.enity.LoginBean;
import caoyuan.bway.com.xiangmu2.net.HttpCallback;
import caoyuan.bway.com.xiangmu2.net.HttpNet;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class LoginModel {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };

    public void login(String phone, String pwd, final HttpCallback httpCallback) {
        Map<String, String> map = new HashMap();
        map.put("phone", phone);
        map.put("pwd", pwd);

        HttpNet.EnestenPost(Util.LOGIN_URL, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                final LoginBean login_bean = gson.fromJson(string, LoginBean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (login_bean.getStatus().equals("0000")) {
//                            Log.i("userid",""+login_bean.getResult().getUserId());
                            httpCallback.OnSuccess(login_bean);
                        } else {
                            httpCallback.OnFaile(login_bean.getMessage());
                        }

                    }
                });
            }
        });

    }
}
