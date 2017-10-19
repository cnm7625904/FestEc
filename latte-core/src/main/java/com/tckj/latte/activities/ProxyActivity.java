package com.tckj.latte.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.tckj.latte.R;
import com.tckj.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by tckj03 on 2017/10/19.
 */

public abstract class ProxyActivity extends SupportActivity{
    public abstract LatteDelegate setRootDelagate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }
    //初始化视图
    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container=new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        //第一次加载为空的时候
        if(savedInstanceState==null){
            loadRootFragment(R.id.delegate_container,setRootDelagate());
        }
    }
    //单Activity应用
    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}
