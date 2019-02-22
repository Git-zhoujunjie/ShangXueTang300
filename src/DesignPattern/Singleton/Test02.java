package DesignPattern.Singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 测试反射破解单例模式（不包括枚举单例）
 */
public class Test02 {
    public static void main(String[] args) throws Exception {
        Demo04 s1 = Demo04.getInstance();
        Demo04 s2 = Demo04.getInstance();
        System.out.println(s1);
        System.out.println(s2);
        Demo05 s3 = Demo05.INSTANCE;
        Demo05 s4 = Demo05.INSTANCE;
        System.out.println(s3 == s4);

        //通过反射破解单例，直接调用私有构造器
//        Class<Demo02> clz = (Class<Demo02>) Class.forName("DesignPattern.Singleton.Demo02");
//        Constructor<Demo02> constructor = clz.getDeclaredConstructor(null);
//        constructor.setAccessible(true);   //破解单例
//        Demo02 d1 = constructor.newInstance();
//        Demo02 d2 = constructor.newInstance();
//        Demo02 d3 = constructor.newInstance();
//
//        System.out.println(d1);
//        System.out.println(d2);
//        System.out.println(d3);

        //通过序列化和反序列化破解单例
        //先将对象存到硬盘上
        Demo06 d6 = Demo06.getInstance();
        System.out.println(d6);
        OutputStream os = new ObjectOutputStream(new FileOutputStream(new File("d:/a.txt")));

        ((ObjectOutputStream) os).writeObject(d6);
        os.flush();
        os.close();
        //然后读出
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/a.txt"));
        Demo06 d7 = (Demo06)ois.readObject();
        System.out.println(d7);
    }
}
