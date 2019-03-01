package DesignPattern.Proxy.DynamicProxy;

/**
 * 真实角色
 */
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    /**
     * 真实角色核心业务
     */
    @Override
    public void sing() {
        System.out.println("RealStar(Aimer本人).sing()");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
