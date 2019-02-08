package SynchronizedStudy;

/**
 * 线程安全：保证数据的正确性（最基本的要求），效率尽可能的高
 * 使用synchronized关键字 同步
 * 1、synchronized方法  同步方法
 * 2、synchronized块  同步块
 *
 */
public class SynMethodTest01 implements Runnable{
    private int ticket = 10; //票数
    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();

        }
    }

    /**
     * 注意：synchronized锁的不是test()方法，而是test()方法执行时所用到的对象this
     * 这里就是ticket
     *
     * 线程安全：同步
     */
    public synchronized void test() {  //synchronized方法
        if (ticket <= 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "--->" + ticket--);

    }

    public static void main(String[] args) {
        SynMethodTest01 test = new SynMethodTest01();

        new Thread(test,"王二").start();
        new Thread(test,"张三").start();
        new Thread(test,"李四").start();
    }
}
