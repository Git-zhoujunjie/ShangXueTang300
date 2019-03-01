package DesignPattern.Adapter;

/**
 * 要适配的对象
 * adaptee相当于ps/2键盘
 */
public class Adaptee {
    public void request(){
        System.out.println("实现客户需要的功能（指打字）");
    }
}
