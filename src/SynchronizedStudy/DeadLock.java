package SynchronizedStudy;

/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而造成相互等待
 * 一般发生于同步中持有多个对象的锁
 * 条件：互斥条件、请求与保持、不剥夺条件、循环等待条件
 *
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup makeup = new Makeup(new LipStick(),new Mirror());

        new Girl("小红",true,makeup).start();
        new Girl("小雪",false,makeup).start();
    }
}

//模拟一个人既想要口红又想要造镜子，造成死锁

//涂口红
class LipStick{}

//照镜子
class Mirror{}

class Girl extends Thread{  //一个静态代理类
    String name;
    boolean flag;

    public Girl(String name, boolean flag,Runnable target) {
        super(target, name);
        this.flag = flag;
    }
}
//化妆
class Makeup implements Runnable{
    LipStick lipStick ;
    Mirror mirror ;

    public Makeup(LipStick lipStick, Mirror mirror) {
        this.lipStick = lipStick;
        this.mirror = mirror;
    }

    @Override
    public void run() {
        boolean flag = ((Girl)Thread.currentThread()).flag;
        if(flag){
            synchronized (lipStick){
                System.out.println(Thread.currentThread().getName()+"正在涂口红。。。");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*
                //持有锁中锁，造成死锁，解决方法：将锁内锁移到锁外即可
                synchronized (mirror){
                    System.out.println(Thread.currentThread().getName()+"正在照镜子。。。");
                }*/
            }
            //相当于用完口红就释放资源
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"正在照镜子。。。");
            }
        }else {
            synchronized (mirror){
                System.out.println(Thread.currentThread().getName()+"正在照镜子。。。");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*
                synchronized (lipStick){
                    System.out.println(Thread.currentThread().getName()+"正在涂口红。。。");
                }*/
            }
            synchronized (lipStick){
                System.out.println(Thread.currentThread().getName()+"正在涂口红。。。");
            }
        }
    }
}
