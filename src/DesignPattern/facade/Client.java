package DesignPattern.facade;

public class Client {
    public static void main(String[] args) {
        System.out.println("参加一场演唱会。。。。。");
//        new 买票().work();
//        new 协商().work();
//        new 签合同().work();
//        new 付钱().work();

        //用外观模式
        new Agent().work();
    }
}
