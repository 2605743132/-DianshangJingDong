package caoyuan.bway.com.xiangmu2.footactivity.footmp.footmodel;

import android.annotation.SuppressLint;

import caoyuan.bway.com.xiangmu2.charmvp.Util;
import caoyuan.bway.com.xiangmu2.enity.MyFootBean;
import caoyuan.bway.com.xiangmu2.footactivity.footmp.FootCallBake;
import caoyuan.bway.com.xiangmu2.ok.RetrofitUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FootModel {
    @SuppressLint("CheckResult")
    public void myFoot(int page, int count, final FootCallBake callBack) {
        Util create = RetrofitUtil.getInsetance().Create(Util.class);

        create.getmyfoot(page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyFootBean>() {
                    @Override
                    public void accept(MyFootBean myFootBean) throws Exception {
                        if (myFootBean != null) {
                            callBack.OnfootSuccess(myFootBean);
                        } else {
                            callBack.OnFaile(new Exception(myFootBean.getMessage()));
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (throwable!=null){
                            callBack.OnFaile((Exception) throwable);
                        }
                    }
                });
    }
}
