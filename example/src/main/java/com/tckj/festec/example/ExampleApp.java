package com.tckj.festec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.tckj.latte.app.Latte;
import com.tckj.latte.ec.icon.FontEcModule;

/**
 * Created by tckj03 on 2017/10/16.
 */

public class ExampleApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //完成初始化
        Latte.init(this).
                withIcon(new FontAwesomeModule()).
                withIcon(new FontEcModule()).//自定义字体
                configure();
    }
}
