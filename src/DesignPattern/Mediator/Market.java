package DesignPattern.Mediator;

public class Market implements Department {
    private Mediator m;

    public Market(Mediator m) {
        this.m = m;
        m.register("Market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("联系客户！");
    }

    @Override
    public void outAction() {
        System.out.println("发送报告，需要资金支持");
        m.command("Finacial");   //向财务部申请资金，由总经理下发命令
    }
}
