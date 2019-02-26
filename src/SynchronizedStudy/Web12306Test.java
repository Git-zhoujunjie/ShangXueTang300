package SynchronizedStudy;

/**
 * 实现12306网站买票的过程
 * 用synchronized方法进行同步
 */
public class Web12306Test{
    public static void main(String[] args) {
        WebTrain wt = new WebTrain(20,"hello12306");
        new TrainCustomer(wt,7,"aa").start();
        new TrainCustomer(wt,8,"bb").start();
    }
}

/**
 * TrainCustomer类相当于一个静态代理
 * 一个顾客代理一次购票
 */
class TrainCustomer extends Thread{
    int bookTickets;

    public TrainCustomer(Runnable target, int bookTickets, String name) {
        super(target,name);
        this.bookTickets = bookTickets;//订的票数
    }
}


class WebTrain implements Runnable{
    int tickets;
    String name;

    public WebTrain(int tickets, String name) {
        this.tickets = tickets;
        this.name = name;
    }


    @Override
    public synchronized void run() {
        TrainCustomer tg = (TrainCustomer)Thread.currentThread();
        boolean flag = this.bookTickets(tg.bookTickets); //获取当前代理线程的票数

        if (flag) {
            System.out.println("订票成功！" + Thread.currentThread().getName() + "订票数：" + tg.bookTickets);
        } else {
            System.out.println("订票失败！" + Thread.currentThread().getName() + "票不足！");
        }

    }

    //y采用同步方法
    //购票
    public  boolean bookTickets(int bts){
        System.out.println("剩余票数："+tickets);
        if(tickets<bts)return false;

        tickets -= bts;

        return true;
    }
}
