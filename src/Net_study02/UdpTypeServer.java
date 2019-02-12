package Net_study02;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

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
 *  这里实现基本数据类型点传输
 */
public class UdpTypeServer {
    public static void main(String[] args) throws Exception {
        System.out.println("（接收基本数据类型）接收端启动中。。。。。");
        //1、使用DatagramSocket 指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(11111);
        //2、准备容器，封装成DatagramPacket包裹
        byte[] container = new byte[1024 * 60];
        DatagramPacket packet = new DatagramPacket(container, 0, container.length);
        //3、阻塞式接收包裹receive(DatagramPacket p)
        server.receive(packet);

        //4、分析数据，基本数据类型需要用DataInputStream进行接收
        try (
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(
                                new ByteArrayInputStream(packet.getData())));
        ) {/*
        dos.writeInt(222);
        dos.writeBoolean(true);
        dos.writeUTF("souniubi");
        dos.writeChar('v');
        dos.flush();
         */
            System.out.println(dis.readInt());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readUTF());
            System.out.println(dis.readChar());
        }
        //5、
        server.close();

    }
}
