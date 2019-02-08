package ThreadStudy;

/**
 * 模拟龟兔赛跑Racer
 * 兔子和乌龟同时跑，看谁先到达终点
 */
public class ThreadDemo05 implements Runnable{
    private String winner;

    @Override
    public void run() {
        for(int steps=0;steps<=100;){

            if(Thread.currentThread().getName().equals("Rabbit") && steps%10==0){ //兔子会睡觉,每走10步碎觉
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--->"+steps);
                steps += 20; //兔子速度为2
            }else if(Thread.currentThread().getName().equals("Rabbit") && steps%10!=0){
                System.out.println(Thread.currentThread().getName()+"--->"+steps);
                steps += 20; //兔子速度为2
            }else{
                System.out.println(Thread.currentThread().getName()+"--->"+steps++);
            }
            //分别记录乌龟和兔子走的步数，100为终点


            //比赛是否接受
            if(win(steps)){
                break;
            }
        }

    }

    private boolean win(int steps){
        if(winner !=  null){ //存在胜利者
            return true;
        }else{
            if(steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner"+"--->"+winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ThreadDemo05 test = new ThreadDemo05();//一份资源，多代理共享
        new Thread(test,"乌龟").start();
        new Thread(test,"Rabbit").start();

    }
}
