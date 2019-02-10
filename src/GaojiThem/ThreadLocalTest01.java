package GaojiThem;

/**
 * ThreadLocal：每个线程自身的存储本地、局部区域
 * get/set/initialValue
 */
public class ThreadLocalTest01 {
    //private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    //更改初始值  匿名内部类
    /*private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
        @Override
        protected Integer initialValue() {
            return 200;
        }
    };*/
    //设置初始值方法二：Lambda表达式
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName()+"-->"+threadLocal.get());

        }
    }
}
