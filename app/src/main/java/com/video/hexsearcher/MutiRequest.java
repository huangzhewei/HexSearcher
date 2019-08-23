package com.video.hexsearcher;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * 多线程网络请求队列
 */
public class MutiRequest {

    private static MutiRequest instance;

    /**
     * 请求队列。
     */
    private RequestQueue requestQueue;

    private MutiRequest() {
        requestQueue = NoHttp.newRequestQueue(10);
    }

    /**
     * 请求队列。
     */
    public static MutiRequest getInstance() {
        if (instance == null)
            synchronized (MutiRequest.class) {
                if (instance == null)
                    instance = new MutiRequest();
            }
        return instance;
    }

    /**
     * 添加一个请求到请求队列。
     *
     * @param what     用来标志请求, 当多个请求使用同一个Listener时, 在回调方法中会返回这个what。
     * @param request  请求对象。
     * @param listener 结果回调对象。
     */
    public <T> void add(int what, Request<T> request, OnResponseListener listener) {
        requestQueue.add(what, request, listener);
    }

    /**
     * 取消这个sign标记的所有请求。
     *
     * @param sign 请求的取消标志。
     */
    public void cancelBySign(Object sign) {
        requestQueue.cancelBySign(sign);
    }

    /**
     * 取消队列中所有请求。
     */
    public void cancelAll() {
        requestQueue.cancelAll();
    }
}
