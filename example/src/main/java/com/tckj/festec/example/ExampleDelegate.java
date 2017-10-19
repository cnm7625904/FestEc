package com.tckj.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.tckj.latte.delegates.LatteDelegate;

/**
 * Created by Administrator。 on 2017/10/19.
 */

public class ExampleDelegate extends LatteDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
