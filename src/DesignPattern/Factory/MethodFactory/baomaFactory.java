package DesignPattern.Factory.MethodFactory;

public class baomaFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new baoma();
    }
}
