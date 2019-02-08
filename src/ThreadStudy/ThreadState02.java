package ThreadStudy;

/**
 * 暂停线程的方法02---yield()
 * 让线程的状态直接从 运行状态 变为 就绪状态，等待cpu的重新调度
 */
public class ThreadState02 {
    //TestYield test = new TestYield();

    public static void main(String[] args) {
        TestYield test1 = new TestYield("Thread01");
        TestYield test2 = new TestYield("Thread02");

        test1.start();
        test2.start();

    }
}

class TestYield extends Thread {
    public TestYield(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"一边coding " + i);

            if(i==20 && Thread.currentThread().getName().equals("Thread01")) {
                Thread.yield();
            }
        }
    }
}
