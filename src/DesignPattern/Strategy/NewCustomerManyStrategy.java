package DesignPattern.Strategy;

public class NewCustomerManyStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("打九折");
        return price*0.9;   //标准价格
    }
}
