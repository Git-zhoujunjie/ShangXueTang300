package ThreadStudy;

/**
 * 线程的优先级setPriority()
 * 设置范围：1-10 ，不能超过其范围
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5
 * MAX_PRIORITY = 10
 *
 * 注意：优先级只代表线程被执行的概率，优先级高的被执行的概率高一些，
 * 并不是严格按照优先级点的高低进行执行
 */
public class ThreadPriority {
    public static void main(String[] args) {
        Thread t = new Thread(new MyPriority());

        System.out.println(t.getPriority());
        Thread t1 = new Thread(new MyPriority());
        Thread t2 = new Thread(new MyPriority());
        Thread t3 = new Thread(new MyPriority());
        Thread t4 = new Thread(new MyPriority());
        Thread t5 = new Thread(new MyPriority());
        Thread t6 = new Thread(new MyPriority());

        //设置优先级，注意设置优先级要在start()之前
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }
}

class MyPriority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
