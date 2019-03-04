package DesignPattern.Strategy;

public class Client {
    public static void main(String[] args) {
        Strategy strategy = new OldCustomerManyStrategy(); //选取策略方案

        double price = 998;

        new Context(strategy).printPrice(price);


    }
}
