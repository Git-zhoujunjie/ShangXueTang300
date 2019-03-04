package DesignPattern.Strategy;

public class NewCustomerFewStrategy implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("标准价格");
        return price;   //标准价格
    }
}
