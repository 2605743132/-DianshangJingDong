package caoyuan.bway.com.xiangmu2.net;

import java.io.IOException;

public interface ICallBack {
   void onSuccess(Object o);

    void onFailed(IOException e);
}
