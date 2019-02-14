package Net_study02.UDP_Study;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收方：
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备容器，封装成DatagramPacket包裹
 * 3、阻塞式接收包裹receive(DatagramPacket p)
 * 4、分析数据
 *      byte[] getData()
 *             getLength()
 * 5、释放资源
 */
public class UdpServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收端启动中。。。");
        //1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(8888);
        //2、准备容器，封装成DatagramPacket包裹
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //3、阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);

        //4、分析数据
        byte[] datas = packet.getData();
        String msg = new String(datas,0,packet.getLength());

        System.out.println(msg);
        //5、释放资源
        server.close();
    }
}
