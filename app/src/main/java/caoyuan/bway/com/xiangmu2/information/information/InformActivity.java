package caoyuan.bway.com.xiangmu2.information.information;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.enity.InformBean;
import caoyuan.bway.com.xiangmu2.information.information.infprever.InfPrever;
import caoyuan.bway.com.xiangmu2.information.information.infview.InfView;

public class InformActivity extends AppCompatActivity implements InfView {

    private ImageView mInformPic;
    /**
     * 小姐姐
     */
    private TextView mInformNam;
    /**
     * 密码
     */
    private TextView mInformPwd;
    private InfPrever informPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform);
        initView();

         informPresenter = new InfPrever(this);
        informPresenter.inform();
    }

    @Override
    public void OnInformSuccess(InformBean result) {
        InformBean.ResultBean resultBean = result.getResult();
        Glide.with(this).load(resultBean.getHeadPic()).into(mInformPic);
        mInformNam.setText(resultBean.getNickName());
        mInformPwd.setText(resultBean.getPassword());
    }

    @Override
    public void OnFaile(Exception e) {

    }

    private void initView() {
        mInformPic = (ImageView) findViewById(R.id.inform_pic);
        mInformNam = (TextView) findViewById(R.id.inform_nam);
        mInformPwd = (TextView) findViewById(R.id.inform_pwd);
    }
}
