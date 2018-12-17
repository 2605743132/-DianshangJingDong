package caoyuan.bway.com.xiangmu2.information.information.infBiz;

import android.annotation.SuppressLint;

import caoyuan.bway.com.xiangmu2.charmvp.Util;
import caoyuan.bway.com.xiangmu2.enity.InformBean;
import caoyuan.bway.com.xiangmu2.information.information.InformCallBack;
import caoyuan.bway.com.xiangmu2.ok.RetrofitUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class InfBiz {
    @SuppressLint("CheckResult")
    public void inform(final InformCallBack callBack) {
        Util create = RetrofitUtil.getInsetance().Create(Util.class);

        create.getInform()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<InformBean>() {
                    @Override
                    public void accept(InformBean informBean) throws Exception {
                        if (informBean.getStatus().equals("0000")) {
                            callBack.OnInformSuccess(informBean);
                        } else {
                            callBack.OnFaile(new Exception(informBean.getMessage()));
                        }

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.OnFaile((Exception) throwable);
                    }
                });
    }
}
