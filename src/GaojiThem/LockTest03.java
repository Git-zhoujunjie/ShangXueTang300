package GaojiThem;

/**
 * 可重入锁：可连续使用 + 计数器
 */
public class LockTest03{
    ReentantLock lock = new ReentantLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.holdCount);
        b();
        lock.unlock();
        System.out.println(lock.holdCount);

    }
    public void b() throws InterruptedException {
        lock.lock();
        System.out.println(lock.holdCount);
        //b();
        lock.unlock();
        System.out.println(lock.holdCount);

    }
    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a(); //a()中先拿到锁，进入b()后，b又要拿锁，但a()的锁还没有释放，因此进入死循环
    }
}

//自定义一个不可重入锁
class ReentantLock{
    //标志锁是否被占用
    private boolean isLocked = false;
    //存储当前线程
    private Thread lockedBy = null;
    public int holdCount;

    //使用锁
    public synchronized void lock() throws InterruptedException {
        //当请求锁的线程等于当前锁所在的线程时，那么不用进入等待
        Thread t = Thread.currentThread();
        while(isLocked && lockedBy!= t){
            wait();  //当锁被占用时，就等待
        }
        isLocked = true;
        holdCount++;
        lockedBy = t;
    }
    //释放锁
    public synchronized void unlock() throws InterruptedException {

        if(lockedBy == Thread.currentThread()) {
            holdCount--;
            if(holdCount==0){
                isLocked = false;
                notify(); //通知结束阻塞
                lockedBy = null;
            }
        }
    }
}
