package Net_study02.UDP_Study;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 用线程实现连续接受信息，用于双向交流
 * 接收方：
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据
 *      byte[] getData()
 *             getLength()
 * 5、释放资源
 */
public class TalkServer02 implements Runnable{
    String name;
    int port;
    DatagramSocket server;

    public TalkServer02(String name, int port) {
        this.name = name;
        this.port = port;
        //1、使用DatagramSocket 指定端口 创建接收端

        try {
            server = new DatagramSocket(this.port);
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        while(true) {
            //2、准备容器，封装成DatagramPacket包裹
            byte[] container = new byte[1024*60];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);

            //3、阻塞式接收包裹receive(DatagramPacket p)
            try {
                server.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //4、分析数据

            byte[] datas = packet.getData();

            String msg= new String(datas, 0, packet.getLength());

            if(msg.contains("exit")) {
                System.out.println(msg);
                break;
            }
            System.out.println(msg);
        }
        //5、释放资源
        server.close();
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println("接收端启动中。。。");
//    }
}
