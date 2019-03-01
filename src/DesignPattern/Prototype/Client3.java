package DesignPattern.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 使用序列化和反序列化实现深复制
 */
public class Client3 {
    public static void main(String[] args) throws Exception {
        Sheep s1 = new Sheep("少理",new Date(123435465453L));
        System.out.println(s1);
        //s1.setName("45653");
        System.out.println(s1.getName());
        System.out.println(s1.getBirthday());
        //序列化 ，将对象s1存储到字节缓冲流中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
        Sheep s2 = (Sheep) ois.readObject();

        s1.setName("45653");
        System.out.println(s1.getName());

        s2.setName("多利");
        System.out.println(s2);
        System.out.println(s2.getName());
        System.out.println(s2.getBirthday());
    }
}
