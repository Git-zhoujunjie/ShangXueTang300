package DesignPattern.Prototype;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 测试原型模式，浅克隆，即克隆对象的属性地址指向源对象的属性地址，例如下例中的Date
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Sheep s1 = new Sheep("少理",new Date(123435465453L));

        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Sheep s2 = (Sheep)s1.clone();  //新对象地址不同，属性相同
        //s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
