package DesignPattern.Factory.AbstractFactory;

public class LowCarFactory implements CarFactory {
    @Override
    public Engine creatEngine() {
        return new LowEngine();
    }

    @Override
    public Seat Seat() {
        return new LowSeat();
    }
}
