package ThreadStudy;

/**
 * Daemon
 * 守护线程：为用户线程服务，jvm停止时不用等待守护线程执行完毕
 * 线程默认的状态都是用户线程，jvm只有等待用户线程执行完毕后才会停止
 */

public class DaemonTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new You2());
        Thread t2 = new Thread(new God());

        //将God设置为守护线程
        t2.setDaemon(true); //默认是false，现在改为true

        t2.start();
        t1.start();
    }
}

class You2 implements Runnable{
    @Override
    public void run() {

        for(int i=0;i<365*90;i++){
            System.out.println("happyLife！");
        }

        System.out.println("you are dead...");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println("God bless you...");
        }
    }
}
