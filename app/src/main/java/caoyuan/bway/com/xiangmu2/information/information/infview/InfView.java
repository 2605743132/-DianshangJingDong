package caoyuan.bway.com.xiangmu2.information.information.infview;

import caoyuan.bway.com.xiangmu2.enity.InformBean;

public interface InfView {
    void OnInformSuccess(InformBean result);

    void OnFaile(Exception e);
}
