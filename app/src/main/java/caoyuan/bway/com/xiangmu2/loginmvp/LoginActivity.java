package caoyuan.bway.com.xiangmu2.loginmvp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import caoyuan.bway.com.xiangmu2.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar mLoginProgress;
    /**
     * 请输入用户名
     */
    private EditText mEditName;
    /**
     * 请输入密码
     */
    private EditText mEditPwd;
    /**
     * 登录
     */
    private Button mBtnDeng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();


    }

    private void initView() {
        mLoginProgress = (ProgressBar) findViewById(R.id.login_progress);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditPwd = (EditText) findViewById(R.id.edit_pwd);
        mBtnDeng = (Button) findViewById(R.id.btn_deng);
        mBtnDeng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_deng:



                break;
        }
    }
}

