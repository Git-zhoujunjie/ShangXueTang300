package DesignPattern.TemplateMethod;

public abstract class BankTemplateMethod {
    //具体的方法模板如下：

    //1、
    public void takeNumber(){
        System.out.println("排队取号");
    }
    //2、抽象方法，具体的业务让子类实现
    public abstract void transact();
    //3、
    public void evaluate(){
        System.out.println("反馈评分");
    }

    //模板方法，子类不可重写
    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
