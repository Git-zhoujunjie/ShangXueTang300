package DesignPattern.Factory.AbstractFactory;

public interface Seat {
    void anmo();
}

class LuxurySeat implements Seat{
    @Override
    public void anmo() {
        System.out.println("舒服");
    }
}

class LowSeat implements Seat{
    @Override
    public void anmo() {
        System.out.println("难受");
    }
}
