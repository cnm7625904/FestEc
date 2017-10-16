package com.tckj.latte.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by tckj03 on 2017/10/16.
 */

public class Latte {
    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    private static WeakHashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getLatteConfig();
    }
}