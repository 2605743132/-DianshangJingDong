package caoyuan.bway.com.xiangmu2.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.PageAdapter;
import caoyuan.bway.com.xiangmu2.loginmvp.LoginActivity;

public class LodingActivity extends AppCompatActivity implements View.OnClickListener {
    private List<Integer> imagelist = new ArrayList<>();
    private ViewPager mVplun;
    /**
     * 立即体验
     */
    private Button mBtnLi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loding);
        initView();
        initData();


    }

    private void initData() {
        if (isFirst()) {
            imagelist.add(R.drawable.a);
            imagelist.add(R.drawable.b);
            imagelist.add(R.drawable.c);
            mVplun.setAdapter(new PageAdapter(imagelist));
        }else{
            jupe();


        }


       mVplun.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
           @Override
           public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

           }

           @Override
           public void onPageSelected(int position) {
                    if (position == 2 ){
                        mBtnLi.setVisibility(View.VISIBLE);


                    }else {

                        mBtnLi.setVisibility(View.GONE);
                    }
           }

           @Override
           public void onPageScrollStateChanged(int state) {

           }
       });
    }
    private void initView() {
        mVplun = (ViewPager) findViewById(R.id.vplun);
        mVplun.setOnClickListener(this);
        mBtnLi = (Button) findViewById(R.id.btn_li);
        mBtnLi.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_li:
                jupe();
                break;
        }
    }
    private void jupe() {
        SharedPreferences sp = getSharedPreferences("sp_name", MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean("isfalse", false);
        edit.commit();
        Intent intent = new Intent(LodingActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public  boolean isFirst(){
        SharedPreferences sp = getSharedPreferences("sp_name", MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isfalse",true);
        return isFirst;
    }

}
