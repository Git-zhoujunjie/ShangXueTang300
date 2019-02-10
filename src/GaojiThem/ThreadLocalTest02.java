package GaojiThem;

/**
 * ThreadLocal：每个线程拥有自身的数据，更改不会影响其他线程
 * get/set/initialValue
 */
public class ThreadLocalTest02 {
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
        for(int i=0;i<5;i++) {
            //根据输出结果可以看出，各个线程之间的threadLocal互不影响
            new Thread(new MyRun()).start();
        }
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            Integer left = threadLocal.get();//获取剩余数量
            System.out.println(Thread.currentThread().getName()+"得到了--"+left);
            threadLocal.set(left-1);
            System.out.println(Thread.currentThread().getName()+"还剩下--"+threadLocal.get());

        }
    }
}
