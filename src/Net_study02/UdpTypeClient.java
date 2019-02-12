package Net_study02;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 利用UDP协议实现基本类型的传输
 * 发送端
 *    1、使用DatagramSocket 指定端口 创建发送端
 *  * 2、准备数据，转成字节数组
 *  * 3、封装成DatagramPacket包裹，指定目的地
 *  * 4、发送包裹send(DatagramPacket p)
 *  * 5、释放资源
 *
 *  这里实现基本数据类型的发送
 */
public class UdpTypeClient {
    public static void main(String[] args) throws Exception {
        System.out.println("（发送基本数据类型）发送端启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(10000);
        //2、将基本数据类型转换为字节流
        //基本数据类型需要用DataOutputStream进行写入，这里将写出的数据流进一步转换成直接字节数组流，便于传输
        byte[] datas = null;
        try (
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(bos));
        ) {
            dos.writeInt(222);
            dos.writeBoolean(true);
            dos.writeUTF("souniubi");
            dos.writeChar('v');
            dos.flush();

            datas = bos.toByteArray(); //将字节数组流存入字节数组
        }
        //3、封装成DatagramPacket包裹，指定目的地
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length,
                new InetSocketAddress("localhost", 11111));
        //4、发送包裹send(DatagramPacket p)
        client.send(packet);

        client.close();
    }
}
