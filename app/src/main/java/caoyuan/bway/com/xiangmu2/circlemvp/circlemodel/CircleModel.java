package caoyuan.bway.com.xiangmu2.circlemvp.circlemodel;


import android.annotation.SuppressLint;


import caoyuan.bway.com.xiangmu2.charmvp.Util;
import caoyuan.bway.com.xiangmu2.circlemvp.CircleCallBack;


import caoyuan.bway.com.xiangmu2.enity.CircleBean;

import caoyuan.bway.com.xiangmu2.ok.RetrofitUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class CircleModel {
    @SuppressLint("CheckResult")
    public void circle(int page, int count, final CircleCallBack callBack) {
        Util create = RetrofitUtil.getInsetance().Create(Util.class);

        create.getcircle(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CircleBean>() {
                    @Override
                    public void accept(CircleBean circleBean) throws Exception {
                        callBack.circleSuccess(circleBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.circleFaile("失败");
                    }
                });
    }
}
