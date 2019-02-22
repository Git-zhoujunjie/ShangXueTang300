package DesignPattern.Singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 测试多线程环境下五种单例模式的效率
 */
public class Test03 {
    public static void main(String[] args) {
        int threadCount = 10;
        long t1 = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for(int i=0;i<threadCount;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                       // Object o = Demo01.getInstance();  //饿汉式    26ms
                        Object o2 = Demo02.getInstance(); //懒汉式   76
                //Object o3 = Demo03.getInstance(); //双重检查锁单例模式   20
              // Object o4 = Demo04.getInstance(); //静态内部类  72
    //           Object o5 = Demo05.INSTANCE; //枚举   18
                    }
                    countDownLatch.countDown();
                }

            }).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("耗时为："+(t2-t1));
    }
}
