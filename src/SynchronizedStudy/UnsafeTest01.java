package SynchronizedStudy;

/*
    并发：Synchronize
    同一个对象被多个线程同时操作
 */

/**
 * 线程不安全的实例：
 * 模拟银行取钱
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        Account a1 = new Account("结婚礼金",100);
        People you = new People(a1,60,"悲惨的你");
        People gf = new People(a1,90,"快乐的她");


        gf.start();
        you.start();
    }
}

class Account{
     String name;  //账户名
     double account;  //金额

    public Account(String name, double account) {
        this.name = name;
        this.account = account;
    }
}

class People extends Thread{
     Account a1;
     double drawMoney;
     double packetMoney;

    public People(Account a1, double drawMoney,String name) {
        super(name);
        this.a1 = a1;
        this.drawMoney = drawMoney;

    }

    @Override
    public void run() {
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
