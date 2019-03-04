package DesignPattern.Decorator;

/**
 * 测试装饰器模式
 */
public class Client {
    public static void main(String[] args) {
        ICar iCar = new Car(); //一辆具体的车

        iCar.move();

        Decorator superCar = new FlyCar(iCar);
        superCar.move();

        Decorator superCar2 = new WaterCar(new FlyCar(iCar));
        superCar2.move();
    }
}
