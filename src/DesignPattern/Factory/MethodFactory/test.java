package DesignPattern.Factory.MethodFactory;

/**
 * 工厂方法模式
 * 符合OCP（开闭原则） 不修改已有类的前提下，通过增加新的工厂类实现拓展
 * 缺点是 类太多
 *
 */
public class test {
    public static void main(String[] args) {
        Car c1 = new baomaFactory().createCar();
        Car c2 = new benciFactory().createCar();
    }
}
