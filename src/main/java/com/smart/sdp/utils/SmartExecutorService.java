package com.smart.sdp.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 简易线程池，指定线程名称
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-14
 */
public class SmartExecutorService {

    public static ExecutorService newInstance(String threadName) {

        //定义线程创建工厂
        ThreadFactory threadFactory = new SmartThreadFactory(threadName);

        //定义线程池，此处线程池的具体创建工厂，即使用的是我们自己所定义的SmartThreadFactory；
        ExecutorService pool = new ThreadPoolExecutor(200, 200,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(200), threadFactory, new ThreadPoolExecutor.AbortPolicy());

        //关于线程池的参数含义：https://www.jianshu.com/p/f030aa5d7a28
        //说明一点：
        //


        return pool;
    }

}
