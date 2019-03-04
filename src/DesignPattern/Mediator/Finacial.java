package DesignPattern.Mediator;

public class Finacial implements Department {
    private Mediator m;

    public Finacial(Mediator m) {
        this.m = m;
        m.register("Finacial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("数钱！");
    }

    @Override
    public void outAction() {
        System.out.println("发送报告");
    }
}
