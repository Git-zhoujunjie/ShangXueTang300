package DesignPattern.Strategy;

public class OldCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("八折");
        return price*0.8;   //标准价格
    }
}
