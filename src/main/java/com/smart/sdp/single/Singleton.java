package com.smart.sdp.single;

import com.smart.sdp.utils.SmartExecutorService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * 定义单例对象
 *
 * @author Arnold.zhao <a href="mailto:Arnold_zhao@126.com"/>
 * @create 2020-03-14
 */
public class Singleton {

    private static Singleton singleton = null;

    //私有构造函数
    private Singleton() {
    }

    /**
     * @description: 实例化类
     */
    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (singleton == null) {
                System.out.println("new Singleton()：" + Thread.currentThread());
                singleton = new Singleton();
            }
        }
        return singleton;
    }

    /**
     * 定义线程池
     */
    static ExecutorService executor = SmartExecutorService.newInstance("singleModel-%d");

//    static ExecutorService executor1 = Executors.newCachedThreadPool()

    /**
     * 使用Set集合可以过滤掉重复的对象数据
     */
    static Set<String> set = Collections.synchronizedSet(new HashSet<String>());

    /**
     * 用来栏栅线程是否启动完毕
     */
    static CountDownLatch countDownLatchBefore = new CountDownLatch(200);
    /**
     * 通过在主线程中控制countDownLatch，用来解除所有子线程的等待，进行所有子线程的并发执行；
     */
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    /**
     * 用来判断当前所有子线程是否均执行完毕，执行完毕后则执行主线程；
     */
    static CountDownLatch countDownLatchEnd = new CountDownLatch(200);

//    static volatile boolean flag = false;


    public static void main(String[] args) throws InterruptedException {

        /*
            Singleton singleton1 = Singleton.getInstance();
            Singleton singleton2 = Singleton.getInstance();
            Singleton singleton3 = Singleton.getInstance();
            System.out.println(singleton1 + "：" + singleton2 + "：" + singleton3);
        */
        //com.smart.sdp.single.Singleton@4554617c：com.smart.sdp.single.Singleton@4554617c：com.smart.sdp.single.Singleton@4554617c
        //输出结果如上：可以看出三个对象变量所对应的对象内存引用地址是相同的，则说明此时通过instace()方法得到的类的确是单例的；


        //***********************************************************************************************
        //**************************此处更改为多线程实例化对象，则类的创建还是单例的吗？*****************


        for (int i = 0; i < 200; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("execute："+Thread.currentThread());
                    countDownLatchBefore.countDown();
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("同时抢夺"+Thread.currentThread());
                    for (int j = 0; j < 200; j++) {
                        set.add(Singleton.getInstance().toString());
                    }

                    countDownLatchEnd.countDown();
                }
            });
        }

        //等待200个线程全部启动完成后再向下执行
        countDownLatchBefore.await();

        System.out.println("countDownLatchBefore_Count_Value：" + countDownLatchBefore.getCount());

        //开启200个线程的并发执行
        countDownLatch.countDown();

        //等待，上述所有线程均执行完毕后，再进行集合输出
        countDownLatchEnd.await();
        System.out.println("countDownLatchEnd_Count_Value：" + countDownLatchEnd.getCount());

        for (String sin : set) {
            System.out.println(sin);
        }
        executor.shutdownNow();
        System.out.println("执行完成");
        /*
           此时输出结果！com.smart.sdp.single.Singleton@65b7f2c3，com.smart.sdp.single.Singleton@546f963b，com.smart.sdp.single.Singleton@1dc63e61
           这充分说明了，在线程并发的情况下，上述的单例判断是会出现并发异常的！！！，所以需要给当前实例化的方法加锁才是OK的；
        */
    }

}
