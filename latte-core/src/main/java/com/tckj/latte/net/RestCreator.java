package com.tckj.latte.net;

import com.tckj.latte.app.ConfigType;
import com.tckj.latte.app.Configurator;
import com.tckj.latte.app.Latte;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by tckj03 on 2017/10/20.
 */

public class RestCreator {
    public static final class RetrofitHolder{
        private static final String BASE_URL= (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());
        private static final Retrofit RETROFIT_CLIENT=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();   
    }
}
