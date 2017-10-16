package com.tckj.latte.app;

import android.content.res.Configuration;

import java.util.WeakHashMap;

/**
 * Created by tckj03 on 2017/10/16.
 */

public class Configurator {

    private static final WeakHashMap<String,Object> LATTE_CONFIG=new WeakHashMap<>();

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    //静态内部类写单例
    private static class Holder{
        private static  final Configurator INSTANCE=new Configurator();
    }
    private Configurator(){
        LATTE_CONFIG.put(ConfigType.CONFIG_READY.name(),false);//配置已经开始，但是尚未完成
    }

    final WeakHashMap<String,Object> getLatteConfig(){
        return  LATTE_CONFIG;
    }
    //配置完成
    public final void configure(){
        LATTE_CONFIG.put(ConfigType.CONFIG_READY.name(),true);
    }
    //配置API
    public final Configurator withApiHost(String host){
        LATTE_CONFIG.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    //检测是否初始化完成的方法
    private void checkConfigurtion(){
        final boolean isReady= (boolean) LATTE_CONFIG.get(ConfigType.CONFIG_READY.name());
        if(!isReady){
            throw new RuntimeException("Configuration is not ready,call configrure");
        }
    }
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfigurtion();
        return (T) LATTE_CONFIG.get(key);
    }

}

