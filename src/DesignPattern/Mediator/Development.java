package DesignPattern.Mediator;

/**
 * 研发部
 */
public class Development implements Department {
    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        m.register("Development",this);  //将部门名注册到中介者当中
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，研究项目！");
    }

    @Override
    public void outAction() {
        System.out.println("申请资金。。。");
        m.command("Finacial"); //向财务部申请资金，由总经理下发命令
    }
}
