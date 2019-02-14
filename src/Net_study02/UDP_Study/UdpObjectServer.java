package Net_study02.UDP_Study;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 利用UDP协议实现基本类型的传输
 * 接收端
 *  * 1、使用DatagramSocket 指定端口 创建接收端
 *  * 2、准备容器，封装成DatagramPacket包裹
 *  * 3、阻塞式接收包裹receive(DatagramPacket p)
 *  * 4、分析数据
 *  *      byte[] getData()
 *  *             getLength()
 *  * 5、释放资源
 *
 *  这里实现对象的传输（序列化与反序列化）
 *  Object
 */
public class UdpObjectServer {
    public static void main(String[] args) throws Exception {
        System.out.println("（对象的传输）接收端启动中。。。。。");

        DatagramSocket server = new DatagramSocket(22222);
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        server.receive(packet);

        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new BufferedInputStream(new ByteArrayInputStream(packet.getData())));
        ) {
        /*
        os.writeObject(new Employee("老王", 2000));
            os.writeInt(13);
            os.writeChar('z');
            os.writeUTF("Strings");
            os.writeObject(new String("字符串也是一个对象"));
            os.writeObject(new Date());
         */
            if (container != null) {
                Object o = ois.readObject();
                if (o instanceof Employee) {
                    System.out.println(((Employee) o).getName() + "--->" + ((Employee) o).getSalary());
                }

                System.out.println(ois.readInt());
                System.out.println(ois.readChar());
                System.out.println(ois.readUTF());
                Object o2 = ois.readObject();
                if (o2 instanceof String) {
                    System.out.println(o2);
                }
                Object o3 = ois.readObject();
                if (o3 instanceof Date) {
                    System.out.println(((Date) o3));
                }
            }
        }


        server.close();
    }
}
