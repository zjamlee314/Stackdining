package com.stackdining.www.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.stackdining.www.app.Constant;
import com.stackdining.www.app.StackDinApplication;
import com.stackdining.www.model.api.IApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit工具类
 *
 * 使用规范：
 * 1、{@link RetrofitManager}使用静态内部类的单例模式
 * 2、使用 {@link #getInstance()}方法获取单例
 * 3、使用单例的{@link #create()}方法获取默认的{@link IApi}对象
 * 4、使用获取到的IApi对象调用对应的接口方法
 */
public class RetrofitManager {

    private Retrofit mRetrofit;
    private static final String BASE_URL = Constant.BASE_URL;
    //默认的IApi
    private IApi mIApi;
    private static final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
    private static final class SingleHolder {
        private static final RetrofitManager INSTANCE = new RetrofitManager(BASE_URL);
    }

    public static RetrofitManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    private RetrofitManager(String url) {
        mRetrofit = new Retrofit.Builder()
                //添加自动gson解析
                .addConverterFactory(GsonConverterFactory.create())
                //让Retrofit支持RxJava2
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //设置公共的url
                .baseUrl(url)
                //配置自己的okhttpClinet
                .client(buildOkhttpClient())
                .build();
    }

    public static OkHttpClient buildOkhttpClient() {
        //日志拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        //设置日志拦截器打印日志的级别
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //构造一个OkHttpClient对应
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();

                Request.Builder builder = request.newBuilder();
                //添加登录凭证
                SharedPreferences user = StackDinApplication.getAppContext().getSharedPreferences("name", Context.MODE_PRIVATE);
                String member_id = user.getString("member_id", null);
                String token = user.getString("token", null);
                String uuid = user.getString("uuid", null);
                String cookies = user.getString("cookies", null);
                if (token!=null){
                    builder.addHeader("token", token);
                }
                if (uuid!=null){
                    builder.addHeader("uuid", uuid);
                }
                if (member_id!=null){
                    builder.addHeader("memberId", member_id);
                }
//                if (cookies!=null){
//                    builder.addHeader("Cookie",cookies);
//                }
                Request build1 = builder.build();
                return chain.proceed(build1);
            }
        })
                .cookieJar(new CookieJar() {
                    @Override
                    public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
                        cookieStore.put(httpUrl.host(), list);
                        StringBuffer sb = new StringBuffer();

                        for(int k=0; k<list.size(); k++)
                        {
                            Log.e("循环获取Cookie信息", "name = " + list.get(k).name());
                            Log.e("循环获取Cookie信息", "value = " + list.get(k).value());
                            sb.append(list.get(k).name() + "=" + list.get(k).value() + ";");
                        }
//                        long date = list.get(0).expiresAt();  653d
//                        Log.e("cookie的有效时间是",showString(date+""));

                        SharedPreferences sp = StackDinApplication.getAppContext().getSharedPreferences("name",Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = sp.edit();

                        edit.putString("cookies",sb.toString());
                        edit.commit();
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl httpUrl) {
                        List<Cookie> cookies = cookieStore.get(httpUrl.host());
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    /**
     * 如果有其他的IApi，通过这个有参的方法创建
     */
    public <T> T create(final Class<T> service) {
        return mRetrofit.create(service);
    }

    /**
     * 创建默认的单例IApi
     */
    public IApi create() {
        if (mIApi == null) {
            mIApi = create(IApi.class);
        }
        return mIApi;
    }

}