package com.tckj.latte.delegates;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by tckj03 on 2017/10/19.
 */

public abstract class BaseDelegate extends SwipeBackFragment{
    public abstract Object setLayout();//设置布局
    private Unbinder mUnbinder=null;
    public abstract void onBindView(@Nullable Bundle savedInstanceState,View rootView);//强制子类实现
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView=null;
        if(setLayout() instanceof Integer){//传入的是XML
            rootView= inflater.inflate((Integer) setLayout(),container,false);
        }else if(setLayout() instanceof View){//传入的是View
            rootView= (View) setLayout();
        }
        if(rootView!=null){
            mUnbinder= ButterKnife.bind(this,rootView);
            onBindView(savedInstanceState,rootView);
        }
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(mUnbinder!=null){
            mUnbinder.unbind();
        }
    }
}
