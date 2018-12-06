package caoyuan.bway.com.xiangmu2.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import caoyuan.bway.com.xiangmu2.R;
import caoyuan.bway.com.xiangmu2.adapter.HomeFragmentpageAdapter;
import caoyuan.bway.com.xiangmu2.fragment.HomeFragment;
import caoyuan.bway.com.xiangmu2.fragment.ItemFragment;
import caoyuan.bway.com.xiangmu2.fragment.MyFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mVp;
    private RadioButton mRbHome;
    private RadioButton mRbCatagory;
    private RadioButton mRbShopcart;
    private RadioButton mRbMine;
    private RadioGroup mRgHome;
    private List<Fragment> list;
    private RadioButton mRbding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ItemFragment());
        list.add(new ItemFragment());

        list.add(new ItemFragment());
        list.add(new MyFragment());
        mVp.setAdapter(new HomeFragmentpageAdapter(getSupportFragmentManager(), list));
        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override

            public void onPageSelected(int position) {

                mRgHome.check(mRgHome.getChildAt(position).getId());

            }

            @Override

            public void onPageScrollStateChanged(int state) {

            }

        });

        mRbHome.setBackgroundResource(R.drawable.panduan);
    }
    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);
        mRbHome = (RadioButton) findViewById(R.id.rbHome);
        mRbHome.setOnClickListener(this);
        mRbCatagory = (RadioButton) findViewById(R.id.rbCatagory);
        mRbCatagory.setOnClickListener(this);
        mRbShopcart = (RadioButton) findViewById(R.id.rbShopcart);
        mRbShopcart.setOnClickListener(this);
        mRbMine = (RadioButton) findViewById(R.id.rbMine);
        mRbMine.setOnClickListener(this);
        mRgHome = (RadioGroup) findViewById(R.id.rgHome);
        mRgHome.setOnClickListener(this);
        mVp.setOnClickListener(this);
        mRbding = (RadioButton) findViewById(R.id.rbding);
        mRbding.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:

                break;

            case R.id.rbHome:

                mVp.setCurrentItem(0);
                break;

            case R.id.rbCatagory:
                mVp.setCurrentItem(1);

                break;

            case R.id.rbShopcart:
                mVp.setCurrentItem(2);

                break;

            case R.id.rbding:
                mVp.setCurrentItem(3);
                break;

            case R.id.rbMine:

                mVp.setCurrentItem(4);

                break;
        }
    }
}
