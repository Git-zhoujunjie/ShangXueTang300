package DesignPattern.Mediator;

public class Client {
    public static void main(String[] args) {
        Mediator m = new President();  //创建总经理
        Department market = new Market(m);
        Department devp = new Development(m);
        Department fi = new Finacial(m);

        market.selfAction();
        market.outAction();
    }
}
