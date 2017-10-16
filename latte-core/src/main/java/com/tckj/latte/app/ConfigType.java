package com.tckj.latte.app;

/**
 * Created by tckj03 on 2017/10/16.
 * 枚举唯一单例只能被初始化一次
 */

public enum ConfigType {
    API_HOST,//配置网络请求域名
    APPLICATION_CONTEXT,//全局上下文
    CONFIG_READY,//配置完成
    ICON//存储字体
}
