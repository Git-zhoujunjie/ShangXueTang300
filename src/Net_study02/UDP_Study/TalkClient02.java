package Net_study02.UDP_Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 实现控制台连续发送信息
 * 发送端
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据，转成字节数组
 * 3、封装成DatagramPacket包裹，指定目的地
 * 4、发送包裹send(DatagramPacket p)
 * 5、释放资源
 */
public class TalkClient02 implements Runnable{
    String name;
    int port;
    String ip;
    int toPort;
    DatagramSocket client = null;

    public TalkClient02(String name, int port, String ip,int toPort) {
        this.name = name;
        this.port = port;
        this.ip = ip;
        this.toPort = toPort;

        //1、使用DatagramSocket 指定端口 创建发送端

        try {
            client = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {


        //2、控制台输入，System.in输入的是字节流，需要转换成字符流进行处理
        byte[] bytes;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String msg = null;
            try {
                msg = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            bytes = (this.name+":"+msg).getBytes();

            //3、封装成DatagramPacket包裹，指定目的地(套接字)
            DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length,
                    new InetSocketAddress(this.ip, this.toPort));
            //4、发送包裹send(DatagramPacket p)
            try {
                client.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (msg.contains("exit")) {//当消息等于exit时，退出循环
                break;
            }
        }
        //5、释放资源
        client.close();
    }


    public static void main(String[] args) throws Exception {
        //System.out.println("发送端启动中。。。");

        System.out.println("老师：exit".contains("exit"));
    }


}
