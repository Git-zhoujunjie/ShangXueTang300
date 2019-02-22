package DesignPattern.Factory.MethodFactory;

public class benciFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new benci();
    }
}
