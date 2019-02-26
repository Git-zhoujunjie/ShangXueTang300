package DesignPattern.Prototype;

/**
 * 原型模式：
 * 通过new产生一个对象需要非常繁琐的数据准备或访问权限时，可以使用原型模式
 * Spring中对象的创建实际上就是两种：单例模式和原型模式
 */
public class Client4 {
    public static void main(String[] args) throws Exception{
        test1();
        test2();
    }

    static void test1(){
        long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++){
            Car c = new Car();
        }
        long end = System.currentTimeMillis();

        System.out.println("通过new创建对象的耗时为："+(end-start));
    }

    static void test2() throws Exception {

        long start = System.currentTimeMillis();
        Car c = new Car();
        for(int i=0;i<1000;i++){
            Car c2 = (Car)c.clone();
        }
        long end = System.currentTimeMillis();

        System.out.println("通过clone创建对象的耗时为："+(end-start));
    }
}

class Car implements Cloneable{
    public Car() {
        try {
            Thread.sleep(10); //模拟创建对象的耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        return obj;
    }
}
