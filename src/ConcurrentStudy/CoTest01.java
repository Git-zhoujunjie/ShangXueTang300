package ConcurrentStudy;

/**
 * 并发协作：
 * 协作模型：生产者消费者模型实现方式一：管程法
 * 即借助一个缓冲区连接生产者与消费者，这里采用一个并发数组
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer sync = new SynContainer(new Mantou[10]);

        new Thread(new Producer(sync)).start();
        new Thread(new Consumer(sync)).start();
    }
}

//生产者
class Producer implements Runnable{
    SynContainer sc ;

    public Producer(SynContainer sc) {
        this.sc = sc;
    }

    @Override
    public void run() {
        //生产馒头
        //生产100个馒头
        for(int i=1;i<=100;i++){
            sc.push(new Mantou(i));
            System.out.println("生产了第"+i+"号馒头-----" + sc.count);
        }
    }
}
//消费者
class Consumer implements Runnable{
    SynContainer sc ;
    public Consumer(SynContainer sc) {
        this.sc = sc;
    }
    @Override
    public void run() {
        //消费馒头
        for(int i=1;i<=100;i++){
            Mantou m = sc.pop();

            System.out.println("消费了第"+m.i+"号馒头---" + sc.count);
        }
    }
}
//馒头类
class Mantou{
    int i;  //给馒头编号

    public Mantou(int i) {
        this.i = i;
    }
}
//缓冲区
class SynContainer{
    Mantou[] container; //一个馒头数组，存储馒头对象
    int count=0;

    public SynContainer(Mantou[] container) {
        this.container = container;
    }

    //生产馒头
    public synchronized void push(Mantou m){
        //何时不能生产，容器满了后不能生产
        if(count == container.length){
            try {
                this.wait();  //生产者阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        container[count] = m;
        count++;
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.notifyAll(); //通知消费者接触阻塞
    }
    //消费馒头
    public synchronized Mantou pop(){
        //没有数据时，等待
        if(count == 0){
            try {
                this.wait();  //线程阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        Mantou m = container[count];
//        try {
//            Thread.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.notifyAll(); //通知生产者解除阻塞
        return m;
    }
}