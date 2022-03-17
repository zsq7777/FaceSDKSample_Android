package com.baidu.idl.face.http.httputil;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitServiceManager {

    private static final int DEFAULT_CONNECT_TIME = 12;
    private static final int DEFAULT_WRITE_TIME = 12;
    private static final int DEFAULT_READ_TIME = 12;
    private static OkHttpClient okHttpClient;
    //尤培接口地址
    public static String BASE_URL = "http://117.34.70.84:14100/";
    private static Retrofit retrofit;

    private RetrofitServiceManager() {
        retrofit = new Retrofit.Builder()
                .client(initOKHttp())//设置使用okhttp网络请求
                .baseUrl(BASE_URL)//设置服务器路径
//                .addConverterFactory(GsonConverterFactory.create())//添加转化库，默认是Gson
                .addConverterFactory(ScalarsConverterFactory.create())//添加转化库，默认是Gson
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())//添加回调库，采用RxJava
                .build();

    }

    public static OkHttpClient initOKHttp() {
        if (okHttpClient == null) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
//                    message -> {
//                        //防止&、=都被转义
//                        LogUtils.e("okhttp==" + message);
//                    }
//            );
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient = new OkHttpClient.Builder()
                    //拦截器
                      .addInterceptor(new Interceptor() {
                          @Override
                          public Response intercept(Chain chain) throws IOException {
                              Request request = chain.request()
                                      .newBuilder()
                                      .addHeader("content-type", "application/json;charset=UTF-8")
                                      .addHeader("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJ1c2VyQ29kZUxvZ2luRGF0ZSI6MTY0NzIyMjQ1NjEyOCwiZW1wbG95ZWVOYW1lIjoienNxdGVzdCIsInVzZXJDb2RlIjoienNxdGVzdCJ9.QWPpM8Ql3h3FpZe8_2177f5qwBFIbEgJfOLFrTcx1j9fbgtapopmnT8rdyMORT1_yAUVKkMgEHb7SBOrRFJ2-g")
                                      .build();
                              return chain.proceed(request);
                          }
                      })
                    .addInterceptor(loggingInterceptor)
                    .connectTimeout(DEFAULT_CONNECT_TIME, TimeUnit.SECONDS)
                    .readTimeout(DEFAULT_READ_TIME, TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_WRITE_TIME, TimeUnit.SECONDS)
                    .build();
        }
        return okHttpClient;
    }

    private static class SingletonHolder {
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    /*

     * 获取RetrofitServiceManager

     **/

    public static RetrofitServiceManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public <T> T create(Class<T> service) {
        return retrofit.create(service);
    }

}

