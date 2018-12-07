package caoyuan.bway.com.xiangmu2.net;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Response;

class OKHeaderInterceptor implements Interceptor {
    public OKHeaderInterceptor(Map headers) {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
