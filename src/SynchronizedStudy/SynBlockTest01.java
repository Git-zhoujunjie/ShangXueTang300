package SynchronizedStudy;

/**
 * 采用同步方法进行锁资源
 */
public class SynBlockTest01 {
    public static void main(String[] args) {
        Account3 a1 = new Account3("结婚礼金",1000);
        People3 you = new People3(a1,60,"悲惨的你");
        People3 gf = new People3(a1,90,"快乐的她");


        gf.start();
        you.start();
    }
}

class Account3{
     String name;  //账户名
     double account;  //金额

    public Account3(String name, double account) {
        this.name = name;
        this.account = account;
    }
}

class People3 extends Thread{
     Account3 a1;
     double drawMoney;
     double packetMoney;

    public People3(Account3 a1, double drawMoney,String name) {
        super(name);
        this.a1 = a1;
        this.drawMoney = drawMoney;

    }

    /**
     * synchronized块锁账户资源
     */
    @Override
    public void run() {

        //这样的代码很值钱，能很大程度上提升多线程效率
        if(a1.account<=0) return;  //当一个线程发行存款不足时，可以直接返回，提升效率

        synchronized (a1) {

            if(a1.account< drawMoney){
                System.out.println("存款不足！！");
            }

            if (a1.account - drawMoney < 0) return;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            a1.account -= drawMoney;  //账户余额为减掉取的钱
            packetMoney += drawMoney;

            System.out.println(Thread.currentThread().getName() + packetMoney + " 账户余额：" + a1.account);
        }
        //System.out.println("她口袋的钱："+gf.packetMoney+" 账户余额："+a1.account);
    }
}
