package GaojiThem;

/**
 * InheritableThreadLocal：threadLocal的继承，
 * 将父线程的threadLocal拷贝一份给子线程，子线程更改不会影响到父线程
 */
public class ThreadLocalTest04 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    private static ThreadLocal<Integer> threadLocal1 = new InheritableThreadLocal<>();

    public static void main(String[] args) {
//        threadLocal.set(100);
//        System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
//        new Thread(new MyRun()).start();

        threadLocal1.set(100);
        System.out.println(Thread.currentThread().getName()+"--->"+threadLocal1.get());
        //此线程由main()线程开辟
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{

        //这个threadLocal属于新线程
        @Override
        public void run() {
            //System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal1.get());


        }
    }
}
