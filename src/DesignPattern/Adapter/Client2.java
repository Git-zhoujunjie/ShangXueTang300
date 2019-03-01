package DesignPattern.Adapter;

/**
 * 实现一个笔记本电脑，USB转ps/2接口，ps/2键盘的适配器模式
 * Client相当于笔记本电脑
 */
public class Client2 {

    /**
     * 相当于笔记本电脑连接适配器
     * @param t
     */
    public void test(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        Adaptee a = new Adaptee(); //ps2键盘
        Target t = new Adapter2(a); //转接器
        Client2 c = new Client2(); //笔记本刚电脑

        c.test(t);
    }

}


