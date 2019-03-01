package DesignPattern.Proxy.staticProxy;

/**
 * 测试静态代理
 */
public class Client {
    public static void main(String[] args) {
        Star star = new RealStar();

        new ProxyStar(star).confer();
        new ProxyStar(star).signContract();
        new ProxyStar(star).bookTicket();
        new ProxyStar(star).sing();
        new ProxyStar(star).collectMoney();
    }
}
