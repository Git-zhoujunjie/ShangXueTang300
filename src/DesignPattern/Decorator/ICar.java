package DesignPattern.Decorator;

/**
 * 实现一个装饰器模式，给一辆汽车添加新功能
 */

/**
 * 抽象组件
 */
public interface ICar {
    void move();
}

/**
 * 真实构件
 */
class Car implements ICar{
    @Override
    public void move() {
        System.out.println("陆地上跑。。。");
    }
}

/**
 * 装饰器
 */
abstract class Decorator implements ICar{
    protected ICar car;
    public Decorator(ICar car){
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

/**
 * 具体装饰对象
 */
class FlyCar extends Decorator{
    public FlyCar(ICar car) {
        super(car);
    }

    private void fly(){
        System.out.println("天上飞！！");
    }
    @Override
    public void move() {
        super.move();
        fly();
    }
}

class WaterCar extends Decorator{
    public WaterCar(ICar car) {
        super(car);
    }

    private void swim(){
        System.out.println("水中游！！");
    }
    @Override
    public void move() {
        super.move();
        swim();
    }
}