package caoyuan.bway.com.xiangmu2.information.information.infprever;

import caoyuan.bway.com.xiangmu2.enity.InformBean;
import caoyuan.bway.com.xiangmu2.information.information.InformCallBack;
import caoyuan.bway.com.xiangmu2.information.information.infBiz.InfBiz;
import caoyuan.bway.com.xiangmu2.information.information.infview.InfView;

public class InfPrever {
    private InfView informView;
    private InfBiz informModel;

    public InfPrever(InfView informView) {
        this.informView = informView;
        informModel = new InfBiz ();
    }

    public void inform() {
        informModel.inform(new InformCallBack() {
            @Override
            public void OnInformSuccess(Object result) {
                InformBean informBean = (InformBean) result;
                if (informBean!=null & "0000".equals(informBean.getStatus())) {
                    informView.OnInformSuccess(informBean);
                }
            }

            @Override
            public void OnFaile(Exception e) {
                informView.OnFaile(e);
            }
        });
    }
}
