package DesignPattern.Factory.AbstractFactory;

/**
 * 抽象工厂模式，一般用于工具中
 * 不可以增加产品，可以增加产品族
 */
public class Client {
    public static void main(String[] args) {
        //创建一个奢侈车工厂
        CarFactory factory = new LuxuryCarFactory();
        //然后调用奢侈汽车的方法
        Engine e = factory.creatEngine();
        e.run();
        e.start();
    }
}
