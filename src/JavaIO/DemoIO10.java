package JavaIO;

import java.io.*;
import java.util.Date;

/**
 * 测试对象流，也叫序列化和反序列化
 * ObjectOutputStream：将对象序列化为字节流
 * ObjectInputStream：将字节流还原为对象
 * 1.先写出后读取
 * 2.读取顺序要和写出保持一致
 * 3.只有实现Serializable的接口才能序列化
 */
public class DemoIO10 {

    public static void main(String[] args) throws ClassNotFoundException {
        test();
    }

    public static void test() throws ClassNotFoundException {
        //需要先写出到DataOutputStream中，然后再用DataInputStream读取
        byte[] bytes = null;
        try(
                OutputStream os = new FileOutputStream("ss.asd");
                ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(os));
                InputStream fis =new FileInputStream("ss.asd");
        ){
            dos.writeInt(4354);
            dos.writeBoolean(true);
            dos.writeChar('g');
            dos.writeUTF("中国人safd");

            dos.writeObject(new String("字符串也是一个对象"));
            dos.writeObject(new Date());
            dos.writeObject(new Employee("周俊杰",0.01));

            dos.flush();

            bytes = fis.readAllBytes();

            InputStream is = new ByteArrayInputStream(bytes);//字节数组流可以不用关闭
            ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(is));

            //读取顺序必须和写入顺序一致
            if(bytes!=null) {
                System.out.println(dis.readInt());
                System.out.println(dis.readBoolean());
                System.out.println(dis.readChar());
                System.out.println(dis.readUTF());

                Object obj = dis.readObject();
                if(obj instanceof String){  //对象需要进行强制转化
                    String str = (String)obj;
                    System.out.println(str);
                }
                Object obj2 = dis.readObject();
                if(obj2 instanceof Date){
                    Date date = (Date)obj2;
                    System.out.println(date);
                }
                Object obj3 = dis.readObject();
                if(obj3 instanceof Employee){
                    Employee ob = (Employee)obj3;
                    System.out.println(ob.getName()+"--->"+ob.getSalary());
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}

//JavaBean
class Employee implements Serializable{ //若要对这个类进行序列化，要实现Serializable接口

    private transient String name; //transient 表示该数据不可序列化
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}