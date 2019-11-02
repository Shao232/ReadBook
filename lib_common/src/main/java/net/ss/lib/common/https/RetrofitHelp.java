package net.ss.lib.common.https;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.ss.lib.common.Constans;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ss
 * created 2019/11/2 14:07
 */
public class RetrofitHelp {

    private volatile static RetrofitHelp retrofitHelp;

    private Retrofit retrofit;

    private RetrofitHelp() {
        OkHttpClient client = new OkHttpClient().newBuilder()
                //设置读取超时时间
                .readTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)
                //设置请求超时时间
                .connectTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)
                //设置写入超时时间
                .writeTimeout(Constans.DEFAULT_TIME, TimeUnit.SECONDS)
                //添加打印拦截器
                .addInterceptor(new BaseInterceptor())
                //设置出现错误进行重新连接。
                .retryOnConnectionFailure(true)
                .build();

        retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl(RequestApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();


    }

    public static RetrofitHelp getInstance() {
        if (retrofitHelp == null) {
            synchronized (RetrofitHelp.class) {
                if (retrofitHelp == null) {
                    retrofitHelp = new RetrofitHelp();
                }
            }
        }
        return retrofitHelp;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}
