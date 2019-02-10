package GaojiThem;

/**
 * 可重入锁：同一个锁可连续使用
 */
public class LockTest {

    public void test() throws InterruptedException {
        //第一次获得锁
        synchronized (this) {
            while (true) {
                //第二次获得锁
                synchronized (this){
                    System.out.println("ReentantLock!");
                }
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new LockTest().test();//能够输出，说明该锁是可重入锁
    }
}
