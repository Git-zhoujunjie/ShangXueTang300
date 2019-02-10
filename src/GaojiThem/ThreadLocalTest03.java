package GaojiThem;

/**
 * ThreadLocal：分析上下文，环境，重点看起点
 * 即弄清楚当前点threadLocal到底属于哪个线程
 * 1、构造器：哪里调用就属于哪里
 * 2、run()：新的线程
 */
public class ThreadLocalTest03 {
    //private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    //更改初始值  匿名内部类
    /*private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 200;
        }
    };*/
    //设置初始值方法二：Lambda表达式
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->3);

    public static void main(String[] args) {
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        //这个threadLocal属于main线程
        public MyRun(){
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

        }

        //这个threadLocal属于新线程
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"--->"+threadLocal.get());

        }
    }
}
