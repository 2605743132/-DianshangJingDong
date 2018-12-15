package caoyuan.bway.com.xiangmu2.loginmvp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.activity.MainActivity;
import caoyuan.bway.com.xiangmu2.enity.LoginBean;
import caoyuan.bway.com.xiangmu2.loginmvp.loginpresenter.LoginPresenter;
import caoyuan.bway.com.xiangmu2.loginmvp.loginview.Loginview;
import caoyuan.bway.com.xiangmu2.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, Loginview {

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
    /**
     * 快速注册
     */
    private TextView mTee;
    private LoginPresenter presenter;
    private SharedPreferences config;
    private CheckBox mChek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        presenter = new LoginPresenter(LoginActivity.this);//实例化P层
        initData();//
        initSp();//初始化sp


    }


    private void initSp() {
        config = getSharedPreferences("config", MODE_PRIVATE);
        if (config.getString("phone", "") != null) {
            String phone = config.getString("phone", "");
            String pwd = config.getString("pwd", "");
            boolean box = config.getBoolean("box", false);
            mEditName.setText(phone);
            mEditPwd.setText(pwd);
            mChek.setChecked(box);
        }


    }

    private void initView() {
        mLoginProgress = (ProgressBar) findViewById(R.id.login_progress);
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditPwd = (EditText) findViewById(R.id.edit_pwd);
        mBtnDeng = (Button) findViewById(R.id.btn_deng);
        mBtnDeng.setOnClickListener(this);
        mLoginProgress.setOnClickListener(this);
        mEditName.setOnClickListener(this);
        mEditPwd.setOnClickListener(this);
        mTee = (TextView) findViewById(R.id.tee);
        mTee.setOnClickListener(this);
        mChek = (CheckBox) findViewById(R.id.chek);
        mChek.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_deng:

                String phone = mEditName.getText().toString().trim();
                String pwd = mEditPwd.getText().toString().trim();
                presenter.login(phone, pwd);

                //判断是否记住密码
                if (mChek.isChecked()) {
                    SharedPreferences.Editor edit = config.edit();
                    edit.putString("phone", phone);
                    edit.putString("pwd", pwd);
                    edit.putBoolean("box", true);
                    edit.commit();
                } else {
                    SharedPreferences.Editor edit = config.edit();
                    edit.clear();
                    edit.commit();
                }




                break;

            case R.id.tee:

                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivity(intent1);
                break;



        }
    }

    private void initData() {
    }



    @Override
    public void OnSuccess(LoginBean loginBean, String result) {
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        config.getInt("UserId",loginBean.getResult().getUserId());
        config.getString("SessionId",loginBean.getResult().getSessionId());
        startActivity(intent);
        finish();
    }

    @Override
    public void OnFaile(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

