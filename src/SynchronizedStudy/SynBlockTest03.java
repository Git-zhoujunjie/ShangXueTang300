package SynchronizedStudy;

/**
 * 线程安全：保证数据的正确性（最基本的要求），效率尽可能的高
 *
 * 2、synchronized块  同步块
 *
 */
public class SynBlockTest03 implements Runnable{
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
            test5();

        }
    }

    /**
     * 尽可能锁定合理的范围，提升效率
     * 范围不是指代码的范围，指的是数据的完整性
     */
    public void test5() {

        //两个if语句，功能不同，DoubleChecking
        if (ticket <= 0) {  //这里考虑的是没有票的情况
            flag = false;
            return;
        }
        synchronized (this) {  //this包含ticket和flag
            if (ticket <= 0) {  //这里考虑的是最后一张票的情况，临界值情况
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
    }
    /**
     * 线程不安全
     * 范围太小，锁不住
     */
    public void test4() {
        synchronized (this) {  //this包含ticket和flag
            if (ticket <= 0) {
                flag = false;
                return;
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "--->" + ticket--);


    }

    /**
     * 线程不安全
     * 这个有问题，说明资源没有锁对；
     * ticket由整数转换为一个整形对象后，这个对象是不停的在变动；
     * 例如：(Integer)5和(Integer)6是两个不同的对象，因此锁这个对象并没有意义；
     * synchronized锁的是共享资源，就是地址不变点对象，对象中的属性是可以变动点
     */
    public void test3() {
        synchronized((Integer)ticket) {  //锁的是对象，因此需要进行强制转换，int转成Integer
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

    }
    /**
     * 同步块
     * 锁的范围太大，性能太低
     */
    public void test2() {
        synchronized(this) {  //this包含ticket和flag
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

    }
    /**
     *同步方法
     */
    public synchronized void test1() {  //synchronized方法
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
        SynBlockTest03 test = new SynBlockTest03();

        new Thread(test,"王二").start();
        new Thread(test,"张三").start();
        new Thread(test,"李四").start();
    }
}
