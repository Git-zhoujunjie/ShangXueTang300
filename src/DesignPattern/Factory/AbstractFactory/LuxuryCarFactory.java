package DesignPattern.Factory.AbstractFactory;

public class LuxuryCarFactory implements CarFactory {
    @Override
    public Engine creatEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat Seat() {
        return new LuxurySeat();
    }
}
