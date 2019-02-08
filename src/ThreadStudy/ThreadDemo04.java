package ThreadStudy;

/**
 * 模拟Web12306，实现Runnable的资源共享，并发（线程安全）
 */
public class ThreadDemo04 implements Runnable{
    private int ticket = 100; //票数


    @Override
    public void run() {


        while(ticket>0){

            //出现负数，思考为何？
            //每个线程都有一个独立的线程空间，线程执行时会将内存中的值（这里为ticket）复制到自己的工作空间中
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印抢到票的线程名
            System.out.println(Thread.currentThread().getName()+"--->"+ ticket--);
        }

    }

    public static void main(String[] args) {
        ThreadDemo04 test = new ThreadDemo04();

        new Thread(test,"王二").start();
        new Thread(test,"张三").start();
        new Thread(test,"李四").start();
    }
}
