package DesignPattern.Strategy;

public class OldCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("八五折");
        return price*0.85;   //标准价格
    }
}
