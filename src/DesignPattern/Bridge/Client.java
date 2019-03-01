package DesignPattern.Bridge;

/**
 * 测试桥接模式，主要用于解决多重继承的复杂性
 */
public class Client {
    public static void main(String[] args) {
        //销售戴尔笔记本
        Brand brand = new Dell();
        Computer computer = new Laptop(brand);
        computer.sale();

        //销售联想平板
        Brand brand1 = new Lenovo();
        Computer computer1 = new Pad(brand1);
        computer1.sale();

        //销售神舟移动
        Brand brand2 = new Shenzhou();
        Computer computer2 = new Mobile(brand2);
        computer2.sale();
    }
}
