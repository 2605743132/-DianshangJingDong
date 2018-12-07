package caoyuan.bway.com.xiangmu2.register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import caoyuan.bway.com.xiangmu2.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 手机号
     */
    private EditText mEditNameZhu;
    /**
     * 登录密码
     */
    private EditText mEditPwdZhu;
    /**
     * 注册·
     */
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mEditNameZhu = (EditText) findViewById(R.id.edit_name_zhu);
        mEditPwdZhu = (EditText) findViewById(R.id.edit_pwd_zhu);
        mBtnRegister = (Button) findViewById(R.id.btn_register);
        mBtnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_register:


                break;
        }
    }
}
