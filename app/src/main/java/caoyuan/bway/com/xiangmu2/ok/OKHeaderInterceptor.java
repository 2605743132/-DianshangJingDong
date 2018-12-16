package caoyuan.bway.com.xiangmu2.ok;

import android.content.Context;
import android.content.SharedPreferences;



import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import caoyuan.bway.com.xiangmu2.app.App;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class OKHeaderInterceptor implements Interceptor {



    @Override
    public Response intercept(Chain chain) throws IOException {
        //存值
        SharedPreferences user = App.sContext.getSharedPreferences("user", Context.MODE_PRIVATE);
        String sessionId = user.getString("sessionId", "");
        int userId = user.getInt("userId", 0);
        //添加请求头
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        builder.addHeader("sessionId",sessionId);
        builder.addHeader("userId",userId+"");


        request = builder.build();
        return chain.proceed(request);
    }





}

