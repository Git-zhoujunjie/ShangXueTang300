package ThreadStudy;

/**
 * 插队join()，线程的联合
 * 线程A在运行期间，可以调用线程B的join()方法，让线程B和线程A联合。
 * 这样，线程A就必须等待线程B执行完毕后，才能继续执行。
 *
 * 模拟 爸爸叫日子买烟的过程
 */
public class ThreadState03 {
    public static void main(String[] args) {
        new Father().start();
    }
}

class Father extends Thread{
    @Override
    public void run() {
        System.out.println("爸爸想要抽烟，叫儿子去买烟，");
        System.out.println("爸爸把钱给儿子，");

        Son son = new Son();
        son.start(); //必须要start()

        try {
            son.join();  //进入儿子线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //回到Father线程
        System.out.println("爸爸拿到烟，并把零钱给了儿子");
    }
}

class Son extends Thread{
    @Override
    public void run() {
        System.out.println("儿子出门去买烟，");
        System.out.println("看到一家游戏厅，便进去玩了半小时");
        int i=1;
        while(true){
            if(i%5==0){
                System.out.println(i+"min过去了。。。");
            }
            i++;

            if(i>30) break;
        }
        System.out.println("儿子突然想起要买烟，赶紧去买烟。");
        System.out.println("儿子买完烟回家");

    }
}
