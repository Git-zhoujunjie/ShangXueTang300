package GaojiThem;

/**
 * 不可重入锁：不可连续使用
 */
public class LockTest02 {
    Lock lock = new Lock();
    public void a() throws InterruptedException {
        lock.lock();
        b();
        lock.unlock();
    }
    public void b() throws InterruptedException {
        lock.lock();
        //b();
        lock.unlock();
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest02 test = new LockTest02();
        test.a(); //a()中先拿到锁，进入b()后，b又要拿锁，但a()的锁还没有释放，因此进入死循环
    }
}

//自定义一个不可重入锁
class Lock{
    //标志锁是否被占用
    private boolean isLocked = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while(isLocked){
            wait();  //当锁被占用时，就等待
        }
        isLocked = true;
    }
    //释放锁
    public synchronized void unlock() throws InterruptedException {
        isLocked = false;
        notify();
    }
}
