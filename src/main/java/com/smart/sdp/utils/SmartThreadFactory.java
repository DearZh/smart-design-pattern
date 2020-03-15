package com.smart.sdp.utils;

import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  实现ThreadFactory接口，定义一个简单的线程工厂，便于定义线程属性（名称），
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-14
 */
public class SmartThreadFactory implements ThreadFactory {

    private ThreadFactory backingThreadFactory = null;
    private String threadName = null;
    //用来指定当前所创建线程池的编号
    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    public SmartThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {

        //还是使用Executors默认的线程池方法进行线程池的创建；Executors.defaultThreadFactory()
        //可以参考：Executors.newCachedThreadPool()创建线程池时内部线程工厂的创建方式，也就是上述的defaultThreadFactory(),此处做下相关参考；
        backingThreadFactory = this.backingThreadFactory != null ?
                this.backingThreadFactory : Executors.defaultThreadFactory();
//        System.out.println("backingThreadFactory：" + backingThreadFactory);

        //创建一个线程Thread
        Thread thread = backingThreadFactory.newThread(r);

        //将默认线程池创建后的Thread，进行ThreadName的修改，定义一个新的线程名称；（方便后续线程池问题时的debug）
        if (threadName != null) {

            //通过mThreadNum获取当前所创建的线程池编号，然后通过format格式化线程名称 %d ；
            thread.setName(format(threadName, mThreadNum.getAndIncrement()));

            //重新定义后的线程池线程在使用过程中，输出结果基本如下所示：其中singModel是定义线程池的名称；
            // 1,2,3,200分别表示当前线程在线程池中的创建编号，也就是上述创建线程名称时的： mThreadNum.getAndIncrement()；
            //Thread[singleModel-1,5,main]
            //Thread[singleModel-2,5,main]
            //Thread[singleModel-3,5,main]
            //Thread[singleModel-200,5,main]
        }
        return thread;
    }

    private static String format(String format, Object... args) {
        return String.format(Locale.ROOT, format, args);
    }

    /*
    public SmartThreadFactory setNameFormat(String threadName) {
        this.threadName = threadName;
        return this;
    }
    */

}
