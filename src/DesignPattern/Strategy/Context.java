package DesignPattern.Strategy;

/**
 * 负责和具体的策略类交互
 * 这样的话，具体的算法和直接的客户端调用分离，使得算法可以独立于客户端独立的变化
 * 如果使用Spring的依赖注入功能，还可以通过配置文件，动态注入不同的策略对象，动态切换不同的算法
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) { //传入指定的策略方案
        this.strategy = strategy;
    }

    public void printPrice(double price){
        double realPrice = strategy.getPrice(price);
        System.out.println(realPrice);
    }
}
