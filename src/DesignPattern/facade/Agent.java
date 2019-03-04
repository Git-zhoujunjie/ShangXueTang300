package DesignPattern.facade;

public class Agent {
    public void work(){
        new 买票().work();
        new 协商().work();
        new 签合同().work();
        new 付钱().work();
    }
}
