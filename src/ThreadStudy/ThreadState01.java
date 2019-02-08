package ThreadStudy;

/**
 * 暂停线程方法01---sleep()
 * 让正在运行的线程进入阻塞状态，直到休眠时间满了，进入就绪状态
 *
 * 模拟火箭发射倒计时
 */
public class ThreadState01 implements Runnable{
    private int num = 10;
    @Override
    public void run() {
        while(true){
            System.out.println("倒计时："+ num--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num<1){
                System.out.println("发射！");
                break;
            }
        }

    }

    public static void main(String[] args) {
        new Thread(new ThreadState01()).start();
    }
}
