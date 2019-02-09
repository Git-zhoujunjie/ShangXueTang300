package ConcurrentStudy;

/**
 * 并发协作：
 * 协作模型：生产者消费者模型实现方式二：标志位法
 */
public class CoTest02 {
    public static void main(String[] args) {
        TV tv = new TV();

        new Player(tv).start();
        new Watcher(tv).start();

    }
}

/*
 * 模拟一次观众与演员互动
 */
//演员
class Player extends Thread{
    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++){
            if(i%2==0){
                this.tv.say("奇葩说");
            }else{
                this.tv.say("广告time，休息一下再回来");
            }
        }
    }
}
//观众
class Watcher extends Thread{
    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for(int i=0;i<20;i++) {
            this.tv.hear();
        }
    }
}
//同一个资源，电视
class TV {
    String word;
    boolean flag = true;

    //演员说
    public synchronized void say(String word){
        //演员等待
        if(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //表演时刻
        System.out.println("演员说了："+word);
        this.word = word;

        this.notifyAll();
        this.flag = !this.flag;
    }
    //观众听
    public synchronized void hear(){
        //观众等待
        if(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //观看
        System.out.println("观众听到了："+word);
        //唤醒
        this.notifyAll();
        this.flag = !this.flag;
    }
}
