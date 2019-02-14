package Net_study02.UDP_Study;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 实现控制台连续发送信息
 * 发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据，转成字节数组
 * 3、封装成DatagramPacket包裹，指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
public class TalkClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送端启动中。。。");
        //1、使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(9999);

        //2、控制台输入，System.in输入的是字节流，需要转换成字符流进行处理
        byte[] bytes;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = br.readLine();
            bytes = msg.getBytes();

            //3、封装成DatagramPacket包裹，指定目的地(套接字)
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length,
                    new InetSocketAddress("localhost", 8888));
            //4、发送包裹send(DatagramPacket p)
            client.send(packet);

            if (msg.equals("exit")) {//当消息等于exit时，退出循环
                break;
            }
        }
        //5、释放资源
        client.close();
    }
}
