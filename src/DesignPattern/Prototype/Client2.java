package DesignPattern.Prototype;

import java.util.Date;

public class Client2 {

    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep2 s1 = new Sheep2("少理",new Date(123435465453L));
        Sheep2 s2 = (Sheep2)s1.clone();  //

        //深复制
        s1.setBirthday(new Date(987656798765L));
        System.out.println(s1);
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());

        //s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
