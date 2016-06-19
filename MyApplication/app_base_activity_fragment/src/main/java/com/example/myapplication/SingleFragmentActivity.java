package com.example.myapplication;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public abstract class SingleFragmentActivity extends FragmentActivity
{
    protected abstract Fragment createFragment();

    public abstract int getLayoutResID();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(getLayoutResID());

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment =fm.findFragmentById(R.id.fragment_container);

       /* 1、为什么需要判null呢？[fragment会被保存下来]
        主要是因为，当Activity因为配置发生改变（屏幕旋转）或者内存不足被系统杀死，造成重新创建时，
        我们的fragment会被保存下来，但是会创建新的FragmentManager，
        新的FragmentManager会首先会去获取保存下来的fragment队列，重建fragment队列，从而恢复之前的状态。
        */

        if(fragment == null )
        {
            fragment = createFragment() ;

            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
