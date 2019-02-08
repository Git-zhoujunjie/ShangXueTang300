package SynchronizedStudy;

/**
 * 采用同步方法进行锁资源
 */
public class SynMethodTest02 {
    public static void main(String[] args) {
        Account2 a1 = new Account2("结婚礼金",100);
        People2 you = new People2(a1,60,"悲惨的你");
        People2 gf = new People2(a1,90,"快乐的她");


        gf.start();
        you.start();
    }
}

class Account2{
     String name;  //账户名
     double account;  //金额

    public Account2(String name, double account) {
        this.name = name;
        this.account = account;
    }
}

class People2 extends Thread{
     Account2 a1;
     double drawMoney;
     double packetMoney;

    public People2(Account2 a1, double drawMoney,String name) {
        super(name);
        this.a1 = a1;
        this.drawMoney = drawMoney;

    }

    /**
     * synchronized方法
     * 可以看出，这里结果依然有问题，说明资源没有锁对
     * synchronized锁的是整个this对象，包括a1，drawMoney，packetMoney，这样锁了之后实际上和没锁基本没有区别
     * 两个人在同一个账户上进行取钱，他们共用同一个账户，因此共享资源是账户，所以只需要锁账户就行了
     */
    @Override
    public synchronized void run() {
        if(a1.account-drawMoney<0) return;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a1.account -= drawMoney;  //账户余额为减掉取的钱
        packetMoney += drawMoney;

        System.out.println(Thread.currentThread().getName()+packetMoney+" 账户余额："+a1.account);
        //System.out.println("她口袋的钱："+gf.packetMoney+" 账户余额："+a1.account);
    }
}
