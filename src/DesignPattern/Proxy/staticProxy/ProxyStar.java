package DesignPattern.Proxy.staticProxy;

/**
 * 代理角色
 */
public class ProxyStar implements Star{

    private Star star;
    //通过构造器传入代理人需要代理的真实角色，处理真实角色核心业务外的业务
    public ProxyStar(Star star){
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer()");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");
    }

    /**
     * 代理人唯独不能唱歌
     */
    @Override
    public void sing() {
        star.sing();
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.collectMoney()");
    }
}
