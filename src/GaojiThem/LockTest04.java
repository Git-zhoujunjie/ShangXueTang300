package GaojiThem;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 了解JUC下的可重入锁ReentrantLock
 */
public class LockTest04 {
    ReentrantLock lock = new ReentrantLock(); //JUC下的可重入锁，和之前的例子类似
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        b();
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //b();
        lock.unlock();
        System.out.println(lock.getHoldCount());

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a(); //a()中先拿到锁，进入b()后，b又要拿锁，但a()的锁还没有释放，因此进入死循环
    }
}
