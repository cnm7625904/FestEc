package com.tckj.latte.app;

import android.content.res.Configuration;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * Created by tckj03 on 2017/10/16.
 */

public class Configurator {
    //保存设置
    private static final HashMap<String,Object> LATTE_CONFIG=new HashMap<>();
    //保存字体
    private static final ArrayList<IconFontDescriptor> ICONS=new ArrayList<>();
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

    final HashMap<String,Object> getLatteConfig(){
        return  LATTE_CONFIG;
    }
    //配置完成
    public final void configure(){
        initIcons();
        LATTE_CONFIG.put(ConfigType.CONFIG_READY.name(),true);
    }
    //配置API
    public final Configurator withApiHost(String host){
        LATTE_CONFIG.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    //初始化图标
    private void initIcons(){
        if(ICONS.size()>0){
            final Iconify.IconifyInitializer initializer =Iconify.with(ICONS.get(0));
            // 0已经被加入
            for(int i=1;i<ICONS.size();i++){
                initializer.with(ICONS.get(i));
            }
        }
    }
    public final Configurator withIcon(IconFontDescriptor descriptor){
        ICONS.add(descriptor);
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
        return (T) LATTE_CONFIG.get(key.name());
    }

}

