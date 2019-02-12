package Net_study02;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 利用UDP协议实现基本类型的传输
 * 发送端
 *    1、使用DatagramSocket 指定端口 创建发送端
 *  * 2、准备数据，转成字节数组
 *  * 3、封装成DatagramPacket包裹，指定目的地
 *  * 4、发送包裹send(DatagramPacket p)
 *  * 5、释放资源
 *
 *  这里实现对象的发送
 *  对象流，也叫序列化和反序列化
 *  * ObjectOutputStream：将对象序列化为字节流
 *  * ObjectInputStream：将字节流还原为对象
 *  * 1.先写出后读取
 *  * 2.读取顺序要和写出保持一致
 *  * 3.只有实现Serializable的接口才能序列化
 */
public class UdpObjectClient {
    public static void main(String[] args) throws Exception {
        System.out.println("（对象的发送）发送端启动中。。。。。");

        DatagramSocket client = new DatagramSocket(20000);

        byte[] datas = null;
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(bos));
        ) {
            os.writeObject(new Employee("老王", 2000));
            os.writeInt(13);
            os.writeChar('z');
            os.writeUTF("Strings");
            os.writeObject(new String("字符串也是一个对象"));
            os.writeObject(new Date());
            os.flush();

            datas = bos.toByteArray();
        }

        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 22222));
        client.send(packet);

        client.close();
    }
}
