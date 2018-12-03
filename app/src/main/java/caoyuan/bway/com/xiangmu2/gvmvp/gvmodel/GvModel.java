package caoyuan.bway.com.xiangmu2.gvmvp.gvmodel;

import java.lang.reflect.Type;

import caoyuan.bway.com.xiangmu2.net.HttpUtils;
import caoyuan.bway.com.xiangmu2.net.ICallBack;

public class GvModel {
    public void getBiz(String url, ICallBack callBack,Type type){
        HttpUtils.getInstance().get(url,callBack,type);

    }

}
