package DesignPattern.Factory.SimpleFactory;

/**
 * 简易工厂模式
 */
public class CarFactory {
    public static Car createrCar(String type){
        if("baoma".equals(type)){
            return new baoma();
        }else if("benci".equals(type)){
            return new benci();
        }else return null;
    }
}

