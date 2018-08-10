package com.mlethe.face.retrofit;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.mlethe.face.utils.NetUtil;
import com.mlethe.face.utils.Tool;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private String mBaseUrl = "https://api-cn.faceplusplus.com/facepp/";
    // 公共参数拦截器
    private HttpInterceptor mCommonInterceptor = null;

    private boolean mCache = false;

    private static final int DEFAULT_TIME_OUT = 30;//超时时间 30s
    private static final int DEFAULT_READ_TIME_OUT = 10;
    private static final long DEFAULT_DIR_CACHE = 10;
    private Retrofit mRetrofit;
    private boolean mAddParam = true;

    private RetrofitClient() {
    }

    /**
     * 获取RetrofitClient
     *
     * @return
     */
    public static RetrofitClient getInstance() {
        return new RetrofitClient();
    }

    /**
     * 设置基础链接
     *
     * @param baseUrl
     * @return
     */
    public RetrofitClient baseUrl(String baseUrl) {
        this.mBaseUrl = baseUrl;
        return this;
    }

    /**
     * 设置公共参数
     *
     * @param interceptor
     * @return
     */
    public RetrofitClient addHttpInterceptor(HttpInterceptor interceptor) {
        this.mCommonInterceptor = interceptor;
        return this;
    }

    /**
     * 是否缓存
     *
     * @param cache true 缓存  false 不缓存
     * @return
     */
    public RetrofitClient isCache(boolean cache) {
        this.mCache = cache;
        return this;
    }

    /**
     * 是否添加公共参数
     *
     * @param addParam true 添加  false 不添加
     * @return
     */
    public RetrofitClient isAddParam(boolean addParam) {
        this.mAddParam = addParam;
        return this;
    }

    /**
     * 获取对应的Service
     *
     * @param service Service 的 class
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> service) {
        apply();
        return mRetrofit.create(service);
    }

    /**
     * 创建retrofit
     *
     * @return
     */
    private RetrofitClient apply() {
        File cacheFile = new File(Tool.getContext().getCacheDir(), "caheData");
        //设置缓存大小
        Cache cache = new Cache(cacheFile, DEFAULT_DIR_CACHE);//google建议放到这里

        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)//连接失败后是否重新连接
                .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)//连接超时时间
                .writeTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS)//写操作超时时间
                .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        if (mCache) {
            builder.addNetworkInterceptor(REWRITE_RESPONSE_INTERCEPTOR)    //有网络时的拦截器
                    .addInterceptor(REWRITE_RESPONSE_INTERCEPTOR_OFFLINE)   // 没网络时的拦截器
                    .cache(cache);
        }

        // 添加公共参数拦截器
        if (mAddParam) {
            if (mCommonInterceptor == null) {
                mCommonInterceptor = new HttpInterceptor.Builder().build();
            }
            builder.addInterceptor(mCommonInterceptor);
        }

        builder.addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                // 打印返回结果信息
//                Log.e("TAG", message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.BODY));

        Retrofit.Builder retrofitBuild = new Retrofit.Builder()
                .client(builder.build())
                // 添加解析转换工厂,Gson 解析，Xml解析，等等
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()))
//                .addCallAdapterFactory()
                .baseUrl(mBaseUrl);
        // 各种套路和招式 ，发现问题解决问题，基础，源码的理解
        // 1. 没打印？
        // 2. 数据格式不一致？成功 data 是个对象，不成功 data 是个 String
        // 3. 还有就是 baseUrl 问题？ (Retrofit 找不到任何入口可以修改)
        //        3.1 不同的 baseUrl 构建不同的 Retrofit 对象 （直不应该首选）
        //        3.2 自己想办法，取巧也行走漏洞
        // 创建Retrofit
        mRetrofit = retrofitBuild.build();
        return this;
    }

    private static final int TIMEOUT_CONNECT = 5; //5秒
    private static final int TIMEOUT_DISCONNECT = 60 * 60 * 24 * 7; //7天

    /**
     * 在线缓存
     */
    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            //获取retrofit @headers里面的参数，参数可以自己定义，在本例我自己定义的是cache，跟@headers里面对应就可以了
            String cache = chain.request().header("cache");
            okhttp3.Response originalResponse = chain.proceed(chain.request());
            String cacheControl = originalResponse.header("Cache-Control");
            //如果cacheControl为空，就让他TIMEOUT_CONNECT秒的缓存，本例是5秒，方便观察。注意这里的cacheControl是服务器返回的
            if (cacheControl == null) {
                //如果cache没值，缓存时间为TIMEOUT_CONNECT，有的话就为cache的值
                if (cache == null || "".equals(cache)) {
                    cache = TIMEOUT_CONNECT + "";
                }
                originalResponse = originalResponse.newBuilder()
                        .header("Cache-Control", "public, max-age=" + cache)
                        .build();
                return originalResponse;
            } else {
                return originalResponse;
            }
        }
    };

    /**
     * 离线缓存
     */
    public static final Interceptor REWRITE_RESPONSE_INTERCEPTOR_OFFLINE = new Interceptor() {
        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            //离线的时候为7天的缓存。
            if (!NetUtil.isNetworkConnected()) {
                request = request.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale="+TIMEOUT_DISCONNECT)
                        .build();
            }
            return chain.proceed(request);
        }
    };
}
