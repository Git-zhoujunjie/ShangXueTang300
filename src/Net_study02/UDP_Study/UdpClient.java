package Net_study02.UDP_Study;

import java.net.*;

/**
 * 发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据，转成字节数组
 * 3、封装成DatagramPacket包裹，指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(9999);
        //、准备数据，转成字节数组
        String msg = "你好尚学堂qwertyu！";
        byte[] bytes = msg.getBytes();
        //3、封装成DatagramPacket包裹，指定目的地(套接字)
        DatagramPacket packet = new DatagramPacket(bytes,0,bytes.length,
                new InetSocketAddress("localhost",8888));
        //4、发送包裹send(DatagramPacket p)
        client.send(packet);
        //5、释放资源
        client.close();
    }
}
