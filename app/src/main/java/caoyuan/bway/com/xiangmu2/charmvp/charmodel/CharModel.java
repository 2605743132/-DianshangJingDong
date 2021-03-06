package caoyuan.bway.com.xiangmu2.charmvp.charmodel;


import android.annotation.SuppressLint;


import caoyuan.bway.com.xiangmu2.charmvp.CarCallBack;
import caoyuan.bway.com.xiangmu2.charmvp.Util;
import caoyuan.bway.com.xiangmu2.enity.CharBean;
import caoyuan.bway.com.xiangmu2.ok.RetrofitUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


public class CharModel {
    @SuppressLint("CheckResult")
    public void car(final CarCallBack carCallBack) {
        Util create = RetrofitUtil.getInsetance().Create(Util.class);

        create.getcar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CharBean>() {
                    @Override
                    public void accept(CharBean carBean) throws Exception {
                        if (carBean!=null){
                            carCallBack.carSuccess(carBean);
                        }else {
                            carCallBack.circleFaile(new Exception(carBean.getMessage()));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        carCallBack.circleFaile((Exception) throwable);
                    }
                });


    }

}