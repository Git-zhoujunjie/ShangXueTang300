package DesignPattern.Factory.SimpleFactory;

/**
 * 简单工厂模式
 */
public class CarFactory02 {
    public static Car createrbaoma(){
        return new baoma();
    }

    public static Car createbenci(){
        return new benci();
    }
}

