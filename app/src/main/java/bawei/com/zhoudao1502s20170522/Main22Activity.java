package bawei.com.zhoudao1502s20170522;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;

public class Main22Activity extends FragmentActivity implements View.OnClickListener {
    Button buttonOne;
    Button buttonTwo;
    ViewPager mViewPager;
    List<Fragment> fragmentList;
    OneFragment oneFragment;
    TwoFragment twoFragment;
    //覆盖层
    ImageView imageviewOvertab;
    //屏幕宽度
    int screenWidth;
    //当前选中的项
    int currenttab=-1;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        mTv = (TextView) findViewById(R.id.tvv);
        buttonOne=(Button)findViewById(R.id.btn_one);
        buttonTwo=(Button)findViewById(R.id.btn_two);
        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        mViewPager=(ViewPager) findViewById(R.id.viewpager);
        fragmentList=new ArrayList<Fragment>();
        oneFragment=new OneFragment();
        twoFragment=new TwoFragment();
        fragmentList.add(oneFragment);
        fragmentList.add(twoFragment);
        screenWidth=getResources().getDisplayMetrics().widthPixels;
        buttonTwo.measure(0, 0);
        imageviewOvertab=(ImageView) findViewById(R.id.imgv_overtab);
        RelativeLayout.LayoutParams imageParams=new RelativeLayout.LayoutParams(screenWidth/4, buttonTwo.getMeasuredHeight());
        imageParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        imageviewOvertab.setLayoutParams(imageParams);
        mViewPager.setAdapter(new MyFrageStatePagerAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                 if(position==0){
                     mTv.setText("聊天");
                 }else{
                     mTv.setText("联系人");
                 }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    class MyFrageStatePagerAdapter extends FragmentStatePagerAdapter
    {

        public MyFrageStatePagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        /**
         * 每次更新完成ViewPager的内容后，调用该接口，此处复写主要是为了让导航按钮上层的覆盖层能够动态的移动
         */
        @Override
        public void finishUpdate(ViewGroup container)
        {
            super.finishUpdate(container);//这句话要放在最前面，否则会报错
            //获取当前的视图是位于ViewGroup的第几个位置，用来更新对应的覆盖层所在的位置
            int currentItem=mViewPager.getCurrentItem();
            if (currentItem==currenttab)
            {
                return ;
            }
            imageMove(mViewPager.getCurrentItem());
            currenttab=mViewPager.getCurrentItem();
        }

    }

    /**
     * 移动覆盖层
     * @param moveToTab 目标Tab，也就是要移动到的导航选项按钮的位置
     * 第一个导航按钮对应0，第二个对应1，以此类推
     */
    private void imageMove(int moveToTab)
    {
        int startPosition=0;
        int movetoPosition=0;

        startPosition=currenttab*(screenWidth/4);
        movetoPosition=moveToTab*(screenWidth/4);
        //平移动画
        TranslateAnimation translateAnimation=new TranslateAnimation(startPosition,movetoPosition, 0, 0);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        imageviewOvertab.startAnimation(translateAnimation);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                changeView(0);
                mTv.setText("聊天");
                break;
            case R.id.btn_two:
                changeView(1);
                mTv.setText("联系人");
                break;
        }
    }
    private void changeView(int desTab)
    {
        mViewPager.setCurrentItem(desTab, true);
    }
}
