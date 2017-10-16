package com.tckj.festec.example;

import android.app.Application;

import com.tckj.latte.app.Latte;

/**
 * Created by tckj03 on 2017/10/16.
 */

public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this).
                configure();
    }
}
