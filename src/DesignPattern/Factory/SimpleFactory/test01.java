package DesignPattern.Factory.SimpleFactory;

/**
 * 简单工厂实现
 * 缺点：不符合OCP（开闭原则）
 */
public class test01 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createrCar("baoma");
        Car c2 = CarFactory.createrCar("benci");

        System.out.println(c1);
        System.out.println(c2);
    }
}
