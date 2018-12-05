package caoyuan.bway.com.xiangmu2.gvmvp.gvpresenter;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import caoyuan.bway.com.xiangmu2.enity.ShouYeBean;
import caoyuan.bway.com.xiangmu2.gvmvp.gvmodel.GvModel;
import caoyuan.bway.com.xiangmu2.gvmvp.gvview.GvView;
import caoyuan.bway.com.xiangmu2.net.ICallBack;
public class GvPresenter {
    private GvModel model;
private GvView view;
public void Attar(GvView view) {
        this.view = view;
        model = new GvModel();
    }
    public void  getEerry(){
        Type type = new TypeToken<ShouYeBean.ResultBean>() {
        }.getType();
model.getBiz("http://172.17.8.100/small/commodity/v1/commodityList", new ICallBack() {
    @Override
    public void onSuccess(Object o)  {

    }
    @Override
    public void onFailed(IOException e) {


    }

},type);
    };
}
