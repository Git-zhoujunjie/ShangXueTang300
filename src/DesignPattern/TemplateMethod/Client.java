package DesignPattern.TemplateMethod;

public class Client {
    public static void main(String[] args) {
        BankTemplateMethod b1 = new QueryMoney();
        b1.process();

        //这里可以用匿名内部类实现
        BankTemplateMethod b2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("取钱！！！");
            }
        };
        b2.process();
    }
}


class QueryMoney extends BankTemplateMethod{
    @Override
    public void transact() {
        System.out.println("查询余额");
    }
}